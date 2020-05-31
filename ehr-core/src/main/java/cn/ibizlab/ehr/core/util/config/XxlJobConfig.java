package cn.ibizlab.ehr.core.util.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * xxl-job config
 *  分布式任务调度平台XXL-JOB配置加载
 * @author xuxueli 2017-04-28
 */
@Configuration
public class XxlJobConfig {
    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

    @Value("${xxl.job.admin.addresses:}")
    private String adminAddresses;

    @Value("${xxl.job.accessToken:}")
    private String accessToken;

    @Value("${xxl.job.executor.appname:ehr}")
    private String appName;

    @Value("${xxl.job.executor.ip:127.0.0.1}")
    private String ip;

   @Value("${xxl.job.executor.port:9999}")
   private int port;

    @Value("${xxl.job.executor.logpath:/app/joblog}")
    private String logPath;

    @Value("${xxl.job.executor.logretentiondays:-1}")
    private int logRetentionDays;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        if(!StringUtils.isEmpty(adminAddresses)){
            logger.info(">>>>>>>>>>> xxl-job config init.");
            logger.info(">>>>>>>>>>> adminAddresses:"+adminAddresses);
            logger.info(">>>>>>>>>>> appName:"+appName);
            logger.info(">>>>>>>>>>> ip:"+ip);
            logger.info(">>>>>>>>>>> port:"+port);
            XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
            xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
            xxlJobSpringExecutor.setAppName(appName);
            xxlJobSpringExecutor.setIp(ip);
            xxlJobSpringExecutor.setPort(port);
            xxlJobSpringExecutor.setAccessToken(accessToken);
            xxlJobSpringExecutor.setLogPath(logPath);
            xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
            return xxlJobSpringExecutor;
        }
        
        logger.info(">>>>>>>>>>> xxl-job config not init.");
        return null;
    }

    /**
     * 针对多网卡、容器内部署等情况，可借助 "spring-cloud-commons" 提供的 "InetUtils" 组件灵活定制注册IP；
     *
     *      1、引入依赖：
     *          <dependency>
     *             <groupId>org.springframework.cloud</groupId>
     *             <artifactId>spring-cloud-commons</artifactId>
     *             <version>${version}"</version>
     *         </dependency>
     *
     *      2、配置文件，或者容器启动变量
     *          spring.cloud.inetutils.preferred-networks: 'xxx.xxx.xxx.'
     *
     *      3、获取IP
     *          String ip_ = inetUtils.findFirstNonLoopbackHostInfo().getIpAddress();
     */
}
