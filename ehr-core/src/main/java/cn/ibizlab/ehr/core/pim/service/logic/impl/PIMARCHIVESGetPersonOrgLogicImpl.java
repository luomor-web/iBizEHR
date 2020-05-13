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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMARCHIVESGetPersonOrgLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES;

/**
 * 关系型数据实体[GetPersonOrg] 对象
 */
@Slf4j
@Service
public class PIMARCHIVESGetPersonOrgLogicImpl implements IPIMARCHIVESGetPersonOrgLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMPERSONService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMARCHIVES et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimarchivesgetpersonorgdefault",et);
           cn.ibizlab.ehr.core.pim.domain.PIMPERSON  pimarchivesgetpersonorggerpersoninfo =new cn.ibizlab.ehr.core.pim.domain.PIMPERSON();
           kieSession.insert(pimarchivesgetpersonorggerpersoninfo); 
           kieSession.setGlobal("pimarchivesgetpersonorggerpersoninfo",pimarchivesgetpersonorggerpersoninfo);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPimarchivesDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimarchivesgetpersonorg");

        }catch(Exception e){
            throw new RuntimeException("执行[获取人员组织]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}