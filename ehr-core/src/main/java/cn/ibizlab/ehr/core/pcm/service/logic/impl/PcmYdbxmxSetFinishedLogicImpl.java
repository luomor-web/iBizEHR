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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdbxmxSetFinishedLogic;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdbxmx;

/**
 * 关系型数据实体[SetFinished] 对象
 */
@Slf4j
@Service
public class PcmYdbxmxSetFinishedLogicImpl implements IPcmYdbxmxSetFinishedLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdbxmxService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPcmYdbxmxService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PcmYdbxmx et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pcmydbxmxsetfinisheddefault",et);
           kieSession.setGlobal("iBzSysPcmydbxmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmydbxmxsetfinished");

        }catch(Exception e){
            throw new RuntimeException("执行[设置完成状态]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
