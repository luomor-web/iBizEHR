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

import cn.ibizlab.ehr.core.trm.service.logic.ITrmDutyCadresSetNQGBXXLogic;
import cn.ibizlab.ehr.core.trm.domain.TrmDutyCadres;

/**
 * 关系型数据实体[SetNQGBXX] 对象
 */
@Slf4j
@Service
public class TrmDutyCadresSetNQGBXXLogicImpl implements ITrmDutyCadresSetNQGBXXLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPimPersonService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(TrmDutyCadres et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           cn.ibizlab.ehr.core.pim.domain.PimPerson  trmdutycadressetnqgbxxpimperson =new cn.ibizlab.ehr.core.pim.domain.PimPerson();
           kieSession.insert(trmdutycadressetnqgbxxpimperson); 
           kieSession.setGlobal("trmdutycadressetnqgbxxpimperson",trmdutycadressetnqgbxxpimperson);
           kieSession.insert(et); 
           kieSession.setGlobal("trmdutycadressetnqgbxxdefault",et);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysTrmdutycadresDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.trm.service.logic.trmdutycadressetnqgbxx");

        }catch(Exception e){
            throw new RuntimeException("执行[填充年轻干部的信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
