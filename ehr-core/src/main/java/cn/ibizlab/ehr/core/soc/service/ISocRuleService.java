package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SocRule;
import cn.ibizlab.ehr.core.soc.filter.SocRuleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocRule] 服务对象接口
 */
public interface ISocRuleService extends IService<SocRule>{

    SocRule get(String key) ;
    SocRule getDraft(SocRule et) ;
    boolean create(SocRule et) ;
    void createBatch(List<SocRule> list) ;
    boolean update(SocRule et) ;
    void updateBatch(List<SocRule> list) ;
    boolean save(SocRule et) ;
    void saveBatch(List<SocRule> list) ;
    boolean checkKey(SocRule et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<SocRule> searchDefault(SocRuleSearchContext context) ;
    List<SocRule> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SocRule> selectBySocareaid(String socareaid) ;
    void removeBySocareaid(String socareaid) ;
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

    List<SocRule> getSocruleByIds(List<String> ids) ;
    List<SocRule> getSocruleByEntities(List<SocRule> entities) ;

}


