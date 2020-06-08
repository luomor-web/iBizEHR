package cn.ibizlab.ehr.core.util.config;

import cn.ibizlab.ehr.util.helper.JSR310DateConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(JSR310DateConverters.DateToZonedDateTimeConverter.INSTANCE);
        converterList.add(JSR310DateConverters.ZonedDateTimeToDateConverter.INSTANCE);
        converterList.add(JSR310DateConverters.DurationToLongConverter.INSTANCE);
        converterList.add(JSR310DateConverters.TimestampToDateConverter.INSTANCE);
        converterList.add(JSR310DateConverters.DateToTimestampConverter.INSTANCE);
        return new MongoCustomConversions(converterList);
    }

}