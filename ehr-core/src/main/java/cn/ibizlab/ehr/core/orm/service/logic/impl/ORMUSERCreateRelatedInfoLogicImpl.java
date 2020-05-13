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

import cn.ibizlab.ehr.core.orm.service.logic.IORMUSERCreateRelatedInfoLogic;
import cn.ibizlab.ehr.core.orm.domain.ORMUSER;

/**
 * 关系型数据实体[CreateRelatedInfo] 对象
 */
@Slf4j
@Service
public class ORMUSERCreateRelatedInfoLogicImpl implements IORMUSERCreateRelatedInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.common.service.IUserDictService userdictservice;

    public cn.ibizlab.ehr.core.common.service.IUserDictService getUserdictService() {
        return this.userdictservice;
    }

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
           kieSession.insert(et); 
           kieSession.setGlobal("ormusercreaterelatedinfodefault",et);
           cn.ibizlab.ehr.core.common.domain.UserDict  ormusercreaterelatedinfouserdict =new cn.ibizlab.ehr.core.common.domain.UserDict();
           kieSession.insert(ormusercreaterelatedinfouserdict); 
           kieSession.setGlobal("ormusercreaterelatedinfouserdict",ormusercreaterelatedinfouserdict);
           cn.ibizlab.ehr.core.common.domain.User  ormusercreaterelatedinfouser =new cn.ibizlab.ehr.core.common.domain.User();
           kieSession.insert(ormusercreaterelatedinfouser); 
           kieSession.setGlobal("ormusercreaterelatedinfouser",ormusercreaterelatedinfouser);
           kieSession.setGlobal("userdictservice",userdictservice);
           kieSession.setGlobal("userservice",userservice);
           kieSession.setGlobal("iBzSysOrmuserDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.orm.service.logic.ormusercreaterelatedinfo");

        }catch(Exception e){
            throw new RuntimeException("执行[建立关联信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
