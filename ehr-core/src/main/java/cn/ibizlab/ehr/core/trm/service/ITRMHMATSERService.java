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

import cn.ibizlab.ehr.core.trm.domain.TRMHMATSER;
import cn.ibizlab.ehr.core.trm.filter.TRMHMATSERSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMHMATSER] 服务对象接口
 */
public interface ITRMHMATSERService extends IService<TRMHMATSER>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMHMATSER et) ;
    void saveBatch(List<TRMHMATSER> list) ;
    boolean update(TRMHMATSER et) ;
    void updateBatch(List<TRMHMATSER> list) ;
    boolean create(TRMHMATSER et) ;
    void createBatch(List<TRMHMATSER> list) ;
    boolean checkKey(TRMHMATSER et) ;
    TRMHMATSER getDraft(TRMHMATSER et) ;
    TRMHMATSER get(String key) ;
    Page<TRMHMATSER> searchDefault(TRMHMATSERSearchContext context) ;
    List<TRMHMATSER> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMHMATSER> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMHMATSER> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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

}


