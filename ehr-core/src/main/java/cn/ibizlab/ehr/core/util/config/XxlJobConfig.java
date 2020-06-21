package cn.ibizlab.ehr.core.util.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import com.baomidou.jobs.starter.EnableJobs;

@ConditionalOnExpression("!'${jobs.admin-address:NA}'.equals('NA')")
@EnableJobs
@Configuration
public class XxlJobConfig {

}
