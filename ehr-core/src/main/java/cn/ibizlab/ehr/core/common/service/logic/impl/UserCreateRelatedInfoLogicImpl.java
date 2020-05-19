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

import cn.ibizlab.ehr.core.common.service.logic.IUserCreateRelatedInfoLogic;
import cn.ibizlab.ehr.core.common.domain.User;

/**
 * 关系型数据实体[CreateRelatedInfo] 对象
 */
@Slf4j
@Service
public class UserCreateRelatedInfoLogicImpl implements IUserCreateRelatedInfoLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.common.service.IMsgAccountService msgaccountservice;

    public cn.ibizlab.ehr.core.common.service.IMsgAccountService getMsgaccountService() {
        return this.msgaccountservice;
    }

    @Autowired
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserservice;

    public cn.ibizlab.ehr.core.wf.service.IWFUserService getWfuserService() {
        return this.wfuserservice;
    }


    @Autowired
    private cn.ibizlab.ehr.core.common.service.IUserService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.common.service.IUserService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(User et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           cn.ibizlab.ehr.core.common.domain.MsgAccount  usercreaterelatedinfomsgaccount =new cn.ibizlab.ehr.core.common.domain.MsgAccount();
           kieSession.insert(usercreaterelatedinfomsgaccount); 
           kieSession.setGlobal("usercreaterelatedinfomsgaccount",usercreaterelatedinfomsgaccount);
           kieSession.insert(et); 
           kieSession.setGlobal("usercreaterelatedinfodefault",et);
           cn.ibizlab.ehr.core.wf.domain.WFUser  usercreaterelatedinfowfuser =new cn.ibizlab.ehr.core.wf.domain.WFUser();
           kieSession.insert(usercreaterelatedinfowfuser); 
           kieSession.setGlobal("usercreaterelatedinfowfuser",usercreaterelatedinfowfuser);
           kieSession.setGlobal("msgaccountservice",msgaccountservice);
           kieSession.setGlobal("wfuserservice",wfuserservice);
           kieSession.setGlobal("iBzSysUserDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.common.service.logic.usercreaterelatedinfo");

        }catch(Exception e){
            throw new RuntimeException("执行[建立用户相关信息]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
