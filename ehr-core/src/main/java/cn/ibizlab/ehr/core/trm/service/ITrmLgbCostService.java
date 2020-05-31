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

import cn.ibizlab.ehr.core.trm.domain.TrmLgbCost;
import cn.ibizlab.ehr.core.trm.filter.TrmLgbCostSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmLgbCost] 服务对象接口
 */
public interface ITrmLgbCostService extends IService<TrmLgbCost>{

    TrmLgbCost get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmLgbCost getDraft(TrmLgbCost et) ;
    boolean checkKey(TrmLgbCost et) ;
    boolean update(TrmLgbCost et) ;
    void updateBatch(List<TrmLgbCost> list) ;
    boolean create(TrmLgbCost et) ;
    void createBatch(List<TrmLgbCost> list) ;
    boolean save(TrmLgbCost et) ;
    void saveBatch(List<TrmLgbCost> list) ;
    Page<TrmLgbCost> searchDefault(TrmLgbCostSearchContext context) ;
    List<TrmLgbCost> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<TrmLgbCost> getTrmlgbcostByIds(List<String> ids) ;
    List<TrmLgbCost> getTrmlgbcostByEntities(List<TrmLgbCost> entities) ;

}


