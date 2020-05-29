package cn.ibizlab.ehr.util.cache.listener;

import cn.ibizlab.ehr.util.cache.cache.LayeringCache;
import cn.ibizlab.ehr.util.enums.RedisChannelTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * redis消息的订阅者
 */

@Component
@ConditionalOnExpression("'${ibiz.cacheLevel:None}'.equals('L2')")
public class RedisMessageListener extends MessageListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(RedisPublisher.class);
    @Autowired
    CacheManager cacheManager;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        super.onMessage(message, pattern);
        RedisChannelTopic channelTopic = RedisChannelTopic.getChannelTopicEnum(new String(message.getChannel()));
        Map<String, Object> map = null;
        RedisSerializer serializer=redisTemplate.getValueSerializer();
        Object result=serializer.deserialize(message.getBody());
        if(result instanceof  Map){
            map= (Map<String, Object>) result;
        }
        if(StringUtils.isEmpty(map)|| (!map.containsKey("cacheName"))|| (!map.containsKey("key"))){
            logger.debug("解析缓存数据失败，无法获取指定值!");
            return ;
        }
        logger.debug("redis消息订阅者接收到频道【{}】发布的消息。消息内容：{}", channelTopic.getChannelTopicStr(), result.toString());
        String cacheName = (String) map.get("cacheName");
        Object key = map.get("key");
        Cache cache = cacheManager.getCache(cacheName);// 根据缓存名称获取多级缓存
        if (cache != null && cache instanceof LayeringCache) { // 判断缓存是否是多级缓存
            switch (channelTopic) {
                case REDIS_CACHE_DELETE_TOPIC: // 获取一级缓存，并删除一级缓存数据
                    ((LayeringCache) cache).getFirstCache().evict(key);
                    logger.debug("删除一级缓存{}数据,key:{},", cacheName, key.toString());
                    break;
                case REDIS_CACHE_CLEAR_TOPIC:// 获取一级缓存，并删除一级缓存数据
                    ((LayeringCache) cache).getFirstCache().clear();
                    logger.debug("清除一级缓存{}数据", cacheName);
                    break;
                default:
                    logger.debug("接收到没有定义的订阅消息频道数据");
                    break;
            }
        }
    }
}
