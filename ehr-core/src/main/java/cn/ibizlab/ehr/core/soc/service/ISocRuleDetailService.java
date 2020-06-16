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

import cn.ibizlab.ehr.core.soc.domain.SocRuleDetail;
import cn.ibizlab.ehr.core.soc.filter.SocRuleDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocRuleDetail] 服务对象接口
 */
public interface ISocRuleDetailService extends IService<SocRuleDetail>{

    SocRuleDetail getDraft(SocRuleDetail et) ;
    boolean update(SocRuleDetail et) ;
    void updateBatch(List<SocRuleDetail> list) ;
    SocRuleDetail get(String key) ;
    boolean create(SocRuleDetail et) ;
    void createBatch(List<SocRuleDetail> list) ;
    boolean save(SocRuleDetail et) ;
    void saveBatch(List<SocRuleDetail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SocRuleDetail et) ;
    Page<SocRuleDetail> searchDefault(SocRuleDetailSearchContext context) ;
    List<SocRuleDetail> selectBySocruleid(String socruleid) ;
    void removeBySocruleid(String socruleid) ;
    List<SocRuleDetail> selectBySoctypeid(String soctypeid) ;
    void removeBySoctypeid(String soctypeid) ;
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

    List<SocRuleDetail> getSocruledetailByIds(List<String> ids) ;
    List<SocRuleDetail> getSocruledetailByEntities(List<SocRuleDetail> entities) ;

}


