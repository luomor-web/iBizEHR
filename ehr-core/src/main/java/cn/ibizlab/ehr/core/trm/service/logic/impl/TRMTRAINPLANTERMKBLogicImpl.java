package cn.ibizlab.ehr.core.trm.service.logic.impl;

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

import cn.ibizlab.ehr.core.trm.service.logic.ITRMTRAINPLANTERMKBLogic;
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM;

/**
 * 关系型数据实体[KB] 对象
 */
@Slf4j
@Service
public class TRMTRAINPLANTERMKBLogicImpl implements ITRMTRAINPLANTERMKBLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService trmtrainplantermservice;

    public cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService getTrmtrainplantermService() {
        return this.trmtrainplantermservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(TRMTRAINPLANTERM et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("trmtrainplantermkbdefault",et);
           kieSession.setGlobal("trmtrainplantermservice",trmtrainplantermservice);
           kieSession.setGlobal("iBzSysTrmtrainplantermDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.trm.service.logic.trmtrainplantermkb");

        }catch(Exception e){
            throw new RuntimeException("执行[开班]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
