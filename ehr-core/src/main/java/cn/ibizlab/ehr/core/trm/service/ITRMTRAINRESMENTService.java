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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINRESMENT;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINRESMENTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINRESMENT] 服务对象接口
 */
public interface ITRMTRAINRESMENTService extends IService<TRMTRAINRESMENT>{

    boolean update(TRMTRAINRESMENT et) ;
    void updateBatch(List<TRMTRAINRESMENT> list) ;
    TRMTRAINRESMENT getDraft(TRMTRAINRESMENT et) ;
    boolean save(TRMTRAINRESMENT et) ;
    void saveBatch(List<TRMTRAINRESMENT> list) ;
    boolean checkKey(TRMTRAINRESMENT et) ;
    boolean create(TRMTRAINRESMENT et) ;
    void createBatch(List<TRMTRAINRESMENT> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMTRAINRESMENT get(String key) ;
    Page<TRMTRAINRESMENT> searchDefault(TRMTRAINRESMENTSearchContext context) ;
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


