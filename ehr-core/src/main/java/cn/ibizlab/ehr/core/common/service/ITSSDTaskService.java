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

import cn.ibizlab.ehr.core.common.domain.TSSDTask;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TSSDTask] 服务对象接口
 */
public interface ITSSDTaskService extends IService<TSSDTask>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(TSSDTask et) ;
    void createBatch(List<TSSDTask> list) ;
    boolean update(TSSDTask et) ;
    void updateBatch(List<TSSDTask> list) ;
    boolean checkKey(TSSDTask et) ;
    TSSDTask getDraft(TSSDTask et) ;
    boolean save(TSSDTask et) ;
    void saveBatch(List<TSSDTask> list) ;
    TSSDTask get(String key) ;
    Page<TSSDTask> searchDefault(TSSDTaskSearchContext context) ;
    List<TSSDTask> selectByTssdengineid(String tssdengineid) ;
    void removeByTssdengineid(String tssdengineid) ;
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


