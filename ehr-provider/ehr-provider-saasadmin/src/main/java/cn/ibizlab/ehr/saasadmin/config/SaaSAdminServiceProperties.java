package cn.ibizlab.ehr.saasadmin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(prefix = "service.saasadmin")
@Data
public class SaaSAdminServiceProperties {

	private boolean enabled;

	private boolean auth;


}