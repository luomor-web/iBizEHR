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

import cn.ibizlab.ehr.core.common.service.logic.IOrgUserCreateRelatedInfoLogic;
import cn.ibizlab.ehr.core.common.domain.OrgUser;

/**
 * 关系型数据实体[CreateRelatedInfo] 对象
 */
@Slf4j
@Service
public class OrgUserCreateRelatedInfoLogicImpl implements IOrgUserCreateRelatedInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.common.service.IUserService userservice;

    public cn.ibizlab.ehr.core.common.service.IUserService getUserService() {
        return this.userservice;
    }

    @Autowired
    private cn.ibizlab.ehr.core.common.service.IUserDictService userdictservice;

    public cn.ibizlab.ehr.core.common.service.IUserDictService getUserdictService() {
        return this.userdictservice;
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
           cn.ibizlab.ehr.core.common.domain.User  orgusercreaterelatedinfouser =new cn.ibizlab.ehr.core.common.domain.User();
           kieSession.insert(orgusercreaterelatedinfouser); 
           kieSession.setGlobal("orgusercreaterelatedinfouser",orgusercreaterelatedinfouser);
           cn.ibizlab.ehr.core.common.domain.UserDict  orgusercreaterelatedinfouserdict =new cn.ibizlab.ehr.core.common.domain.UserDict();
           kieSession.insert(orgusercreaterelatedinfouserdict); 
           kieSession.setGlobal("orgusercreaterelatedinfouserdict",orgusercreaterelatedinfouserdict);
           kieSession.insert(et); 
           kieSession.setGlobal("orgusercreaterelatedinfodefault",et);
           kieSession.setGlobal("userservice",userservice);
           kieSession.setGlobal("userdictservice",userdictservice);
           kieSession.setGlobal("iBzSysOrguserDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.common.service.logic.orgusercreaterelatedinfo");

        }catch(Exception e){
            throw new RuntimeException("执行[建立关联信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
