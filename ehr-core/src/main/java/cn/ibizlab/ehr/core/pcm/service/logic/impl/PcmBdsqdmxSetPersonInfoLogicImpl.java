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

import cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxSetPersonInfoLogic;
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;

/**
 * 关系型数据实体[SetPersonInfo] 对象
 */
@Slf4j
@Service
public class PcmBdsqdmxSetPersonInfoLogicImpl implements IPcmBdsqdmxSetPersonInfoLogic{

    @Autowired
    private KieContainer kieContainer;

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
           cn.ibizlab.ehr.core.pim.domain.PimPerson  pcmbdsqdmxsetpersoninfopimperson =new cn.ibizlab.ehr.core.pim.domain.PimPerson();
           kieSession.insert(pcmbdsqdmxsetpersoninfopimperson); 
           kieSession.setGlobal("pcmbdsqdmxsetpersoninfopimperson",pcmbdsqdmxsetpersoninfopimperson);
           kieSession.insert(et); 
           kieSession.setGlobal("pcmbdsqdmxsetpersoninfodefault",et);
           kieSession.setGlobal("pimpersonservice",pimpersonservice);
           kieSession.setGlobal("iBzSysPcmbdsqdmxDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.ehr.core.pcm.service.logic.pcmbdsqdmxsetpersoninfo");

        }catch(Exception e){
            throw new RuntimeException("执行[设置职级、组织、部门、员工编号、职务]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
