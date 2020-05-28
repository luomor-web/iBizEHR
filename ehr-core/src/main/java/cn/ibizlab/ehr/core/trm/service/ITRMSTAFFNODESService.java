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

import cn.ibizlab.ehr.core.trm.domain.TRMSTAFFNODES;
import cn.ibizlab.ehr.core.trm.filter.TRMSTAFFNODESSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMSTAFFNODES] 服务对象接口
 */
public interface ITRMSTAFFNODESService extends IService<TRMSTAFFNODES>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMSTAFFNODES get(String key) ;
    boolean checkKey(TRMSTAFFNODES et) ;
    boolean update(TRMSTAFFNODES et) ;
    void updateBatch(List<TRMSTAFFNODES> list) ;
    boolean save(TRMSTAFFNODES et) ;
    void saveBatch(List<TRMSTAFFNODES> list) ;
    TRMSTAFFNODES getDraft(TRMSTAFFNODES et) ;
    boolean create(TRMSTAFFNODES et) ;
    void createBatch(List<TRMSTAFFNODES> list) ;
    Page<TRMSTAFFNODES> searchDefault(TRMSTAFFNODESSearchContext context) ;
    List<TRMSTAFFNODES> selectByTrmstaffid(String trmstaffid) ;
    void removeByTrmstaffid(String trmstaffid) ;
    List<TRMSTAFFNODES> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
    List<TRMSTAFFNODES> selectByTrmtraincourseid(String trmtraincourseid) ;
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

    List<TRMSTAFFNODES> getTrmstaffnodesByIds(List<String> ids) ;
    List<TRMSTAFFNODES> getTrmstaffnodesByEntities(List<TRMSTAFFNODES> entities) ;

}


