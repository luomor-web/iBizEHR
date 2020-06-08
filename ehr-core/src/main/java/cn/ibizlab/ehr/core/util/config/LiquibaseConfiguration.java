package cn.ibizlab.ehr.core.util.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import java.util.Properties;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import cn.ibizlab.ehr.util.domain.LiquibaseProp;
import org.springframework.beans.factory.annotation.Autowired;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.util.StringUtils;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;

@Configuration
public class LiquibaseConfiguration {

   /**
     * 主数据源版本管理
     * @param
     * @return
     */
    @Bean
    public SpringLiquibase masterliquibase(LiquibaseProp masterProperties) {
        return LiquibaseInit(masterProperties);
    }

    /**
     * liquibase初始化数据库
     * @param properties
     * @return
     */
   private SpringLiquibase LiquibaseInit(LiquibaseProp properties){
       DruidDataSource druidDataSource = new DruidDataSource();
       druidDataSource.setUsername(properties.getUsername());
       druidDataSource.setPassword(properties.getPassword());
       druidDataSource.setUrl(properties.getUrl());

       SpringLiquibase liquibase = new SpringLiquibase();
       liquibase.setDataSource(druidDataSource);
       liquibase.setChangeLog(getChangelog(properties.getIsSyncDBSchema(),properties.getConf()));
       liquibase.setContexts("development,test,production");
       liquibase.setShouldRun(true);
       liquibase.setDefaultSchema(properties.getDefaultSchema());
       return liquibase;
   }
    /**
     * 获取数据库差异文件
     * @param isSyncDBSchema  是否同步表结构
     * @param conf  //liquibase配置文件
     * @return
     */
    private String getChangelog(String isSyncDBSchema,String conf){
        String defaultChangelog="classpath:liquibase/empty.xml";

        if((!StringUtils.isEmpty(isSyncDBSchema))&&(!StringUtils.isEmpty(conf))){
            if(isSyncDBSchema.toLowerCase().equals("true"))
                defaultChangelog=conf;
        }
            return defaultChangelog;
    }

}