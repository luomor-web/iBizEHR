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

import cn.ibizlab.ehr.core.sal.domain.SalRuleDetail;
import cn.ibizlab.ehr.core.sal.filter.SalRuleDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalRuleDetail] 服务对象接口
 */
public interface ISalRuleDetailService extends IService<SalRuleDetail>{

    SalRuleDetail get(String key) ;
    boolean checkKey(SalRuleDetail et) ;
    boolean update(SalRuleDetail et) ;
    void updateBatch(List<SalRuleDetail> list) ;
    boolean save(SalRuleDetail et) ;
    void saveBatch(List<SalRuleDetail> list) ;
    boolean create(SalRuleDetail et) ;
    void createBatch(List<SalRuleDetail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalRuleDetail getDraft(SalRuleDetail et) ;
    Page<SalRuleDetail> searchDefault(SalRuleDetailSearchContext context) ;
    List<SalRuleDetail> selectBySalparamid(String salparamid) ;
    void removeBySalparamid(String salparamid) ;
    List<SalRuleDetail> selectBySalparamid2(String salparamid) ;
    void removeBySalparamid2(String salparamid) ;
    List<SalRuleDetail> selectBySalruleid(String salruleid) ;
    void removeBySalruleid(String salruleid) ;
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

    List<SalRuleDetail> getSalruledetailByIds(List<String> ids) ;
    List<SalRuleDetail> getSalruledetailByEntities(List<SalRuleDetail> entities) ;

}


