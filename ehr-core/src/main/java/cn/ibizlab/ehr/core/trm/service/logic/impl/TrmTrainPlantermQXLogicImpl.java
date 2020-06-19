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

import cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlantermQXLogic;
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm;

/**
 * 关系型数据实体[QX] 对象
 */
@Slf4j
@Service
public class TrmTrainPlantermQXLogicImpl implements ITrmTrainPlantermQXLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService trmtrainplantermservice;

    public cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService getTrmtrainplantermService() {
        return this.trmtrainplantermservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(TrmTrainPlanterm et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("trmtrainplantermqxdefault",et);
           kieSession.setGlobal("trmtrainplantermservice",trmtrainplantermservice);
           kieSession.setGlobal("iBzSysTrmtrainplantermDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.trm.service.logic.trmtrainplantermqx");

        }catch(Exception e){
            throw new RuntimeException("执行[取消]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
