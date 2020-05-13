package cn.ibizlab.ehr.specialrole.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ConditionalOnClass(SpecialRoleRestConfiguration.class)
@ConditionalOnWebApplication
@EnableConfigurationProperties(SpecialRoleServiceProperties.class)
public class SpecialRoleAutoConfiguration implements ApplicationContextAware{

	protected ApplicationContext applicationContext;


	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

//	@Bean
//	public ServletRegistrationBean specialroleServlet() {
//		AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
//		dispatcherServletConfiguration.setParent(applicationContext);
//		dispatcherServletConfiguration.register(SpecialRoleRestConfiguration.class);
//		DispatcherServlet servlet = new DispatcherServlet(dispatcherServletConfiguration);
//		String path = "/specialrole";
//		String urlMapping = (path.endsWith("/") ? path + "*" : path + "/*");
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet, urlMapping);
//		registrationBean.setName("SpecialRole");
//		return registrationBean;
//	}
}

