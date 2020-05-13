package cn.ibizlab.ehr.specialrole.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(prefix = "service.specialrole")
@Data
public class SpecialRoleServiceProperties {

	private boolean enabled;

	private boolean auth;


}