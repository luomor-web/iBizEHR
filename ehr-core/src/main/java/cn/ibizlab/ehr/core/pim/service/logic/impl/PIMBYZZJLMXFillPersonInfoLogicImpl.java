package cn.ibizlab.ehr.core.pim.service.logic.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieContainer;

import cn.ibizlab.ehr.core.pim.service.logic.IPIMBYZZJLMXFillPersonInfoLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX;

/**
 * 关系型数据实体[FillPersonInfo] 对象
 */
@Slf4j
@Service
public class PIMBYZZJLMXFillPersonInfoLogicImpl implements IPIMBYZZJLMXFillPersonInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMPERSONService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMBYZZJLMX et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimbyzzjlmxfillpersoninfodefault",et);
           cn.ibizlab.ehr.core.pim.domain.PIMPERSON  pimbyzzjlmxfillpersoninfopimperson =new cn.ibizlab.ehr.core.pim.domain.PIMPERSON();
           kieSession.insert(pimbyzzjlmxfillpersoninfopimperson); 
           kieSession.setGlobal("pimbyzzjlmxfillpersoninfopimperson",pimbyzzjlmxfillpersoninfopimperson);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPimbyzzjlmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimbyzzjlmxfillpersoninfo");

        }catch(Exception e){
            throw new RuntimeException("执行[填充人员信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
