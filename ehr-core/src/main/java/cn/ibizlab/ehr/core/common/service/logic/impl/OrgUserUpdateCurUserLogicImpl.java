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

import cn.ibizlab.ehr.core.common.service.logic.IOrgUserUpdateCurUserLogic;
import cn.ibizlab.ehr.core.common.domain.OrgUser;

/**
 * 关系型数据实体[UpdateCurUser] 对象
 */
@Slf4j
@Service
public class OrgUserUpdateCurUserLogicImpl implements IOrgUserUpdateCurUserLogic{

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
           kieSession.setGlobal("orguserupdatecuruserdefault",et);
           kieSession.setGlobal("orguserservice",orguserservice);
           kieSession.setGlobal("iBzSysOrguserDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.common.service.logic.orguserupdatecuruser");

        }catch(Exception e){
            throw new RuntimeException("执行[更新当前用户]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
