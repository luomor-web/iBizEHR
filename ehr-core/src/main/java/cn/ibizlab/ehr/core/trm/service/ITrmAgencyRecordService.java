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

import cn.ibizlab.ehr.core.trm.domain.TrmAgencyRecord;
import cn.ibizlab.ehr.core.trm.filter.TrmAgencyRecordSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmAgencyRecord] 服务对象接口
 */
public interface ITrmAgencyRecordService extends IService<TrmAgencyRecord>{

    TrmAgencyRecord getDraft(TrmAgencyRecord et) ;
    TrmAgencyRecord get(String key) ;
    boolean checkKey(TrmAgencyRecord et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TrmAgencyRecord et) ;
    void saveBatch(List<TrmAgencyRecord> list) ;
    boolean update(TrmAgencyRecord et) ;
    void updateBatch(List<TrmAgencyRecord> list) ;
    boolean create(TrmAgencyRecord et) ;
    void createBatch(List<TrmAgencyRecord> list) ;
    Page<TrmAgencyRecord> searchDefault(TrmAgencyRecordSearchContext context) ;
    List<TrmAgencyRecord> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmAgencyRecord> getTrmagencyrecordByIds(List<String> ids) ;
    List<TrmAgencyRecord> getTrmagencyrecordByEntities(List<TrmAgencyRecord> entities) ;

}


