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

import cn.ibizlab.ehr.core.common.service.logic.IOrgUserUpdateRelatedInfoLogic;
import cn.ibizlab.ehr.core.common.domain.OrgUser;

/**
 * 关系型数据实体[UpdateRelatedInfo] 对象
 */
@Slf4j
@Service
public class OrgUserUpdateRelatedInfoLogicImpl implements IOrgUserUpdateRelatedInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.common.service.IUserService userservice;

    public cn.ibizlab.ehr.core.common.service.IUserService getUserService() {
        return this.userservice;
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
           kieSession.setGlobal("orguserupdaterelatedinfodefault",et);
           cn.ibizlab.ehr.core.common.domain.User  orguserupdaterelatedinfouser =new cn.ibizlab.ehr.core.common.domain.User();
           kieSession.insert(orguserupdaterelatedinfouser); 
           kieSession.setGlobal("orguserupdaterelatedinfouser",orguserupdaterelatedinfouser);
           kieSession.setGlobal("userservice",userservice);
           kieSession.setGlobal("iBzSysOrguserDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.common.service.logic.orguserupdaterelatedinfo");

        }catch(Exception e){
            throw new RuntimeException("执行[更新关联信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
