package cn.ibizlab.ehr.util.service;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 自定义feigen客户端配置
 *
 * @author
 */
@Service
public class RemoteService {

    /**
     * FeignClientFactoryBean
     */
    @Autowired
    protected FeignContext feignContext;

    /**
     * FeignClient 默认LoadBalancerFeignClient
     */
    @Autowired
    private Client feignClient;


    private static final Map<String, Object> FEIGN_CLIENTS = new ConcurrentHashMap<>();

    /**
     * 定义远程通用接口
     */
    public interface RemoteFeignClient {
        @RequestMapping(method = RequestMethod.POST, value = "/{path}")
        JSONObject post( @PathVariable("path") String path, @RequestHeader("Authorization") String token,@RequestBody Map  param);

        @RequestMapping(method = RequestMethod.GET, value = "/{path}")
        JSONObject request( @PathVariable("path") String path, @RequestHeader("Authorization") String token,Map  param);

        @RequestMapping(method = RequestMethod.GET, value = "/{path}")
        JSONObject get( @PathVariable("path") String path, @RequestHeader("Authorization") String token);

        @RequestMapping(method = RequestMethod.PUT, value = "/{path}")
        JSONObject put( @PathVariable("path") String path, @RequestHeader("Authorization") String token,@RequestBody Map  param);

        @RequestMapping(method = RequestMethod.DELETE, value = "/{path}")
        JSONObject delete( @PathVariable("path") String path, @RequestHeader("Authorization") String token);
    }

    /**
     * @param serverId
     * @return
     */
    public RemoteFeignClient getClient(String serverId) {
        return this.create(RemoteFeignClient.class, serverId);
    }

    /**
     * 设置编码解码器为FastJson
     *
     * @param clazz
     * @param serviceId
     * @param <T>
     * @return
     */
    private synchronized <T> T create(Class<T> clazz, String serviceId) {
        Object object = FEIGN_CLIENTS.get(serviceId);
        if (Objects.isNull(object)) {
            object = Feign.builder()
                    //decoder指定对象解码方式
                    .decoder(this.feignDecoder())
                    .encoder(this.feignEncoder())
                    .client(feignClient)
                    //options方法指定连接超时时长及响应超时时长
                    .options(new Request.Options(5000, 50000))
                    //retryer方法指定重试策略
                    //.retryer(new Retryer.Default(5000, 5000, 3))
                    .contract(feignContext.getInstance(serviceId, Contract.class))
                    //target方法绑定接口与服务端地址。返回类型为绑定的接口类型。
                    .target(clazz, "http://"+serviceId);
            FEIGN_CLIENTS.put(serviceId, object);
        }

        return (T) object;
    }

    private Decoder feignDecoder() {
        return new SpringDecoder(feignHttpMessageConverter());
    }

    private Encoder feignEncoder() {
        return new SpringEncoder(feignHttpMessageConverter());
    }


    private ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter(new ObjectMapper());
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(jsonConverter);
        return () -> httpMessageConverters;
    }


}