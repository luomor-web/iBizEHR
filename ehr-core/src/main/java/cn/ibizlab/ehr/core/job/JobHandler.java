package cn.ibizlab.ehr.core.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JobHandler(value="JobHandler")
@Component
public class JobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String params) throws Exception {
        return new ReturnT(200, "服务调用成功");
    }
}
