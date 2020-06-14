package cn.ibizlab.ehr.core.util.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import cn.ibizlab.ehr.util.helper.UniqueNameGenerator;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import java.util.Properties;

/**
 * mybatis全局配置类
 */
@Configuration
@MapperScan(value="cn.ibizlab.ehr.core.*.mapper",nameGenerator = UniqueNameGenerator.class)
public class MybatisConfiguration {

    /**
     * mybatis适配多数据库
     * @return
     */
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties p = new Properties();
        p.setProperty("Oracle", "oracle");
        p.setProperty("MySQL", "mysql");
        p.setProperty("PostgreSQL", "postgresql");
        p.setProperty("DM", "oracle");//达梦数据库使用oracle模式
        p.setProperty("H2", "mysql");//根据当前运行的数据库设置h2对应的databaseid
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }

    /**
     * mybatis-plus分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}