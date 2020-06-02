package cn.ibizlab.ehr.util.enums;

import org.springframework.data.redis.listener.ChannelTopic;
/**
 * redis频道
 */
public enum RedisChannelTopic {
    REDIS_CACHE_DELETE_TOPIC("redis:cache:delete:topic1", "删除redis缓存消息频道"),
    REDIS_CACHE_CLEAR_TOPIC("redis:cache:clear:topic2", "清空redis缓存消息频道");

    String channelTopic;
    String label;

    RedisChannelTopic(String channelTopic, String label) {
        this.channelTopic = channelTopic;
        this.label = label;
    }

    public ChannelTopic getChannelTopic() {
        return new ChannelTopic(channelTopic);
    }

    public static RedisChannelTopic getChannelTopicEnum(String channelTopic) {
        for (RedisChannelTopic awardTypeEnum : RedisChannelTopic.values()) {
            if (awardTypeEnum.getChannelTopicStr().equals(channelTopic)) {
                return awardTypeEnum;
            }
        }
        return null;
    }

    public String getChannelTopicStr() {
        return channelTopic;
    }

}
