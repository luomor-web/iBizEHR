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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileUnCheckInLogic;
import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;

/**
 * 关系型数据实体[UnCheckIn] 对象
 */
@Slf4j
@Service
public class PcmProfileUnCheckInLogicImpl implements IPcmProfileUnCheckInLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileservice;

    public cn.ibizlab.ehr.core.pcm.service.IPcmProfileService getPcmprofileService() {
        return this.pcmprofileservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPcmProfileService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PcmProfile et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pcmprofileuncheckindefault",et);
           kieSession.setGlobal("pcmprofileservice",pcmprofileservice);
           kieSession.setGlobal("iBzSysPcmprofileDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmprofileuncheckin");

        }catch(Exception e){
            throw new RuntimeException("执行[逾期未报到]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
