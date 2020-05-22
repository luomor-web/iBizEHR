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

import cn.ibizlab.ehr.core.pim.domain.PIMPersonAbilityDetail;
import cn.ibizlab.ehr.core.pim.filter.PIMPersonAbilityDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMPersonAbilityDetail] 服务对象接口
 */
public interface IPIMPersonAbilityDetailService extends IService<PIMPersonAbilityDetail>{

    boolean checkKey(PIMPersonAbilityDetail et) ;
    boolean create(PIMPersonAbilityDetail et) ;
    void createBatch(List<PIMPersonAbilityDetail> list) ;
    boolean save(PIMPersonAbilityDetail et) ;
    void saveBatch(List<PIMPersonAbilityDetail> list) ;
    boolean update(PIMPersonAbilityDetail et) ;
    void updateBatch(List<PIMPersonAbilityDetail> list) ;
    PIMPersonAbilityDetail get(String key) ;
    PIMPersonAbilityDetail getDraft(PIMPersonAbilityDetail et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PIMPersonAbilityDetail> searchDefault(PIMPersonAbilityDetailSearchContext context) ;
    List<PIMPersonAbilityDetail> selectByPimpersonabilityid(String pimpersonabilityid) ;
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

}


