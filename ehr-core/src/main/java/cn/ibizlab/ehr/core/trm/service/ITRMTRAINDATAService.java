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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDATA;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDATASearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINDATA] 服务对象接口
 */
public interface ITRMTRAINDATAService extends IService<TRMTRAINDATA>{

    boolean save(TRMTRAINDATA et) ;
    void saveBatch(List<TRMTRAINDATA> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMTRAINDATA get(String key) ;
    TRMTRAINDATA getDraft(TRMTRAINDATA et) ;
    boolean update(TRMTRAINDATA et) ;
    void updateBatch(List<TRMTRAINDATA> list) ;
    boolean checkKey(TRMTRAINDATA et) ;
    boolean create(TRMTRAINDATA et) ;
    void createBatch(List<TRMTRAINDATA> list) ;
    Page<TRMTRAINDATA> searchDefault(TRMTRAINDATASearchContext context) ;
    List<TRMTRAINDATA> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMTRAINDATA> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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


