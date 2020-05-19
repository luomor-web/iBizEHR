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

import cn.ibizlab.ehr.core.wf.domain.WFStep;
import cn.ibizlab.ehr.core.wf.filter.WFStepSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFStep] 服务对象接口
 */
public interface IWFStepService extends IService<WFStep>{

    WFStep get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFStep getDraft(WFStep et) ;
    boolean create(WFStep et) ;
    void createBatch(List<WFStep> list) ;
    boolean checkKey(WFStep et) ;
    boolean save(WFStep et) ;
    void saveBatch(List<WFStep> list) ;
    boolean update(WFStep et) ;
    void updateBatch(List<WFStep> list) ;
    Page<WFStep> searchDefault(WFStepSearchContext context) ;
    List<WFStep> selectByWfinstanceid(String wfinstanceid) ;
    void removeByWfinstanceid(String wfinstanceid) ;
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


