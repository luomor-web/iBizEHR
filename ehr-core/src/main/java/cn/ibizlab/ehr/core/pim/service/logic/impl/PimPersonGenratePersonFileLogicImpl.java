package cn.ibizlab.ehr.core.pim.service.logic.impl;

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

import cn.ibizlab.ehr.core.pim.service.logic.IPimPersonGenratePersonFileLogic;
import cn.ibizlab.ehr.core.pim.domain.PimPerson;

/**
 * 关系型数据实体[GenratePersonFile] 对象
 */
@Slf4j
@Service
public class PimPersonGenratePersonFileLogicImpl implements IPimPersonGenratePersonFileLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPimPersonService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPimPersonService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PimPerson et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimpersongenratepersonfiledefault",et);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPimpersonDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimpersongenratepersonfile");

        }catch(Exception e){
            throw new RuntimeException("执行[生成人员档案]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
