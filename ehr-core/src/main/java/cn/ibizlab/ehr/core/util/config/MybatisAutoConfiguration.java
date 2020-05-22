package cn.ibizlab.ehr.core.util.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis自动配置
 */
@Configuration
@ConditionalOnClass(MybatisConfiguration.class)
@ConditionalOnWebApplication
public class MybatisAutoConfiguration {

	
}
