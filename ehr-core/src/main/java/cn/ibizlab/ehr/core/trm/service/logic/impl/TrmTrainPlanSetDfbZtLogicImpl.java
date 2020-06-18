package cn.ibizlab.ehr.core.trm.service.logic.impl;

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

import cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlanSetDfbZtLogic;
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan;

/**
 * 关系型数据实体[SetDfbZt] 对象
 */
@Slf4j
@Service
public class TrmTrainPlanSetDfbZtLogicImpl implements ITrmTrainPlanSetDfbZtLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlanService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.trm.service.ITrmTrainPlanService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(TrmTrainPlan et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("trmtrainplansetdfbztdefault",et);
           kieSession.setGlobal("iBzSysTrmtrainplanDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.trm.service.logic.trmtrainplansetdfbzt");

        }catch(Exception e){
            throw new RuntimeException("执行[设置待发布状态]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
