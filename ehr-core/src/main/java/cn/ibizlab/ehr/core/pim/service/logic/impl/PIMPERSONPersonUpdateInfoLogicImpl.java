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

import cn.ibizlab.ehr.core.pim.service.logic.IPIMPERSONPersonUpdateInfoLogic;
import cn.ibizlab.ehr.core.pim.domain.PIMPERSON;

/**
 * 关系型数据实体[PersonUpdateInfo] 对象
 */
@Slf4j
@Service
public class PIMPERSONPersonUpdateInfoLogicImpl implements IPIMPERSONPersonUpdateInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPIMPERSONService getPimpersonService() {
        return this.pimpersonservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pim.service.IPIMPERSONService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PIMPERSON et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pimpersonpersonupdateinfodefault",et);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPimpersonDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pim.service.logic.pimpersonpersonupdateinfo");

        }catch(Exception e){
            throw new RuntimeException("执行[根据证件号更改出生日期、性别、年龄]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
