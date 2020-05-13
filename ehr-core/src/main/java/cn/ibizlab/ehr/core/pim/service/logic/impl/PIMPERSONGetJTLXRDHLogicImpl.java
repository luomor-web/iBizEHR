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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMPERSONGetJTLXRDHLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMPERSON;

/**
 * 关系型数据实体[GetJTLXRDH] 对象
 */
@Slf4j
@Service
public class PIMPERSONGetJTLXRDHLogicImpl implements IPIMPERSONGetJTLXRDHLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService pimfaminfoservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService getPimfaminfoService() {
        return this.pimfaminfoservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMPERSONService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMPERSON et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimpersongetjtlxrdhdefault",et);
           cn.ibizlab.ehr.core.pim.domain.PIMFAMINFO  pimpersongetjtlxrdhpimfaminfo =new cn.ibizlab.ehr.core.pim.domain.PIMFAMINFO();
           kieSession.insert(pimpersongetjtlxrdhpimfaminfo); 
           kieSession.setGlobal("pimpersongetjtlxrdhpimfaminfo",pimpersongetjtlxrdhpimfaminfo);
           kieSession.setGlobal("pimfaminfoservice",pimfaminfoservice);
           kieSession.setGlobal("iBzSysPimpersonDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimpersongetjtlxrdh");

        }catch(Exception e){
            throw new RuntimeException("执行[获取家庭联系人电话]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
