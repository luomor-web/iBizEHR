package cn.ibizlab.ehr.core.orm.service.logic.impl;

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

import cn.ibizlab.ehr.core.orm.service.logic.IORMUSERUpdateRelatedInfoLogic;
import cn.ibizlab.ehr.core.orm.domain.ORMUSER;

/**
 * 关系型数据实体[UpdateRelatedInfo] 对象
 */
@Slf4j
@Service
public class ORMUSERUpdateRelatedInfoLogicImpl implements IORMUSERUpdateRelatedInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.common.service.IUserService userservice;

    public cn.ibizlab.ehr.core.common.service.IUserService getUserService() {
        return this.userservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.orm.service.IORMUSERService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.orm.service.IORMUSERService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(ORMUSER et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           cn.ibizlab.ehr.core.common.domain.User  ormuserupdaterelatedinfouser =new cn.ibizlab.ehr.core.common.domain.User();
           kieSession.insert(ormuserupdaterelatedinfouser); 
           kieSession.setGlobal("ormuserupdaterelatedinfouser",ormuserupdaterelatedinfouser);
           kieSession.insert(et); 
           kieSession.setGlobal("ormuserupdaterelatedinfodefault",et);
           kieSession.setGlobal("userservice",userservice);
           kieSession.setGlobal("iBzSysOrmuserDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.orm.service.logic.ormuserupdaterelatedinfo");

        }catch(Exception e){
            throw new RuntimeException("执行[更新关联信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
