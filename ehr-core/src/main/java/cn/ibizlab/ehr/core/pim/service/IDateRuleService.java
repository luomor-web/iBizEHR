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

import cn.ibizlab.ehr.core.pim.domain.DateRule;
import cn.ibizlab.ehr.core.pim.filter.DateRuleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DateRule] 服务对象接口
 */
public interface IDateRuleService extends IService<DateRule>{

    DateRule getDraft(DateRule et) ;
    boolean update(DateRule et) ;
    void updateBatch(List<DateRule> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(DateRule et) ;
    void createBatch(List<DateRule> list) ;
    boolean checkKey(DateRule et) ;
    boolean save(DateRule et) ;
    void saveBatch(List<DateRule> list) ;
    DateRule get(String key) ;
    Page<DateRule> searchDefault(DateRuleSearchContext context) ;
    List<DateRule> selectByOrmorgid(String orgid) ;
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

    List<DateRule> getDateruleByIds(List<String> ids) ;
    List<DateRule> getDateruleByEntities(List<DateRule> entities) ;

}


