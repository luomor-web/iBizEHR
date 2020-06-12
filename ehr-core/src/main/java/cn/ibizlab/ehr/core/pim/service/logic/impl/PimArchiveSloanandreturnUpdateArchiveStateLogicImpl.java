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

import cn.ibizlab.ehr.core.pim.service.logic.IPimArchiveSloanandreturnUpdateArchiveStateLogic;
import cn.ibizlab.ehr.core.pim.domain.PimArchiveSloanandreturn;

/**
 * 关系型数据实体[UpdateArchiveState] 对象
 */
@Slf4j
@Service
public class PimArchiveSloanandreturnUpdateArchiveStateLogicImpl implements IPimArchiveSloanandreturnUpdateArchiveStateLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService pimarchivesloanandreturnservice;

    public cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService getPimarchivesloanandreturnService() {
        return this.pimarchivesloanandreturnservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PimArchiveSloanandreturn et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimarchivesloanandreturnupdatearchivestatedefault",et);
           kieSession.setGlobal("pimarchivesloanandreturnservice",pimarchivesloanandreturnservice);
           kieSession.setGlobal("iBzSysPimarchivesloanandreturnDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimarchivesloanandreturnupdatearchivestate");

        }catch(Exception e){
            throw new RuntimeException("执行[更新档案信息归还状态]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
