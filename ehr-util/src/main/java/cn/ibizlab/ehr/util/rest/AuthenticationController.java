
package cn.ibizlab.ehr.util.rest;

import cn.ibizlab.ehr.util.security.AuthenticationInfo;
import cn.ibizlab.ehr.util.security.AuthenticationUser;
import cn.ibizlab.ehr.util.security.AuthorizationLogin;
import cn.ibizlab.ehr.util.security.AuthTokenUtil;
import cn.ibizlab.ehr.util.service.AuthenticationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@RestController
@RequestMapping("/")
@ConditionalOnProperty( name = "ibiz.enablePermissionValid", havingValue = "false")
public class AuthenticationController
{

    @Value("${ibiz.jwt.header:Authorization}")
    private String tokenHeader;

    @Autowired
    private AuthTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationUserService userDetailsService;

    @PostMapping(value = "${ibiz.auth.path:v7/login}")
    public ResponseEntity<AuthenticationInfo> login(@Validated @RequestBody AuthorizationLogin authorizationLogin){
        userDetailsService.resetByUsername(authorizationLogin.getUsername());
        final AuthenticationUser authuserdetail = userDetailsService.loadUserByLogin(authorizationLogin.getUsername(),authorizationLogin.getPassword());
        // 生成令牌
        final String token = jwtTokenUtil.generateToken(authuserdetail);
        // 返回 token
        return ResponseEntity.ok().body(new AuthenticationInfo(token,authuserdetail));
    }

    @GetMapping(value = "${ibiz.auth.account:ibizutil/account}")
    public ResponseEntity<AuthenticationUser> getUserInfo(){
        UserDetails userDetails = (UserDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthenticationUser authuserdetail=new AuthenticationUser();
        if(userDetails==null){
            throw new RuntimeException("未能获取用户信息");
        }
        else if(userDetails instanceof AuthenticationUser ) {
            authuserdetail= (AuthenticationUser)userDetails;
        }
        else {
            authuserdetail= userDetailsService.loadUserByUsername(userDetails.getUsername());
        }
            return ResponseEntity.ok().body(authuserdetail);
        }
}
