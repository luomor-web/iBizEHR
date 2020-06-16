package cn.ibizlab.ehr.ehrsoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

@Slf4j
@Import({
    FeignClientsConfiguration.class
})
@EnableDiscoveryClient
@Configuration
@EnableFeignClients(basePackages = {"cn.ibizlab.ehr" })
@EnableZuulProxy
@ComponentScan(basePackages = {"cn.ibizlab.ehr.ehrsoc","cn.ibizlab.ehr.util"})
@MapperScan("cn.ibizlab.ehr.*.mapper")
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
})
public class EHRSocApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(EHRSocApplication.class,args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new cn.ibizlab.ehr.util.web.SearchContextHandlerMethodArgumentResolver());
    }
}
