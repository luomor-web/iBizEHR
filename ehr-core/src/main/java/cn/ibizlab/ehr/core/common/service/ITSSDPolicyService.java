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

import cn.ibizlab.ehr.core.common.domain.TSSDPolicy;
import cn.ibizlab.ehr.core.common.filter.TSSDPolicySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TSSDPolicy] 服务对象接口
 */
public interface ITSSDPolicyService extends IService<TSSDPolicy>{

    boolean create(TSSDPolicy et) ;
    void createBatch(List<TSSDPolicy> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TSSDPolicy et) ;
    boolean update(TSSDPolicy et) ;
    void updateBatch(List<TSSDPolicy> list) ;
    TSSDPolicy getDraft(TSSDPolicy et) ;
    boolean save(TSSDPolicy et) ;
    void saveBatch(List<TSSDPolicy> list) ;
    TSSDPolicy get(String key) ;
    Page<TSSDPolicy> searchDefault(TSSDPolicySearchContext context) ;
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


