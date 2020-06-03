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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdjdmxRyHgLogic;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjdmx;

/**
 * 关系型数据实体[RyHg] 对象
 */
@Slf4j
@Service
public class PcmYdjdmxRyHgLogicImpl implements IPcmYdjdmxRyHgLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionservice;

    public cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService getPimdistirbutionService() {
        return this.pimdistirbutionservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PcmYdjdmx et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pcmydjdmxryhgdefault",et);
           cn.ibizlab.ehr.core.pim.domain.PimDistirbution  pcmydjdmxryhgpimdistirbution =new cn.ibizlab.ehr.core.pim.domain.PimDistirbution();
           kieSession.insert(pcmydjdmxryhgpimdistirbution); 
           kieSession.setGlobal("pcmydjdmxryhgpimdistirbution",pcmydjdmxryhgpimdistirbution);
           kieSession.setGlobal("pimdistirbutionservice",pimdistirbutionservice);
           kieSession.setGlobal("iBzSysPcmydjdmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmydjdmxryhg");

        }catch(Exception e){
            throw new RuntimeException("执行[人员回归]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
