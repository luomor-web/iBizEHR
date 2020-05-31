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

import cn.ibizlab.ehr.core.sal.domain.SalRule;
import cn.ibizlab.ehr.core.sal.filter.SalRuleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalRule] 服务对象接口
 */
public interface ISalRuleService extends IService<SalRule>{

    SalRule getDraft(SalRule et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalRule get(String key) ;
    boolean create(SalRule et) ;
    void createBatch(List<SalRule> list) ;
    boolean update(SalRule et) ;
    void updateBatch(List<SalRule> list) ;
    boolean save(SalRule et) ;
    void saveBatch(List<SalRule> list) ;
    boolean checkKey(SalRule et) ;
    Page<SalRule> searchDefault(SalRuleSearchContext context) ;
    List<SalRule> selectBySalparamid(String salparamid) ;
    void removeBySalparamid(String salparamid) ;
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

    List<SalRule> getSalruleByIds(List<String> ids) ;
    List<SalRule> getSalruleByEntities(List<SalRule> entities) ;

}


