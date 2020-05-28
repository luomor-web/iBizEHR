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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAFFIC;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAFFICSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAFFIC] 服务对象接口
 */
public interface ITRMTRAFFICService extends IService<TRMTRAFFIC>{

    TRMTRAFFIC getDraft(TRMTRAFFIC et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMTRAFFIC et) ;
    void saveBatch(List<TRMTRAFFIC> list) ;
    TRMTRAFFIC get(String key) ;
    boolean update(TRMTRAFFIC et) ;
    void updateBatch(List<TRMTRAFFIC> list) ;
    boolean create(TRMTRAFFIC et) ;
    void createBatch(List<TRMTRAFFIC> list) ;
    boolean checkKey(TRMTRAFFIC et) ;
    Page<TRMTRAFFIC> searchDefault(TRMTRAFFICSearchContext context) ;
    List<TRMTRAFFIC> selectByTrmtrainaddressid(String trmtrainaddressid) ;
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

    List<TRMTRAFFIC> getTrmtrafficByIds(List<String> ids) ;
    List<TRMTRAFFIC> getTrmtrafficByEntities(List<TRMTRAFFIC> entities) ;

}


