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

import cn.ibizlab.ehr.core.pim.service.logic.IPimArchivesGetPersonOrgLogic;
import cn.ibizlab.ehr.core.pim.domain.PimArchives;

/**
 * 关系型数据实体[GetPersonOrg] 对象
 */
@Slf4j
@Service
public class PimArchivesGetPersonOrgLogicImpl implements IPimArchivesGetPersonOrgLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPimPersonService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPimArchivesService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PimArchives et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimarchivesgetpersonorgdefault",et);
           cn.ibizlab.ehr.core.pim.domain.PimPerson  pimarchivesgetpersonorggerpersoninfo =new cn.ibizlab.ehr.core.pim.domain.PimPerson();
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
