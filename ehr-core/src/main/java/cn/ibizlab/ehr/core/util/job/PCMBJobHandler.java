package cn.ibizlab.ehr.core.util.job;

import com.baomidou.jobs.api.JobsResponse;
import com.baomidou.jobs.exception.JobsException;
import com.baomidou.jobs.handler.IJobsHandler;
import org.springframework.stereotype.Component;

@Component("PCMBJobHandler")
public class PCMBJobHandler implements  IJobsHandler {

    @Override
    public JobsResponse execute(String tenantId, String param) throws JobsException {
        System.out.println("执行 DemoJobHandler tenantId=" + tenantId + ",param=" + param);
        return JobsResponse.ok();
    }
}
