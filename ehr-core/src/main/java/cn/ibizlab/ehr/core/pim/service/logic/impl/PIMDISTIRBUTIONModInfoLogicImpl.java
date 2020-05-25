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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMDISTIRBUTIONModInfoLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMDISTIRBUTION;

/**
 * 关系型数据实体[ModInfo] 对象
 */
@Slf4j
@Service
public class PIMDISTIRBUTIONModInfoLogicImpl implements IPIMDISTIRBUTIONModInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMPERSONService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMDISTIRBUTION et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimdistirbutionmodinfodefault",et);
           cn.ibizlab.ehr.core.pim.domain.PIMPERSON  pimdistirbutionmodinfopimperson =new cn.ibizlab.ehr.core.pim.domain.PIMPERSON();
           kieSession.insert(pimdistirbutionmodinfopimperson); 
           kieSession.setGlobal("pimdistirbutionmodinfopimperson",pimdistirbutionmodinfopimperson);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPimdistirbutionDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimdistirbutionmodinfo");

        }catch(Exception e){
            throw new RuntimeException("执行[更新员工信息表中组织、部门信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
