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

import cn.ibizlab.ehr.core.trm.domain.TrmLgbDetail;
import cn.ibizlab.ehr.core.trm.filter.TrmLgbDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmLgbDetail] 服务对象接口
 */
public interface ITrmLgbDetailService extends IService<TrmLgbDetail>{

    boolean update(TrmLgbDetail et) ;
    void updateBatch(List<TrmLgbDetail> list) ;
    TrmLgbDetail get(String key) ;
    boolean save(TrmLgbDetail et) ;
    void saveBatch(List<TrmLgbDetail> list) ;
    boolean checkKey(TrmLgbDetail et) ;
    TrmLgbDetail getDraft(TrmLgbDetail et) ;
    boolean create(TrmLgbDetail et) ;
    void createBatch(List<TrmLgbDetail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TrmLgbDetail> searchDefault(TrmLgbDetailSearchContext context) ;
    List<TrmLgbDetail> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmLgbDetail> selectByTrmlgbcostid(String trmlgbcostid) ;
    void removeByTrmlgbcostid(String trmlgbcostid) ;
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

    List<TrmLgbDetail> getTrmlgbdetailByIds(List<String> ids) ;
    List<TrmLgbDetail> getTrmlgbdetailByEntities(List<TrmLgbDetail> entities) ;

}


