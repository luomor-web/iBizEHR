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

import cn.ibizlab.ehr.core.orm.service.logic.IOrmDutysetOrderNumLogic;
import cn.ibizlab.ehr.core.orm.domain.OrmDuty;

/**
 * 关系型数据实体[setOrderNum] 对象
 */
@Slf4j
@Service
public class OrmDutysetOrderNumLogicImpl implements IOrmDutysetOrderNumLogic{

    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private cn.ibizlab.ehr.core.orm.service.IOrmDutyService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.orm.service.IOrmDutyService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(OrmDuty et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("ormdutysetordernumdefault",et);
           kieSession.setGlobal("iBzSysOrmdutyDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.orm.service.logic.ormdutysetordernum");

        }catch(Exception e){
            throw new RuntimeException("执行[设置排序号规则]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
