package cn.ibizlab.ehr.core.pcm.service.logic.impl;

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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdjdmxFillPersonInfoLogic;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjdmx;

/**
 * 关系型数据实体[FillPersonInfo] 对象
 */
@Slf4j
@Service
public class PcmYdjdmxFillPersonInfoLogicImpl implements IPcmYdjdmxFillPersonInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPimPersonService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PcmYdjdmx et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           cn.ibizlab.ehr.core.pim.domain.PimPerson  pcmydjdmxfillpersoninfopimperson =new cn.ibizlab.ehr.core.pim.domain.PimPerson();
           kieSession.insert(pcmydjdmxfillpersoninfopimperson); 
           kieSession.setGlobal("pcmydjdmxfillpersoninfopimperson",pcmydjdmxfillpersoninfopimperson);
           kieSession.insert(et); 
           kieSession.setGlobal("pcmydjdmxfillpersoninfodefault",et);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPcmydjdmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmydjdmxfillpersoninfo");

        }catch(Exception e){
            throw new RuntimeException("执行[填充人员信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
