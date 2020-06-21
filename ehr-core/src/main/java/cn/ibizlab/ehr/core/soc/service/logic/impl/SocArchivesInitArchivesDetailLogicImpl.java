package cn.ibizlab.ehr.core.soc.service.logic.impl;

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

import cn.ibizlab.ehr.core.soc.service.logic.ISocArchivesInitArchivesDetailLogic;
import cn.ibizlab.ehr.core.soc.domain.SocArchives;

/**
 * 关系型数据实体[InitArchivesDetail] 对象
 */
@Slf4j
@Service
public class SocArchivesInitArchivesDetailLogicImpl implements ISocArchivesInitArchivesDetailLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.soc.service.ISocArchivesService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.soc.service.ISocArchivesService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(SocArchives et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("socarchivesinitarchivesdetaildefault",et);
           kieSession.setGlobal("iBzSysSocarchivesDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.soc.service.logic.socarchivesinitarchivesdetail");

        }catch(Exception e){
            throw new RuntimeException("执行[初始化档案明细]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
