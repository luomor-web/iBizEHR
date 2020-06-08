package cn.ibizlab.ehr.core.vac.service.logic.impl;

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

import cn.ibizlab.ehr.core.vac.service.logic.IVacLeaveDetailCalcPlanDaysLogic;
import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;

/**
 * 关系型数据实体[CalcPlanDays] 对象
 */
@Slf4j
@Service
public class VacLeaveDetailCalcPlanDaysLogicImpl implements IVacLeaveDetailCalcPlanDaysLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(VacLeaveDetail et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("vacleavedetailcalcplandaysdefault",et);
           kieSession.setGlobal("iBzSysVacleavedetailDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.vac.service.logic.vacleavedetailcalcplandays");

        }catch(Exception e){
            throw new RuntimeException("执行[计算计划请假天数]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
