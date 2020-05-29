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

import cn.ibizlab.ehr.core.trm.domain.TrmHmatser;
import cn.ibizlab.ehr.core.trm.filter.TrmHmatserSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmHmatser] 服务对象接口
 */
public interface ITrmHmatserService extends IService<TrmHmatser>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TrmHmatser et) ;
    void saveBatch(List<TrmHmatser> list) ;
    boolean update(TrmHmatser et) ;
    void updateBatch(List<TrmHmatser> list) ;
    boolean create(TrmHmatser et) ;
    void createBatch(List<TrmHmatser> list) ;
    boolean checkKey(TrmHmatser et) ;
    TrmHmatser getDraft(TrmHmatser et) ;
    TrmHmatser get(String key) ;
    Page<TrmHmatser> searchDefault(TrmHmatserSearchContext context) ;
    List<TrmHmatser> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmHmatser> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmHmatser> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmHmatser> getTrmhmatserByIds(List<String> ids) ;
    List<TrmHmatser> getTrmhmatserByEntities(List<TrmHmatser> entities) ;

}


