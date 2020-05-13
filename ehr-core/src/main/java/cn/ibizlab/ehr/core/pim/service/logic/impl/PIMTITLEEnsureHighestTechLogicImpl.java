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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMTITLEEnsureHighestTechLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMTITLE;

/**
 * 关系型数据实体[EnsureHighestTech] 对象
 */
@Slf4j
@Service
public class PIMTITLEEnsureHighestTechLogicImpl implements IPIMTITLEEnsureHighestTechLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMTITLEService pimtitleservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMTITLEService getPimtitleService() {
        return this.pimtitleservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMTITLEService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMTITLEService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMTITLE et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimtitleensurehighesttechdefault",et);
           kieSession.setGlobal("pimtitleservice",pimtitleservice);
           kieSession.setGlobal("iBzSysPimtitleDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimtitleensurehighesttech");

        }catch(Exception e){
            throw new RuntimeException("执行[确认唯一最高职称]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
