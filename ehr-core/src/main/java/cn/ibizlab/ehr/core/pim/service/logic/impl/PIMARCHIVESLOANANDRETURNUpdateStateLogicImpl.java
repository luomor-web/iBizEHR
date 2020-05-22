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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMARCHIVESLOANANDRETURNUpdateStateLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESLOANANDRETURN;

/**
 * 关系型数据实体[UpdateState] 对象
 */
@Slf4j
@Service
public class PIMARCHIVESLOANANDRETURNUpdateStateLogicImpl implements IPIMARCHIVESLOANANDRETURNUpdateStateLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESLOANANDRETURNService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESLOANANDRETURNService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMARCHIVESLOANANDRETURN et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimarchivesloanandreturnupdatestatedefault",et);
           kieSession.setGlobal("iBzSysPimarchivesloanandreturnDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimarchivesloanandreturnupdatestate");

        }catch(Exception e){
            throw new RuntimeException("执行[更新档案借阅归还状态]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
