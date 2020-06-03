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

import cn.ibizlab.ehr.core.trm.domain.TrmDepartNeeds;
import cn.ibizlab.ehr.core.trm.filter.TrmDepartNeedsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmDepartNeeds] 服务对象接口
 */
public interface ITrmDepartNeedsService extends IService<TrmDepartNeeds>{

    boolean update(TrmDepartNeeds et) ;
    void updateBatch(List<TrmDepartNeeds> list) ;
    TrmDepartNeeds get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TrmDepartNeeds et) ;
    void saveBatch(List<TrmDepartNeeds> list) ;
    TrmDepartNeeds getDraft(TrmDepartNeeds et) ;
    boolean checkKey(TrmDepartNeeds et) ;
    boolean create(TrmDepartNeeds et) ;
    void createBatch(List<TrmDepartNeeds> list) ;
    Page<TrmDepartNeeds> searchDefault(TrmDepartNeedsSearchContext context) ;
    List<TrmDepartNeeds> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
    List<TrmDepartNeeds> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
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

    List<TrmDepartNeeds> getTrmdepartneedsByIds(List<String> ids) ;
    List<TrmDepartNeeds> getTrmdepartneedsByEntities(List<TrmDepartNeeds> entities) ;

}


