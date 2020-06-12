package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParIntegralRule;
import cn.ibizlab.ehr.core.par.filter.ParIntegralRuleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParIntegralRule] 服务对象接口
 */
public interface IParIntegralRuleService extends IService<ParIntegralRule>{

    boolean checkKey(ParIntegralRule et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ParIntegralRule et) ;
    void updateBatch(List<ParIntegralRule> list) ;
    ParIntegralRule get(String key) ;
    ParIntegralRule getDraft(ParIntegralRule et) ;
    boolean create(ParIntegralRule et) ;
    void createBatch(List<ParIntegralRule> list) ;
    boolean save(ParIntegralRule et) ;
    void saveBatch(List<ParIntegralRule> list) ;
    Page<ParIntegralRule> searchDefault(ParIntegralRuleSearchContext context) ;
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

    List<ParIntegralRule> getParintegralruleByIds(List<String> ids) ;
    List<ParIntegralRule> getParintegralruleByEntities(List<ParIntegralRule> entities) ;

}


