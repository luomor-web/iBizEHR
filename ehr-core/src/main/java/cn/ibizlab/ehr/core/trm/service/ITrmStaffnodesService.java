package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TrmStaffnodes;
import cn.ibizlab.ehr.core.trm.filter.TrmStaffnodesSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmStaffnodes] 服务对象接口
 */
public interface ITrmStaffnodesService extends IService<TrmStaffnodes>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmStaffnodes get(String key) ;
    boolean checkKey(TrmStaffnodes et) ;
    boolean update(TrmStaffnodes et) ;
    void updateBatch(List<TrmStaffnodes> list) ;
    boolean save(TrmStaffnodes et) ;
    void saveBatch(List<TrmStaffnodes> list) ;
    TrmStaffnodes getDraft(TrmStaffnodes et) ;
    boolean create(TrmStaffnodes et) ;
    void createBatch(List<TrmStaffnodes> list) ;
    Page<TrmStaffnodes> searchDefault(TrmStaffnodesSearchContext context) ;
    List<TrmStaffnodes> selectByTrmstaffid(String trmstaffid) ;
    void removeByTrmstaffid(String trmstaffid) ;
    List<TrmStaffnodes> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
    List<TrmStaffnodes> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
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

    List<TrmStaffnodes> getTrmstaffnodesByIds(List<String> ids) ;
    List<TrmStaffnodes> getTrmstaffnodesByEntities(List<TrmStaffnodes> entities) ;

}


