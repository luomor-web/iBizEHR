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

import cn.ibizlab.ehr.core.pim.domain.PimDateRule;
import cn.ibizlab.ehr.core.pim.filter.PimDateRuleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimDateRule] 服务对象接口
 */
public interface IPimDateRuleService extends IService<PimDateRule>{

    PimDateRule getDraft(PimDateRule et) ;
    boolean update(PimDateRule et) ;
    void updateBatch(List<PimDateRule> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimDateRule et) ;
    void createBatch(List<PimDateRule> list) ;
    boolean checkKey(PimDateRule et) ;
    boolean save(PimDateRule et) ;
    void saveBatch(List<PimDateRule> list) ;
    PimDateRule get(String key) ;
    Page<PimDateRule> searchDefault(PimDateRuleSearchContext context) ;
    List<PimDateRule> selectByOrmorgid(String orgid) ;
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

    List<PimDateRule> getPimdateruleByIds(List<String> ids) ;
    List<PimDateRule> getPimdateruleByEntities(List<PimDateRule> entities) ;

}


