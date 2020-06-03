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

import cn.ibizlab.ehr.core.pim.domain.PimLanguageAbility;
import cn.ibizlab.ehr.core.pim.filter.PimLanguageAbilitySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimLanguageAbility] 服务对象接口
 */
public interface IPimLanguageAbilityService extends IService<PimLanguageAbility>{

    PimLanguageAbility getDraft(PimLanguageAbility et) ;
    PimLanguageAbility get(String key) ;
    PimLanguageAbility custRemove(PimLanguageAbility et) ;
    boolean save(PimLanguageAbility et) ;
    void saveBatch(List<PimLanguageAbility> list) ;
    boolean checkKey(PimLanguageAbility et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PimLanguageAbility et) ;
    void updateBatch(List<PimLanguageAbility> list) ;
    boolean create(PimLanguageAbility et) ;
    void createBatch(List<PimLanguageAbility> list) ;
    Page<PimLanguageAbility> searchJLSSGR(PimLanguageAbilitySearchContext context) ;
    Page<PimLanguageAbility> searchDefault(PimLanguageAbilitySearchContext context) ;
    Page<PimLanguageAbility> searchJLSS(PimLanguageAbilitySearchContext context) ;
    Page<PimLanguageAbility> searchZIZHU(PimLanguageAbilitySearchContext context) ;
    Page<PimLanguageAbility> searchJLSSGLY(PimLanguageAbilitySearchContext context) ;
    List<PimLanguageAbility> selectByPimpersonid(String pimpersonid) ;
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

    List<PimLanguageAbility> getPimlanguageabilityByIds(List<String> ids) ;
    List<PimLanguageAbility> getPimlanguageabilityByEntities(List<PimLanguageAbility> entities) ;

}


