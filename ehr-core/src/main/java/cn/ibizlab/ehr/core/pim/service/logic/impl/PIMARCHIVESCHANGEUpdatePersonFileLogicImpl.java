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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMARCHIVESCHANGEUpdatePersonFileLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESCHANGE;

/**
 * 关系型数据实体[UpdatePersonFile] 对象
 */
@Slf4j
@Service
public class PIMARCHIVESCHANGEUpdatePersonFileLogicImpl implements IPIMARCHIVESCHANGEUpdatePersonFileLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService pimarchiveschangeservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService getPimarchiveschangeService() {
        return this.pimarchiveschangeservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMARCHIVESCHANGE et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimarchiveschangeupdatepersonfiledefault",et);
           kieSession.setGlobal("pimarchiveschangeservice",pimarchiveschangeservice);
           kieSession.setGlobal("iBzSysPimarchiveschangeDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimarchiveschangeupdatepersonfile");

        }catch(Exception e){
            throw new RuntimeException("执行[更新档案信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
