package cn.ibizlab.ehr.util.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.SneakyThrows;
import cn.ibizlab.ehr.util.client.IBZUAAFeignClient;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@ConditionalOnExpression("${ibiz.enablePermissionValid:false}||'${ibiz.auth.token.util:SimpleTokenUtil}'.equals('UAATokenUtil')")
public class UAATokenUtil implements AuthTokenUtil, Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    private Clock clock = DefaultClock.INSTANCE;
    @Value("${ibiz.jwt.secret:ibzsecret}")
    private String secret;

    @Value("${ibiz.jwt.expiration:7200000}")
    private Long expiration;

    @Value("${ibiz.jwt.header:Authorization}")
    private String tokenHeader;

    @Autowired
    private IBZUAAFeignClient uaaFeignClient;


    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        PublicKey publicKey = getPublicKey(getPublicKeyString());
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    public String generateToken(UserDetails userDetails) {
        return null;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        AuthenticationUser user = (AuthenticationUser) userDetails;
        final Date created = getIssuedAtDateFromToken(token);
        return (!isTokenExpired(token) );
    }


    private String getPublicKeyString(){
        return uaaFeignClient.getPublicKey();
    }

    /**
     * 获取PublicKey对象
     * @param publicKeyBase64
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    @SneakyThrows
    public PublicKey getPublicKey(String publicKeyBase64) {
        byte[] byteKey = Base64.decodeBase64(publicKeyBase64);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byteKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

}

