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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINBUAPPLY;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINBUAPPLYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINBUAPPLY] 服务对象接口
 */
public interface ITRMTRAINBUAPPLYService extends IService<TRMTRAINBUAPPLY>{

    boolean create(TRMTRAINBUAPPLY et) ;
    void createBatch(List<TRMTRAINBUAPPLY> list) ;
    boolean update(TRMTRAINBUAPPLY et) ;
    void updateBatch(List<TRMTRAINBUAPPLY> list) ;
    TRMTRAINBUAPPLY getDraft(TRMTRAINBUAPPLY et) ;
    TRMTRAINBUAPPLY get(String key) ;
    boolean checkKey(TRMTRAINBUAPPLY et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMTRAINBUAPPLY et) ;
    void saveBatch(List<TRMTRAINBUAPPLY> list) ;
    Page<TRMTRAINBUAPPLY> searchDefault(TRMTRAINBUAPPLYSearchContext context) ;
    List<TRMTRAINBUAPPLY> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMTRAINBUAPPLY> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
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


