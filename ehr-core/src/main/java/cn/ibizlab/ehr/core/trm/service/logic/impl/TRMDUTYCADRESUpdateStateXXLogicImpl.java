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

import cn.ibizlab.ehr.core.trm.service.logic.ITRMDUTYCADRESUpdateStateXXLogic;
import cn.ibizlab.ehr.core.trm.domain.TRMDUTYCADRES;

/**
 * 关系型数据实体[UpdateStateXX] 对象
 */
@Slf4j
@Service
public class TRMDUTYCADRESUpdateStateXXLogicImpl implements ITRMDUTYCADRESUpdateStateXXLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService trmdutycadresservice;

    public cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService getTrmdutycadresService() {
        return this.trmdutycadresservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(TRMDUTYCADRES et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("trmdutycadresupdatestatexxdefault",et);
           kieSession.setGlobal("trmdutycadresservice",trmdutycadresservice);
           kieSession.setGlobal("iBzSysTrmdutycadresDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.trm.service.logic.trmdutycadresupdatestatexx");

        }catch(Exception e){
            throw new RuntimeException("执行[更新状态（失效）]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
