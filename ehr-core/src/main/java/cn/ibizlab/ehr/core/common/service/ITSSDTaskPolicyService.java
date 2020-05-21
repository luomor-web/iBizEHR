package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.TSSDTaskPolicy;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskPolicySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TSSDTaskPolicy] 服务对象接口
 */
public interface ITSSDTaskPolicyService extends IService<TSSDTaskPolicy>{

    TSSDTaskPolicy getDraft(TSSDTaskPolicy et) ;
    boolean update(TSSDTaskPolicy et) ;
    void updateBatch(List<TSSDTaskPolicy> list) ;
    boolean checkKey(TSSDTaskPolicy et) ;
    boolean create(TSSDTaskPolicy et) ;
    void createBatch(List<TSSDTaskPolicy> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TSSDTaskPolicy et) ;
    void saveBatch(List<TSSDTaskPolicy> list) ;
    TSSDTaskPolicy get(String key) ;
    Page<TSSDTaskPolicy> searchDefault(TSSDTaskPolicySearchContext context) ;
    List<TSSDTaskPolicy> selectByTssdpolicyid(String tssdpolicyid) ;
    void removeByTssdpolicyid(String tssdpolicyid) ;
    List<TSSDTaskPolicy> selectByTssdtaskid(String tssdtaskid) ;
    void removeByTssdtaskid(String tssdtaskid) ;
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


