package cn.ibizlab.ehr.util.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class LiquibaseProp{

    private  String url;

    private  String username;

    private  String password;

    private  String isSyncDBSchema;

    private  String defaultSchema;

    private  String  conf;
}