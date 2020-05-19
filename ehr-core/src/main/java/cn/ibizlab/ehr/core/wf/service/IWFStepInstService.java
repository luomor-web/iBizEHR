package cn.ibizlab.ehr.core.wf.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.alibaba.fastjson.JSONObject;

import cn.ibizlab.ehr.core.wf.domain.WFStepInst;
import cn.ibizlab.ehr.core.wf.filter.WFStepInstSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFStepInst] 服务对象接口
 */
public interface IWFStepInstService extends IService<WFStepInst>{

    boolean update(WFStepInst et) ;
    void updateBatch(List<WFStepInst> list) ;
    boolean checkKey(WFStepInst et) ;
    WFStepInst getDraft(WFStepInst et) ;
    WFStepInst get(String key) ;
    boolean save(WFStepInst et) ;
    void saveBatch(List<WFStepInst> list) ;
    boolean create(WFStepInst et) ;
    void createBatch(List<WFStepInst> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<WFStepInst> searchDefault(WFStepInstSearchContext context) ;
    List<WFStepInst> selectByWfinstanceid(String wfinstanceid) ;
    void removeByWfinstanceid(String wfinstanceid) ;
    List<WFStepInst> selectByWfstepid(String wfstepid) ;
    void removeByWfstepid(String wfstepid) ;
    /**
     *自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return select * from table where id = '1'
     */
    List<JSONObject> select(String sql, Map param);
    /**
     *自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return     update table  set name ='test' where id = '1'
     */
    boolean execute(String sql, Map param);

}


