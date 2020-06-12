package cn.ibizlab.ehr.core.pcm.service.logic.impl;

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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdjzmxRyHgLogic;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjzmx;

/**
 * 关系型数据实体[RyHg] 对象
 */
@Slf4j
@Service
public class PcmYdjzmxRyHgLogicImpl implements IPcmYdjzmxRyHgLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionservice;

    public cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService getPimdistirbutionService() {
        return this.pimdistirbutionservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PcmYdjzmx et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           cn.ibizlab.ehr.core.pim.domain.PimDistirbution  pcmydjzmxryhgpimdistirbution =new cn.ibizlab.ehr.core.pim.domain.PimDistirbution();
           kieSession.insert(pcmydjzmxryhgpimdistirbution); 
           kieSession.setGlobal("pcmydjzmxryhgpimdistirbution",pcmydjzmxryhgpimdistirbution);
           kieSession.insert(et); 
           kieSession.setGlobal("pcmydjzmxryhgdefault",et);
           kieSession.setGlobal("pimdistirbutionservice",pimdistirbutionservice);
           kieSession.setGlobal("iBzSysPcmydjzmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmydjzmxryhg");

        }catch(Exception e){
            throw new RuntimeException("执行[人员回归]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
