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

import cn.ibizlab.ehr.core.trm.domain.TRMSTAY;
import cn.ibizlab.ehr.core.trm.filter.TRMSTAYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMSTAY] 服务对象接口
 */
public interface ITRMSTAYService extends IService<TRMSTAY>{

    TRMSTAY getDraft(TRMSTAY et) ;
    TRMSTAY get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMSTAY et) ;
    void saveBatch(List<TRMSTAY> list) ;
    boolean update(TRMSTAY et) ;
    void updateBatch(List<TRMSTAY> list) ;
    boolean create(TRMSTAY et) ;
    void createBatch(List<TRMSTAY> list) ;
    boolean checkKey(TRMSTAY et) ;
    Page<TRMSTAY> searchDefault(TRMSTAYSearchContext context) ;
    List<TRMSTAY> selectByTrmtrainaddressid(String trmtrainaddressid) ;
    void removeByTrmtrainaddressid(String trmtrainaddressid) ;
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

    List<TRMSTAY> getTrmstayByIds(List<String> ids) ;
    List<TRMSTAY> getTrmstayByEntities(List<TRMSTAY> entities) ;

}


