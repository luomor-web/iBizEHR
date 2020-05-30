package cn.ibizlab.ehr.util.web;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * feign请求拦截器
 * 拦截所有使用feign发出的请求，附加原始请求Header参数及Token
 */
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null){
            HttpServletRequest request = requestAttributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    requestTemplate.header(name, values);
                }
                logger.info("feign interceptor header:{}",requestTemplate);
            }
        }
    }
}