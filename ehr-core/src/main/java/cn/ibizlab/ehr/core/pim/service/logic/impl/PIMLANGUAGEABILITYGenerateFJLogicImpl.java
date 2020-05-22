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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMLANGUAGEABILITYGenerateFJLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMLANGUAGEABILITY;

/**
 * 关系型数据实体[GenerateFJ] 对象
 */
@Slf4j
@Service
public class PIMLANGUAGEABILITYGenerateFJLogicImpl implements IPIMLANGUAGEABILITYGenerateFJLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMENCLOSUREService pimenclosureservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMENCLOSUREService getPimenclosureService() {
        return this.pimenclosureservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMLANGUAGEABILITYService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMLANGUAGEABILITYService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMLANGUAGEABILITY et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimlanguageabilitygeneratefjdefault",et);
           cn.ibizlab.ehr.core.pim.domain.PIMENCLOSURE  pimlanguageabilitygeneratefjenclosure =new cn.ibizlab.ehr.core.pim.domain.PIMENCLOSURE();
           kieSession.insert(pimlanguageabilitygeneratefjenclosure); 
           kieSession.setGlobal("pimlanguageabilitygeneratefjenclosure",pimlanguageabilitygeneratefjenclosure);
           kieSession.setGlobal("pimenclosureservice",pimenclosureservice);
           kieSession.setGlobal("iBzSysPimlanguageabilityDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimlanguageabilitygeneratefj");

        }catch(Exception e){
            throw new RuntimeException("执行[生成附件信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
