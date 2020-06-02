package cn.ibizlab.ehr.util.cache.cacheManager;

import lombok.Data;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import cn.ibizlab.ehr.util.cache.cache.CusRedisCache;
import cn.ibizlab.ehr.util.cache.cache.LayeringCache;

/**
 * 缓存分层
 * 1级缓存为caffeine
 * 2级缓存为redis
 */
@Data
public class LayeringCacheManager implements CacheManager {

    private final ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>(16);
    private static final int default_expire_after_write = 1;
    private static final int default_initial_capacity = 5;
    private static final int default_maximum_size = 1_000;
    private Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder()
            .expireAfterAccess(default_expire_after_write, TimeUnit.HOURS)
            .initialCapacity(default_initial_capacity)
            .maximumSize(default_maximum_size);

    private RedisCacheWriter redisCacheWriter;
    private RedisCacheConfiguration redisConfiguration;
    private RedisTemplate<String, Object> redisTemplate;

    public LayeringCacheManager(RedisCacheWriter redisCacheWriter , RedisCacheConfiguration redisConfiguration , RedisTemplate<String, Object> redisTemplate ){
        this.redisCacheWriter=redisCacheWriter;
        this.redisConfiguration=redisConfiguration;
        this.redisTemplate= redisTemplate;
    }

    /**
     * 获取缓存对象
     * @param cacheName
     * @return
     */
    @Override
    public Cache getCache(String cacheName) {
        Cache cache = this.cacheMap.get(cacheName);
        if (cache == null) {
            synchronized (this.cacheMap) {
                cache = this.cacheMap.get(cacheName);
                if (cache == null) {
                    cache = createCache(cacheName);
                    this.cacheMap.put(cacheName, cache);
                }
            }
        }
        return cache;
    }

    /**
     * 获取集合中的缓存
     * @return
     */
    @Override
    public Collection<String> getCacheNames() {
        return Collections.unmodifiableSet(this.cacheMap.keySet());
    }

    /**
     * 创建缓存
     * @param cacheName
     * @return
     */
    protected Cache createCache(String cacheName) {
        return new LayeringCache(cacheName,new CaffeineCache(cacheName, this.cacheBuilder.build(), true),new CusRedisCache(cacheName, redisCacheWriter, redisConfiguration),redisTemplate);
    }

    /**
     * 缓存配置[缓存容量大小、时长等]
     * @param caffeineCacheConfig
     */
    public void setCaffeineCacheConfig(CaffeineSpec caffeineCacheConfig) {
        Caffeine<Object, Object> cacheBuilder = Caffeine.from(caffeineCacheConfig);
        if (!ObjectUtils.nullSafeEquals(this.cacheBuilder, cacheBuilder)) {
            this.cacheBuilder = cacheBuilder;
        }
    }
}
