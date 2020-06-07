package cn.ibizlab.ehr.util.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import java.time.Duration;
import cn.ibizlab.ehr.util.cache.cacheManager.LayeringCacheManager;
import cn.ibizlab.ehr.util.cache.listener.RedisMessageListener;
import cn.ibizlab.ehr.util.cache.redis.CustomJacksonSerializer;
import cn.ibizlab.ehr.util.enums.RedisChannelTopic;

/**
 * 缓存配置类
 * 1级缓存为caffeine
 * 2级缓存为redis
 */
@EnableCaching
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@ConditionalOnExpression("'${ibiz.cacheLevel:None}'.equals('L2')")
public class RedisCacheConfig {

    @Value("${spring.cache.redis.time-to-live:3600}")
    private long timeToLive;

    /**
     * 分层缓存管理器
     * @param redisConnectionFactory
     * @param cacheProperties
     * @return
     */
    @Bean
    @Primary
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory ,CacheProperties cacheProperties){
        LayeringCacheManager layeringCacheManager=new LayeringCacheManager(redisCacheWriter(redisConnectionFactory),redisCacheConfiguration(),redisTemplate(redisConnectionFactory));
        String strCacheConfig = cacheProperties.getCaffeine().getSpec();
        if (StringUtils.hasText(strCacheConfig)) {
            layeringCacheManager.setCaffeineCacheConfig(CaffeineSpec.parse(strCacheConfig));
        }
        return layeringCacheManager;
    }

    /**
     * redis配置：设置过期时间及序列化方式
     * @return
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        CustomJacksonSerializer jackson2JsonRedisSerializer = new CustomJacksonSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(timeToLive))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();
        return configuration;
    }

    /**
     * 创建redis缓存
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisCacheWriter redisCacheWriter(RedisConnectionFactory connectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        return redisCacheWriter;
    }

    /**
     * 发送redis广播
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        CustomJacksonSerializer jacksonSerial = new CustomJacksonSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        jacksonSerial.setObjectMapper(om);
        template.setValueSerializer(jacksonSerial);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSerial);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 监听redis指定频道
     * @param redisConnectionFactory
     * @param cacheManager
     * @param redisTemplate
     * @return
     */
    @Bean
    RedisMessageListenerContainer redisContainer(RedisConnectionFactory redisConnectionFactory, CacheManager cacheManager , RedisTemplate redisTemplate) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        MessageListenerAdapter messageListener=new RedisMessageListener(cacheManager,redisTemplate);
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListener, RedisChannelTopic.REDIS_CACHE_DELETE_TOPIC.getChannelTopic());
        container.addMessageListener(messageListener, RedisChannelTopic.REDIS_CACHE_CLEAR_TOPIC.getChannelTopic());
        return container;
    }
}