package cn.ibizlab.ehr.webapi.config;

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
@ConditionalOnClass(WebApiRestConfiguration.class)
@ConditionalOnWebApplication
@EnableConfigurationProperties(WebApiServiceProperties.class)
public class WebApiAutoConfiguration implements ApplicationContextAware{

	protected ApplicationContext applicationContext;


	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

//	@Bean
//	public ServletRegistrationBean webapiServlet() {
//		AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
//		dispatcherServletConfiguration.setParent(applicationContext);
//		dispatcherServletConfiguration.register(WebApiRestConfiguration.class);
//		DispatcherServlet servlet = new DispatcherServlet(dispatcherServletConfiguration);
//		String path = "/webapi";
//		String urlMapping = (path.endsWith("/") ? path + "*" : path + "/*");
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet, urlMapping);
//		registrationBean.setName("WebApi");
//		return registrationBean;
//	}
}

