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

import cn.ibizlab.ehr.core.trm.domain.TrmEmployeeRetion;
import cn.ibizlab.ehr.core.trm.filter.TrmEmployeeRetionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmEmployeeRetion] 服务对象接口
 */
public interface ITrmEmployeeRetionService extends IService<TrmEmployeeRetion>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmEmployeeRetion getDraft(TrmEmployeeRetion et) ;
    boolean update(TrmEmployeeRetion et) ;
    void updateBatch(List<TrmEmployeeRetion> list) ;
    boolean save(TrmEmployeeRetion et) ;
    void saveBatch(List<TrmEmployeeRetion> list) ;
    boolean create(TrmEmployeeRetion et) ;
    void createBatch(List<TrmEmployeeRetion> list) ;
    boolean checkKey(TrmEmployeeRetion et) ;
    TrmEmployeeRetion get(String key) ;
    Page<TrmEmployeeRetion> searchDefault(TrmEmployeeRetionSearchContext context) ;
    List<TrmEmployeeRetion> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmEmployeeRetion> selectByTrmcouarrangeid(String trmcouarrangeid) ;
    void removeByTrmcouarrangeid(String trmcouarrangeid) ;
    List<TrmEmployeeRetion> selectByTrmtrainactapplyid(String trmtrainactapplyid) ;
    void removeByTrmtrainactapplyid(String trmtrainactapplyid) ;
    List<TrmEmployeeRetion> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmEmployeeRetion> getTrmemployeeretionByIds(List<String> ids) ;
    List<TrmEmployeeRetion> getTrmemployeeretionByEntities(List<TrmEmployeeRetion> entities) ;

}


