package cn.ibizlab.ehr.util.cache;

import com.alibaba.fastjson.parser.ParserConfig;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import cn.ibizlab.ehr.util.cache.cacheManager.LayeringCacheManager;
import cn.ibizlab.ehr.util.cache.redis.KryoRedisSerializer;
import cn.ibizlab.ehr.util.cache.redis.StringRedisSerializer;
import cn.ibizlab.ehr.util.enums.RedisChannelTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.util.StringUtils;

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

    @Autowired
    private RedisCacheWriter redisCacheWriter;
    @Autowired
    private RedisCacheConfiguration configuration;
    @Autowired
    LayeringCacheManager layeringCacheManager;
    @Autowired
    private CacheProperties cacheProperties;
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.create(connectionFactory);
    }

    @Bean
    public RedisCacheWriter redisCacheWriter(RedisConnectionFactory connectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        return redisCacheWriter;
    }

    /**
     * 重写Redis序列化方式，使用Json方式:
     * 当我们的数据存储到Redis的时候，我们的键（key）和值（value）都是通过Spring提供的Serializer序列化到数据库的。RedisTemplate默认使用的是JdkSerializationRedisSerializer，StringRedisTemplate默认使用的是StringRedisSerializer。
     * Spring Data JPA为我们提供了下面的Serializer：
     * GenericToStringSerializer、Jackson2JsonRedisSerializer、JacksonJsonRedisSerializer、JdkSerializationRedisSerializer、OxmSerializer、StringRedisSerializer。
     * 在此我们将自己配置RedisTemplate并定义Serializer。
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        KryoRedisSerializer<Object> kryoRedisSerializer = new KryoRedisSerializer<>(Object.class);
        redisTemplate.setValueSerializer(kryoRedisSerializer);// 设置值（value）的序列化采用KryoRedisSerializer。
        redisTemplate.setHashValueSerializer(kryoRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());// 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    @Primary
    public CacheManager cacheManager() {
        setCaffeineCacheConfig(layeringCacheManager);//Caffeine缓存设置
        layeringCacheManager.setRedisCacheWriter(redisCacheWriter);
        layeringCacheManager.setRedisConfiguration(configuration);
        return layeringCacheManager;
    }

    private void setCaffeineCacheConfig(LayeringCacheManager layeringCacheManager) {
        String specification = cacheProperties.getCaffeine().getSpec();
        if (StringUtils.hasText(specification)) {
            layeringCacheManager.setCaffeineSpec(CaffeineSpec.parse(specification));
        }
    }

    /**
     * 监听redis指定频道
     * @param redisConnectionFactory
     * @param messageListener
     * @return
     */
    @Bean
    RedisMessageListenerContainer redisContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListener) {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListener, RedisChannelTopic.REDIS_CACHE_DELETE_TOPIC.getChannelTopic());
        container.addMessageListener(messageListener, RedisChannelTopic.REDIS_CACHE_CLEAR_TOPIC.getChannelTopic());
        return container;
    }

}