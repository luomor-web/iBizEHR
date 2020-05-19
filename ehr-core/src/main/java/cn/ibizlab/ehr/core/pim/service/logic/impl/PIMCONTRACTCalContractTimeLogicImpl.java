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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMCONTRACTCalContractTimeLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMCONTRACT;

/**
 * 关系型数据实体[CalContractTime] 对象
 */
@Slf4j
@Service
public class PIMCONTRACTCalContractTimeLogicImpl implements IPIMCONTRACTCalContractTimeLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService pimcontractservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService getPimcontractService() {
        return this.pimcontractservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMCONTRACT et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimcontractcalcontracttimedefault",et);
           kieSession.setGlobal("pimcontractservice",pimcontractservice);
           kieSession.setGlobal("iBzSysPimcontractDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimcontractcalcontracttime");

        }catch(Exception e){
            throw new RuntimeException("执行[计算合同签订次数]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
