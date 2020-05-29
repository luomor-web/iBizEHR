package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SalPlan;
import cn.ibizlab.ehr.core.sal.filter.SalPlanSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalPlan] 服务对象接口
 */
public interface ISalPlanService extends IService<SalPlan>{

    boolean create(SalPlan et) ;
    void createBatch(List<SalPlan> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SalPlan et) ;
    boolean save(SalPlan et) ;
    void saveBatch(List<SalPlan> list) ;
    SalPlan getDraft(SalPlan et) ;
    boolean update(SalPlan et) ;
    void updateBatch(List<SalPlan> list) ;
    SalPlan get(String key) ;
    Page<SalPlan> searchDefault(SalPlanSearchContext context) ;
    List<SalPlan> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SalPlan> selectBySalschemeid(String salschemeid) ;
    void removeBySalschemeid(String salschemeid) ;
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

    List<SalPlan> getSalplanByIds(List<String> ids) ;
    List<SalPlan> getSalplanByEntities(List<SalPlan> entities) ;

}


