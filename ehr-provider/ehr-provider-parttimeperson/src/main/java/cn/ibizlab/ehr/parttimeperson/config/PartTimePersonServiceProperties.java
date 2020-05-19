package cn.ibizlab.ehr.parttimeperson.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(prefix = "service.parttimeperson")
@Data
public class PartTimePersonServiceProperties {

	private boolean enabled;

	private boolean auth;


}