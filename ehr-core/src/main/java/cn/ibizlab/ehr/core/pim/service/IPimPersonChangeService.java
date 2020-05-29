package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PimPersonChange;
import cn.ibizlab.ehr.core.pim.filter.PimPersonChangeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimPersonChange] 服务对象接口
 */
public interface IPimPersonChangeService extends IService<PimPersonChange>{

    boolean save(PimPersonChange et) ;
    void saveBatch(List<PimPersonChange> list) ;
    PimPersonChange bH(PimPersonChange et) ;
    PimPersonChange ensure(PimPersonChange et) ;
    boolean update(PimPersonChange et) ;
    void updateBatch(List<PimPersonChange> list) ;
    PimPersonChange get(String key) ;
    boolean create(PimPersonChange et) ;
    void createBatch(List<PimPersonChange> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimPersonChange qR(PimPersonChange et) ;
    boolean checkKey(PimPersonChange et) ;
    PimPersonChange getDraft(PimPersonChange et) ;
    Page<PimPersonChange> searchHistoryRec(PimPersonChangeSearchContext context) ;
    Page<PimPersonChange> searchPIMCL_NOTAPPROVAL(PimPersonChangeSearchContext context) ;
    Page<PimPersonChange> searchHeadRed(PimPersonChangeSearchContext context) ;
    Page<PimPersonChange> searchDefault(PimPersonChangeSearchContext context) ;
    List<PimPersonChange> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<PimPersonChange> getPimpersonchangeByIds(List<String> ids) ;
    List<PimPersonChange> getPimpersonchangeByEntities(List<PimPersonChange> entities) ;

}


