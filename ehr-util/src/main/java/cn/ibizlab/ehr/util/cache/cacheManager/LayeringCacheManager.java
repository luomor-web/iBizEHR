package cn.ibizlab.ehr.util.cache.cacheManager;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import lombok.Data;
import cn.ibizlab.ehr.util.cache.cache.LayeringCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * 缓存分层类
 * 1级缓存为caffeine
 * 2级缓存为redis
 */
@Data
@Component
@ConditionalOnProperty("ibiz.enableRedisCache")
public class LayeringCacheManager implements CacheManager {

    private static final int DEFAULT_EXPIRE_AFTER_WRITE = 1;
    private static final int DEFAULT_INITIAL_CAPACITY = 5;
    private static final int DEFAULT_MAXIMUM_SIZE = 1_000;
    private final ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>(16);
    public RedisCacheWriter redisCacheWriter;
    public RedisCacheConfiguration redisConfiguration;
    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    /**
     * 缓存默认设置
     */
    private Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder()
            .expireAfterAccess(DEFAULT_EXPIRE_AFTER_WRITE, TimeUnit.HOURS)
            .initialCapacity(DEFAULT_INITIAL_CAPACITY)
            .maximumSize(DEFAULT_MAXIMUM_SIZE);

    /**
     * 获取缓存对象
     * @param name
     * @return
     */
    @Override
    public Cache getCache(String name) {
        Cache cache = this.cacheMap.get(name);
        if (cache == null) {
            synchronized (this.cacheMap) {
                cache = this.cacheMap.get(name);
                if (cache == null) {
                    cache = createCache(name);
                    this.cacheMap.put(name, cache);
                }
            }
        }
        return cache;
    }

    @Override
    public Collection<String> getCacheNames() {
        return Collections.unmodifiableSet(this.cacheMap.keySet());
    }

    protected Cache createCache(String name) {
        return new LayeringCache(name,redisTemplate,this.cacheBuilder.build(),redisCacheWriter,redisConfiguration);
    }

    /**
     * 使用该CacheManager的当前状态重新创建已知的缓存
     */
    private void refreshKnownCaches() {
        for (Map.Entry<String, Cache> entry : this.cacheMap.entrySet()) {
            entry.setValue(createCache(entry.getKey()));
        }
    }

    public void setCaffeineSpec(CaffeineSpec caffeineSpec) {
        Caffeine<Object, Object> cacheBuilder = Caffeine.from(caffeineSpec);
        if (!ObjectUtils.nullSafeEquals(this.cacheBuilder, cacheBuilder)) {
            this.cacheBuilder = cacheBuilder;
            refreshKnownCaches();
        }
    }

}
