package cn.ibizlab.ehr.webapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(prefix = "service.webapi")
@Data
public class WebApiServiceProperties {

	private boolean enabled;

	private boolean auth;


}