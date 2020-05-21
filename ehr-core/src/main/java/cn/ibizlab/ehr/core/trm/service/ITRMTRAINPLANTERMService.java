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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINPLANTERMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINPLANTERM] 服务对象接口
 */
public interface ITRMTRAINPLANTERMService extends IService<TRMTRAINPLANTERM>{

    TRMTRAINPLANTERM get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TRMTRAINPLANTERM et) ;
    boolean update(TRMTRAINPLANTERM et) ;
    void updateBatch(List<TRMTRAINPLANTERM> list) ;
    boolean save(TRMTRAINPLANTERM et) ;
    void saveBatch(List<TRMTRAINPLANTERM> list) ;
    TRMTRAINPLANTERM getDraft(TRMTRAINPLANTERM et) ;
    TRMTRAINPLANTERM kB(TRMTRAINPLANTERM et) ;
    boolean create(TRMTRAINPLANTERM et) ;
    void createBatch(List<TRMTRAINPLANTERM> list) ;
    TRMTRAINPLANTERM qX(TRMTRAINPLANTERM et) ;
    TRMTRAINPLANTERM lX(TRMTRAINPLANTERM et) ;
    Page<TRMTRAINPLANTERM> searchDefault(TRMTRAINPLANTERMSearchContext context) ;
    List<TRMTRAINPLANTERM> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
    List<TRMTRAINPLANTERM> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TRMTRAINPLANTERM> selectByTrmtrainplanid(String trmtrainplanid) ;
    void removeByTrmtrainplanid(String trmtrainplanid) ;
    List<TRMTRAINPLANTERM> selectByTrmtrainteacherid(String trmtrainteacherid) ;
    void removeByTrmtrainteacherid(String trmtrainteacherid) ;
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


