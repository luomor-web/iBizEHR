package cn.ibizlab.ehr.wfcallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import java.util.List;

@Slf4j
@EnableDiscoveryClient
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"cn.ibizlab.ehr"})
@EnableMongoRepositories(basePackages = {"cn.ibizlab.ehr"})
@MapperScan("cn.ibizlab.ehr.*.mapper")
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
})
@EnableFeignClients(basePackages = {"cn.ibizlab.ehr" })
public class ehrWFCallbackApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(ehrWFCallbackApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new cn.ibizlab.ehr.util.web.SearchContextHandlerMethodArgumentResolver());
    }
}
