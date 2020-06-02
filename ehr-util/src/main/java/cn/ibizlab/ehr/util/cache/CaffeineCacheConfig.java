package cn.ibizlab.ehr.util.cache;

import com.github.benmanes.caffeine.cache.CaffeineSpec;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;
import cn.ibizlab.ehr.util.cache.cacheManager.CaffeineCacheManager;

/**
 * Caffeine缓存配置类
 */
@EnableCaching
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@ConditionalOnExpression("'${ibiz.cacheLevel:None}'.equals('L1')")
public class CaffeineCacheConfig {

    /**
     * Caffeine配置：设置过期时间
     * @return
     */
    @Bean
    @Primary
    public CacheManager cacheManager(CacheProperties cacheProperties) {
        CaffeineCacheManager caffeineCacheManager=new CaffeineCacheManager();
        String strCacheConfig = cacheProperties.getCaffeine().getSpec();
        if (StringUtils.hasText(strCacheConfig)) {
            caffeineCacheManager.setCaffeineCacheConfig(CaffeineSpec.parse(strCacheConfig));
        }
        return caffeineCacheManager;
    }

}