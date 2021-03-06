package cn.ibizlab.ehr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.ComponentScan;
import java.util.List;

@Slf4j
@EnableDiscoveryClient
@Configuration
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"cn.ibizlab.ehr" })
@SpringBootApplication(exclude = {
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
})
@ComponentScan(basePackages = {"cn.ibizlab.ehr"}
//        ,excludeFilters={
//                @ComponentScan.Filter(type= org.springframework.context.annotation.FilterType.REGEX,pattern="cn.ibizlab.ehr.xxx.rest.xxx"),
//        }
)
@Import({
        org.springframework.cloud.openfeign.FeignClientsConfiguration.class
})
public class DevBootApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(DevBootApplication.class,args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new cn.ibizlab.ehr.util.web.SearchContextHandlerMethodArgumentResolver());
    }
}
