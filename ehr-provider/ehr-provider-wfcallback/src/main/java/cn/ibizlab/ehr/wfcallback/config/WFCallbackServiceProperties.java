package cn.ibizlab.ehr.wfcallback.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(prefix = "service.wfcallback")
@Data
public class WFCallbackServiceProperties {

	private boolean enabled;

	private boolean auth;


}