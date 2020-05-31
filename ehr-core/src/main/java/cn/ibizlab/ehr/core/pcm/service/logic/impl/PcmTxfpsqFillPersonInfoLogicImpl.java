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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmTxfpsqFillPersonInfoLogic;
import cn.ibizlab.ehr.core.pcm.domain.PcmTxfpsq;

/**
 * 关系型数据实体[FillPersonInfo] 对象
 */
@Slf4j
@Service
public class PcmTxfpsqFillPersonInfoLogicImpl implements IPcmTxfpsqFillPersonInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPimPersonService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmTxfpsqService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPcmTxfpsqService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PcmTxfpsq et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pcmtxfpsqfillpersoninfodefault",et);
           cn.ibizlab.ehr.core.pim.domain.PimPerson  pcmtxfpsqfillpersoninfopimperson =new cn.ibizlab.ehr.core.pim.domain.PimPerson();
           kieSession.insert(pcmtxfpsqfillpersoninfopimperson); 
           kieSession.setGlobal("pcmtxfpsqfillpersoninfopimperson",pcmtxfpsqfillpersoninfopimperson);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPcmtxfpsqDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmtxfpsqfillpersoninfo");

        }catch(Exception e){
            throw new RuntimeException("执行[填充用户信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
