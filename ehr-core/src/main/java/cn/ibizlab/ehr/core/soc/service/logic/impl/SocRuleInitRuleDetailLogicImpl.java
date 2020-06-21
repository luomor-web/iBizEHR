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

import cn.ibizlab.ehr.core.soc.service.logic.ISocRuleInitRuleDetailLogic;
import cn.ibizlab.ehr.core.soc.domain.SocRule;

/**
 * 关系型数据实体[InitRuleDetail] 对象
 */
@Slf4j
@Service
public class SocRuleInitRuleDetailLogicImpl implements ISocRuleInitRuleDetailLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.soc.service.ISocRuleService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.soc.service.ISocRuleService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(SocRule et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("socruleinitruledetaildefault",et);
           kieSession.setGlobal("iBzSysSocruleDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.soc.service.logic.socruleinitruledetail");

        }catch(Exception e){
            throw new RuntimeException("执行[初始化社保规则明细]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
