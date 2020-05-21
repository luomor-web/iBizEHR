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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.wf.domain.WFInstance;
import cn.ibizlab.ehr.core.wf.filter.WFInstanceSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFInstance] 服务对象接口
 */
public interface IWFInstanceService extends IService<WFInstance>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFInstance getDraft(WFInstance et) ;
    boolean save(WFInstance et) ;
    void saveBatch(List<WFInstance> list) ;
    boolean create(WFInstance et) ;
    void createBatch(List<WFInstance> list) ;
    WFInstance get(String key) ;
    boolean update(WFInstance et) ;
    void updateBatch(List<WFInstance> list) ;
    boolean checkKey(WFInstance et) ;
    WFInstance restart(WFInstance et) ;
    WFInstance userCancel(WFInstance et) ;
    Page<WFInstance> searchDefault(WFInstanceSearchContext context) ;
    List<WFInstance> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
    List<WFInstance> selectByPwfinstanceid(String wfinstanceid) ;
    void removeByPwfinstanceid(String wfinstanceid) ;
    List<WFInstance> selectByWfworkflowid(String wfworkflowid) ;
    void removeByWfworkflowid(String wfworkflowid) ;
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


