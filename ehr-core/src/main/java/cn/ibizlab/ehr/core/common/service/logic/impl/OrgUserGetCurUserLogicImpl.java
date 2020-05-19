package cn.ibizlab.ehr.core.common.service.logic.impl;

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

import cn.ibizlab.ehr.core.common.service.logic.IOrgUserGetCurUserLogic;
import cn.ibizlab.ehr.core.common.domain.OrgUser;

/**
 * 关系型数据实体[GetCurUser] 对象
 */
@Slf4j
@Service
public class OrgUserGetCurUserLogicImpl implements IOrgUserGetCurUserLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.common.service.IOrgUserService orguserservice;

    public cn.ibizlab.ehr.core.common.service.IOrgUserService getOrguserService() {
        return this.orguserservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.common.service.IOrgUserService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.common.service.IOrgUserService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(OrgUser et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("orgusergetcuruserdefault",et);
           kieSession.setGlobal("orguserservice",orguserservice);
           kieSession.setGlobal("iBzSysOrguserDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.common.service.logic.orgusergetcuruser");

        }catch(Exception e){
            throw new RuntimeException("执行[获取当前用户]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
