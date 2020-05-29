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

import cn.ibizlab.ehr.core.pim.domain.PimPersonAbility;
import cn.ibizlab.ehr.core.pim.filter.PimPersonAbilitySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimPersonAbility] 服务对象接口
 */
public interface IPimPersonAbilityService extends IService<PimPersonAbility>{

    boolean update(PimPersonAbility et) ;
    void updateBatch(List<PimPersonAbility> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimPersonAbility get(String key) ;
    boolean save(PimPersonAbility et) ;
    void saveBatch(List<PimPersonAbility> list) ;
    PimPersonAbility getDraft(PimPersonAbility et) ;
    PimPersonAbility initData(PimPersonAbility et) ;
    boolean create(PimPersonAbility et) ;
    void createBatch(List<PimPersonAbility> list) ;
    boolean checkKey(PimPersonAbility et) ;
    Page<PimPersonAbility> searchDefault(PimPersonAbilitySearchContext context) ;
    List<PimPersonAbility> selectByPimpersonid(String pimpersonid) ;
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

    List<PimPersonAbility> getPimpersonabilityByIds(List<String> ids) ;
    List<PimPersonAbility> getPimpersonabilityByEntities(List<PimPersonAbility> entities) ;

}


