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

import cn.ibizlab.ehr.core.wf.domain.WFUCPolicy;
import cn.ibizlab.ehr.core.wf.filter.WFUCPolicySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFUCPolicy] 服务对象接口
 */
public interface IWFUCPolicyService extends IService<WFUCPolicy>{

    WFUCPolicy get(String key) ;
    WFUCPolicy disablePolicy(WFUCPolicy et) ;
    boolean save(WFUCPolicy et) ;
    void saveBatch(List<WFUCPolicy> list) ;
    boolean update(WFUCPolicy et) ;
    void updateBatch(List<WFUCPolicy> list) ;
    boolean create(WFUCPolicy et) ;
    void createBatch(List<WFUCPolicy> list) ;
    WFUCPolicy enablePolicy(WFUCPolicy et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFUCPolicy et) ;
    WFUCPolicy getDraft(WFUCPolicy et) ;
    Page<WFUCPolicy> searchDefault(WFUCPolicySearchContext context) ;
    List<WFUCPolicy> selectByMajorwfuserid(String wfuserid) ;
    void removeByMajorwfuserid(String wfuserid) ;
    List<WFUCPolicy> selectByMinorwfuserid(String wfuserid) ;
    void removeByMinorwfuserid(String wfuserid) ;
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


