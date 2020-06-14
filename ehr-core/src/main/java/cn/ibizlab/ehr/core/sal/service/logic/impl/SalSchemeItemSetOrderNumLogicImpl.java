package cn.ibizlab.ehr.core.sal.service.logic.impl;

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

import cn.ibizlab.ehr.core.sal.service.logic.ISalSchemeItemSetOrderNumLogic;
import cn.ibizlab.ehr.core.sal.domain.SalSchemeItem;

/**
 * 关系型数据实体[SetOrderNum] 对象
 */
@Slf4j
@Service
public class SalSchemeItemSetOrderNumLogicImpl implements ISalSchemeItemSetOrderNumLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(SalSchemeItem et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("salschemeitemsetordernumdefault",et);
           kieSession.setGlobal("iBzSysSalschemeitemDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.sal.service.logic.salschemeitemsetordernum");

        }catch(Exception e){
            throw new RuntimeException("执行[设置默认序号]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
