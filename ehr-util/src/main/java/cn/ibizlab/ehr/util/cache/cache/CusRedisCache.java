package cn.ibizlab.ehr.util.cache.cache;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;

/**
 * 自定义的redis缓存
 */
public class CusRedisCache extends RedisCache {

    public CusRedisCache(String name, RedisCacheWriter redisCacheWriter, RedisCacheConfiguration configuration) {
        super(name, redisCacheWriter, configuration);
    }
}
