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

import cn.ibizlab.ehr.core.pim.domain.PimPersonAbilityDetail;
import cn.ibizlab.ehr.core.pim.filter.PimPersonAbilityDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimPersonAbilityDetail] 服务对象接口
 */
public interface IPimPersonAbilityDetailService extends IService<PimPersonAbilityDetail>{

    boolean checkKey(PimPersonAbilityDetail et) ;
    boolean create(PimPersonAbilityDetail et) ;
    void createBatch(List<PimPersonAbilityDetail> list) ;
    boolean save(PimPersonAbilityDetail et) ;
    void saveBatch(List<PimPersonAbilityDetail> list) ;
    boolean update(PimPersonAbilityDetail et) ;
    void updateBatch(List<PimPersonAbilityDetail> list) ;
    PimPersonAbilityDetail get(String key) ;
    PimPersonAbilityDetail getDraft(PimPersonAbilityDetail et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimPersonAbilityDetail> searchDefault(PimPersonAbilityDetailSearchContext context) ;
    List<PimPersonAbilityDetail> selectByPimpersonabilityid(String pimpersonabilityid) ;
    void removeByPimpersonabilityid(String pimpersonabilityid) ;
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

    List<PimPersonAbilityDetail> getPimpersonabilitydetailByIds(List<String> ids) ;
    List<PimPersonAbilityDetail> getPimpersonabilitydetailByEntities(List<PimPersonAbilityDetail> entities) ;

}


