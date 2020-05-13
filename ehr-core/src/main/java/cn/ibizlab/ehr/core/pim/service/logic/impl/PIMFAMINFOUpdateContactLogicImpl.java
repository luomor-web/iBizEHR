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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMFAMINFOUpdateContactLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMFAMINFO;

/**
 * 关系型数据实体[UpdateContact] 对象
 */
@Slf4j
@Service
public class PIMFAMINFOUpdateContactLogicImpl implements IPIMFAMINFOUpdateContactLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService pimfaminfoservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService getPimfaminfoService() {
        return this.pimfaminfoservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMFAMINFO et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimfaminfoupdatecontactdefault",et);
           kieSession.setGlobal("pimfaminfoservice",pimfaminfoservice);
           kieSession.setGlobal("iBzSysPimfaminfoDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimfaminfoupdatecontact");

        }catch(Exception e){
            throw new RuntimeException("执行[更新紧急联络人]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
