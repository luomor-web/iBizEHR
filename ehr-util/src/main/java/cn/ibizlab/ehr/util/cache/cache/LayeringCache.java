package cn.ibizlab.ehr.util.cache.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.AbstractValueAdaptingCache;
import org.springframework.cache.support.NullValue;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisOperations;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import cn.ibizlab.ehr.util.cache.listener.RedisPublisher;
import cn.ibizlab.ehr.util.enums.RedisChannelTopic;

/**
 * 缓存分层类
 * 1级缓存为caffeine
 * 2级缓存为redis
 */
@Slf4j
public class LayeringCache extends AbstractValueAdaptingCache {

    /**
     * 缓存的名称
     */
    private String cacheName;
    /**
     * Caffeine缓存
     */
    private CaffeineCache caffeineCache;
    /**
     * redis缓存
     */
    private RedisCache redisCache;
    /**
     * redis消息发布
     */
    RedisOperations<? extends Object, ? extends Object> redisOperations;

    public LayeringCache(String cacheName , CaffeineCache caffeineCache, RedisCache redisCache, RedisOperations redisOperations) {
        super(true);
        this.cacheName = cacheName;
        this.caffeineCache = caffeineCache;
        this.redisCache = redisCache;
        this.redisOperations=redisOperations;
    }

    @Override
    public String getName() {
        return this.cacheName;
    }

    @Override
    public Object getNativeCache() {
        return this;
    }

    @Override
    public ValueWrapper get(Object key) {
        ValueWrapper wrapper = caffeineCache.get(key);
        log.debug("查询一级缓存 key:{}，value:{}", key,wrapper);
        if (wrapper == null) {
            wrapper = redisCache.get(key);
            caffeineCache.put(key, wrapper == null ? null : wrapper.get());
            log.debug("查询二级缓存,并将数据放到一级缓存。 key:{}", key);
        }
        return wrapper;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        T value = caffeineCache.get(key, type);
        log.debug("查询一级缓存 key:{}", key);
        if (value == null) {
            value = redisCache.get(key, type);
            caffeineCache.put(key, value);
            log.debug("查询二级缓存,并将数据放到一级缓存。 key:{}", key);
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        T value = (T) caffeineCache.getNativeCache().get(key, k -> getSecondCacheValue(k, valueLoader));
        if(value==null) {
            value = (T) getSecondCacheValue(key, valueLoader);
        }
        if (value instanceof NullValue) {
            return null;
        }
        return value;
    }

    @Override
    public void put(Object key, Object value) {
        caffeineCache.put(key, value);
        redisCache.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        caffeineCache.putIfAbsent(key, value);
        return redisCache.putIfAbsent(key, value);
    }

    @Override
    public void evict(Object key) {
        redisCache.evict(key); //清除redis中的二级缓存
        caffeineCache.evict(key);//清除本机一级缓存
        Map<String, Object> message = new HashMap<>();
        message.put("cacheName", cacheName);
        message.put("key", key);
        RedisPublisher redisPublisher = new RedisPublisher(redisOperations, RedisChannelTopic.REDIS_CACHE_DELETE_TOPIC.getChannelTopic());// 创建redis发布者
        redisPublisher.publisher(message);//发布消息，清除其它集群机器中的一级缓存
        log.debug(String.format("清除二级缓存数据[%s]", key));
    }

    @Override
    public void clear() {
        redisCache.clear(); //清除redis中的二级缓存
        caffeineCache.clear();//清除本机一级缓存
        Map<String, Object> message = new HashMap<>();
        message.put("cacheName", cacheName);
        RedisPublisher redisPublisher = new RedisPublisher(redisOperations, RedisChannelTopic.REDIS_CACHE_CLEAR_TOPIC.getChannelTopic());// 创建redis发布者
        redisPublisher.publisher(message);//发布消息，清除其它集群机器中的一级缓存
    }

    @Override
    protected Object lookup(Object key) {
        Object value = caffeineCache.get(key);
        log.debug("查询一级缓存 key:{}", key);
        if (value == null) {
            value = redisCache.get(key);
            log.debug("查询二级缓存 key:{}", key);
        }
        return value;
    }

    /**
     * 获取caffeine缓存
     * @return
     */
    public CaffeineCache getFirstCache() {
        return this.caffeineCache;
    }

    /**
     * 获取redis缓存
     * @return
     */
    public RedisCache getSecondCache() {
        return this.redisCache;
    }

    /**
     * 查询二级缓存
     * @param key
     * @param valueLoader
     * @return
     */
    private <T> Object getSecondCacheValue(Object key, Callable<T> valueLoader) {
        T value = redisCache.get(key, valueLoader);
        log.debug("查询二级缓存 key:{}", key);
        return toStoreValue(value);
    }
}
