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

import cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILEGroupRejectLogic;
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE;

/**
 * 关系型数据实体[GroupReject] 对象
 */
@Slf4j
@Service
public class PCMPROFILEGroupRejectLogicImpl implements IPCMPROFILEGroupRejectLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileservice;

    public cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService getPcmprofileService() {
        return this.pcmprofileservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PCMPROFILE et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pcmprofilegrouprejectdefault",et);
           kieSession.setGlobal("pcmprofileservice",pcmprofileservice);
           kieSession.setGlobal("iBzSysPcmprofileDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmprofilegroupreject");

        }catch(Exception e){
            throw new RuntimeException("执行[总部审批-拒绝]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
