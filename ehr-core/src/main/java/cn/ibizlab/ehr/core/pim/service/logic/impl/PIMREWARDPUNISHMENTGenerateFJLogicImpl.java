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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMREWARDPUNISHMENTGenerateFJLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMREWARDPUNISHMENT;

/**
 * 关系型数据实体[GenerateFJ] 对象
 */
@Slf4j
@Service
public class PIMREWARDPUNISHMENTGenerateFJLogicImpl implements IPIMREWARDPUNISHMENTGenerateFJLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMENCLOSUREService pimenclosureservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMENCLOSUREService getPimenclosureService() {
        return this.pimenclosureservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMREWARDPUNISHMENTService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMREWARDPUNISHMENTService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMREWARDPUNISHMENT et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           cn.ibizlab.ehr.core.pim.domain.PIMENCLOSURE  pimrewardpunishmentgeneratefjenclosure =new cn.ibizlab.ehr.core.pim.domain.PIMENCLOSURE();
           kieSession.insert(pimrewardpunishmentgeneratefjenclosure); 
           kieSession.setGlobal("pimrewardpunishmentgeneratefjenclosure",pimrewardpunishmentgeneratefjenclosure);
           kieSession.insert(et); 
           kieSession.setGlobal("pimrewardpunishmentgeneratefjdefault",et);
           kieSession.setGlobal("pimenclosureservice",pimenclosureservice);
           kieSession.setGlobal("iBzSysPimrewardpunishmentDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimrewardpunishmentgeneratefj");

        }catch(Exception e){
            throw new RuntimeException("执行[生成附件信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
