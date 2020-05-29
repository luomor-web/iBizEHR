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

import cn.ibizlab.ehr.core.trm.domain.TrmDemdeftion;
import cn.ibizlab.ehr.core.trm.filter.TrmDemdeftionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmDemdeftion] 服务对象接口
 */
public interface ITrmDemdeftionService extends IService<TrmDemdeftion>{

    TrmDemdeftion getDraft(TrmDemdeftion et) ;
    boolean create(TrmDemdeftion et) ;
    void createBatch(List<TrmDemdeftion> list) ;
    boolean update(TrmDemdeftion et) ;
    void updateBatch(List<TrmDemdeftion> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TrmDemdeftion et) ;
    void saveBatch(List<TrmDemdeftion> list) ;
    boolean checkKey(TrmDemdeftion et) ;
    TrmDemdeftion get(String key) ;
    Page<TrmDemdeftion> searchDefault(TrmDemdeftionSearchContext context) ;
    List<TrmDemdeftion> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmDemdeftion> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmDemdeftion> selectByTrmdepartid(String trmdepartid) ;
    void removeByTrmdepartid(String trmdepartid) ;
    List<TrmDemdeftion> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TrmDemdeftion> selectByTrmtrainfillinid(String trmtrainfillinid) ;
    void removeByTrmtrainfillinid(String trmtrainfillinid) ;
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

    List<TrmDemdeftion> getTrmdemdeftionByIds(List<String> ids) ;
    List<TrmDemdeftion> getTrmdemdeftionByEntities(List<TrmDemdeftion> entities) ;

}


