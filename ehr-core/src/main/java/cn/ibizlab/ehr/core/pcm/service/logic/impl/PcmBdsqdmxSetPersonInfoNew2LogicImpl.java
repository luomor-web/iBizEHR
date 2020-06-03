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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxSetPersonInfoNew2Logic;
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;

/**
 * 关系型数据实体[SetPersonInfoNew2] 对象
 */
@Slf4j
@Service
public class PcmBdsqdmxSetPersonInfoNew2LogicImpl implements IPcmBdsqdmxSetPersonInfoNew2Logic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService pcmbdsqdmxservice;

    public cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService getPcmbdsqdmxService() {
        return this.pcmbdsqdmxservice;
    }

    @Autowired
    private cn.ibizlab.ehr.core.common.service.ICodeList1Service codelist1service;

    public cn.ibizlab.ehr.core.common.service.ICodeList1Service getCodelist1Service() {
        return this.codelist1service;
    }

    @Autowired
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonservice;

    public cn.ibizlab.ehr.core.pim.service.IPimPersonService getPimpersonService() {
        return this.pimpersonservice;
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
           kieSession.setGlobal("pcmbdsqdmxsetpersoninfonew2default",et);
           cn.ibizlab.ehr.core.pim.domain.PimPerson  pcmbdsqdmxsetpersoninfonew2pimperson =new cn.ibizlab.ehr.core.pim.domain.PimPerson();
           kieSession.insert(pcmbdsqdmxsetpersoninfonew2pimperson); 
           kieSession.setGlobal("pcmbdsqdmxsetpersoninfonew2pimperson",pcmbdsqdmxsetpersoninfonew2pimperson);
           cn.ibizlab.ehr.core.common.domain.CodeList1  pcmbdsqdmxsetpersoninfonew2zjcodelist =new cn.ibizlab.ehr.core.common.domain.CodeList1();
           kieSession.insert(pcmbdsqdmxsetpersoninfonew2zjcodelist); 
           kieSession.setGlobal("pcmbdsqdmxsetpersoninfonew2zjcodelist",pcmbdsqdmxsetpersoninfonew2zjcodelist);
           kieSession.setGlobal("pcmbdsqdmxservice",pcmbdsqdmxservice);
           kieSession.setGlobal("codelist1service",codelist1service);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPcmbdsqdmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmbdsqdmxsetpersoninfonew2");

        }catch(Exception e){
            throw new RuntimeException("执行[设置职级、组织、部门、员工编号、职务、新职级NEW]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
