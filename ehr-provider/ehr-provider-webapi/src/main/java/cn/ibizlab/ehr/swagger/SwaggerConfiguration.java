package cn.ibizlab.ehr.swagger;

import cn.ibizlab.ehr.util.security.SpringContextHolder;
import cn.ibizlab.ehr.util.web.IBZOperationParameterReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.PluginRegistrySupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.EnumTypeDeterminer;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.readers.operation.OperationParameterReader;
import springfox.documentation.spring.web.readers.parameter.ModelAttributeParameterExpander;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:false}")
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("DEFAULT")
                .pathMapping("/")
                .apiInfo(
						new ApiInfoBuilder()
						.title("DEFAULT")
						.build()
                    )
                .select()
				.apis(RequestHandlerSelectors.basePackage("cn.ibizlab.ehr"))
                //.paths(or(regex("/rest/.*")))
				.paths(PathSelectors.any())
                .build()
                ;
		removeDefaultPlugin();
		return docket ;
    }

	@Bean
	public Docket webapiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("WebApi")
				.pathMapping("/")
				.apiInfo(
						new ApiInfoBuilder()
						.title("WebApi")
						.version("1")
						.build()
                    )
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.ibizlab.ehr.webapi"))
				//.paths(or(regex("/rest/webapi/.*")))
				.paths(PathSelectors.any())
				.build()
				;
	}

	
	private void removeDefaultPlugin() {
		// ???spring???????????????swagger???????????????
		PluginRegistry<OperationBuilderPlugin, DocumentationType> pluginRegistry = SpringContextHolder.getBean("operationBuilderPluginRegistry");
		// ????????????
		List<OperationBuilderPlugin> plugins = pluginRegistry.getPlugins();
		// ???spring????????????????????????????????????
		OperationParameterReader operationParameterReader = SpringContextHolder.getBean(OperationParameterReader.class);
		if(operationParameterReader==null)
			return ;
		// ???plugins?????????????????????????????????????????????????????????
		if (pluginRegistry.contains(operationParameterReader)) {
			List<OperationBuilderPlugin> plugins_new = new ArrayList<OperationBuilderPlugin>(plugins);
			plugins_new.remove(operationParameterReader);
			try {
				Field field = PluginRegistrySupport.class.getDeclaredField("plugins");
				field.setAccessible(true);
				field.set(pluginRegistry, plugins_new);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Bean
	public IBZOperationParameterReader iBZOperationParameterReader(ModelAttributeParameterExpander expander,EnumTypeDeterminer enumTypeDeterminer){
		IBZOperationParameterReader iBZOperationParameterReader = new IBZOperationParameterReader(expander, enumTypeDeterminer) ;
		return iBZOperationParameterReader ;
	}
}
