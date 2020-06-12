package cn.ibizlab.ehr.core.util.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.spring.KModuleBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.util.List;

@Configuration
public class DroolsAutoConfiguration {

    private Log logger= LogFactory.getLog(DroolsAutoConfiguration.class);
    
    private static final String RULES_PATH = "rules/";

    @Bean
    @ConditionalOnMissingBean(KieFileSystem.class)
    public KieFileSystem kieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
        for (Resource file : getRuleFiles()) {
            kieFileSystem.write(ResourceFactory.newUrlResource(file.getURL()));
        }
        return kieFileSystem;
    }

    private Resource[] getRuleFiles() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
    }

    @Bean
    @ConditionalOnMissingBean(KieContainer.class)
    public KieContainer kieContainer() throws IOException {
        final KieRepository kieRepository = getKieServices().getRepository();

        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });

        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem());
        kieBuilder.buildAll();

        if(kieBuilder.getResults().hasMessages(new Message.Level[] { Message.Level.ERROR })){
            List<Message> errors = kieBuilder.getResults().getMessages(new Message.Level[] { Message.Level.ERROR });
            StringBuilder stringBuilder = new StringBuilder("Errors:");
            for (Message msg : errors)
            {
                stringBuilder.append(new StringBuilder().append("\n  ").append(prettyBuildMessage(msg)).toString());
            }
            logger.error(String.format("初始化处理逻辑发生异常，异常原因为[%s]",stringBuilder.toString()));
            //忽略处理逻辑
            getKieServices().newKieBuilder(getKieServices().newKieFileSystem()).buildAll();
        }

        return getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
    }

    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }

    @Bean
    @ConditionalOnMissingBean(KieBase.class)
    public KieBase kieBase() throws IOException {
        return kieContainer().getKieBase();
    }

    @Bean
    @ConditionalOnMissingBean(KieSession.class)
    public KieSession kieSession() throws IOException {
        return kieContainer().newKieSession();
    }

    @Bean
    @ConditionalOnMissingBean(KModuleBeanFactoryPostProcessor.class)
    public KModuleBeanFactoryPostProcessor kiePostProcessor() {
        return new KModuleBeanFactoryPostProcessor();
    }

    /**
    * 输出异常信息
    * @param msg
    * @return
    */
    public static String prettyBuildMessage(Message msg)
    {
        return new StringBuilder().append("Message: {id=").append(msg.getId()).append(", level=").append(msg.getLevel()).append(", path=").append(msg.getPath()).append(", line=").append(msg.getLine())
        .append(", column=").append(msg.getColumn()).append(", text=\"").append(msg.getText()).append("\"}").toString();
    }
}