package cn.ibizlab.ehr.util.cache;

import com.github.benmanes.caffeine.cache.CaffeineSpec;
import cn.ibizlab.ehr.util.cache.cacheManager.CaffeineCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

/**
 * Caffeine缓存配置类
 */
@EnableCaching
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@ConditionalOnExpression("'${ibiz.cacheLevel:None}'.equals('L1')")
public class CaffeineCacheConfig {

    @Autowired
    private CacheProperties cacheProperties;

    @Autowired
    private CaffeineCacheManager caffeineCacheManager;

    @Bean
    @Primary
    public CacheManager cacheManager() {
        String specification = cacheProperties.getCaffeine().getSpec();
        if (StringUtils.hasText(specification)) {
            caffeineCacheManager.setCaffeineSpec(CaffeineSpec.parse(specification));
        }
        return caffeineCacheManager;
    }
}