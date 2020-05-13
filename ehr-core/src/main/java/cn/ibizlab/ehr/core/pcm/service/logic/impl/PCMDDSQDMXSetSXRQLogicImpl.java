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

import cn.ibizlab.ehr.core.pcm.service.logic.IPCMDDSQDMXSetSXRQLogic;
import cn.ibizlab.ehr.core.pcm.domain.PCMDDSQDMX;

/**
 * 关系型数据实体[SetSXRQ] 对象
 */
@Slf4j
@Service
public class PCMDDSQDMXSetSXRQLogicImpl implements IPCMDDSQDMXSetSXRQLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PCMDDSQDMX et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pcmddsqdmxsetsxrqdefault",et);
           kieSession.setGlobal("iBzSysPcmddsqdmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmddsqdmxsetsxrq");

        }catch(Exception e){
            throw new RuntimeException("执行[设置生效日期的值为其他时间]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
