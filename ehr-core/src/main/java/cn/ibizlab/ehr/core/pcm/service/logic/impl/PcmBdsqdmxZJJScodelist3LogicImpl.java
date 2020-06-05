package cn.ibizlab.ehr.core.pcm.service.logic.impl;

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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxZJJScodelist3Logic;
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;

/**
 * 关系型数据实体[ZJJScodelist3] 对象
 */
@Slf4j
@Service
public class PcmBdsqdmxZJJScodelist3LogicImpl implements IPcmBdsqdmxZJJScodelist3Logic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.common.service.ICodeList1Service codelist1service;

    public cn.ibizlab.ehr.core.common.service.ICodeList1Service getCodelist1Service() {
        return this.codelist1service;
    }


    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService iBzSysDefaultService;

    public cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(PcmBdsqdmx et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("pcmbdsqdmxzjjscodelist3default",et);
           cn.ibizlab.ehr.core.common.domain.CodeList1  pcmbdsqdmxzjjscodelist3zjcodelist =new cn.ibizlab.ehr.core.common.domain.CodeList1();
           kieSession.insert(pcmbdsqdmxzjjscodelist3zjcodelist); 
           kieSession.setGlobal("pcmbdsqdmxzjjscodelist3zjcodelist",pcmbdsqdmxzjjscodelist3zjcodelist);
           kieSession.setGlobal("codelist1service",codelist1service);
           kieSession.setGlobal("iBzSysPcmbdsqdmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmbdsqdmxzjjscodelist3");

        }catch(Exception e){
            throw new RuntimeException("执行[职级晋升（局）]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
