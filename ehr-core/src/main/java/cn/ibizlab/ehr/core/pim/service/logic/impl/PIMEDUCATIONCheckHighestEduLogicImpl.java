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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMEDUCATIONCheckHighestEduLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMEDUCATION;

/**
 * 关系型数据实体[CheckHighestEdu] 对象
 */
@Slf4j
@Service
public class PIMEDUCATIONCheckHighestEduLogicImpl implements IPIMEDUCATIONCheckHighestEduLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMEDUCATIONService pimeducationservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMEDUCATIONService getPimeducationService() {
        return this.pimeducationservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMEDUCATIONService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMEDUCATIONService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMEDUCATION et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimeducationcheckhighestedudefault",et);
           kieSession.setGlobal("pimeducationservice",pimeducationservice);
           kieSession.setGlobal("iBzSysPimeducationDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimeducationcheckhighestedu");

        }catch(Exception e){
            throw new RuntimeException("执行[检查最高学历]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
