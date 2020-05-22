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

import cn.ibizlab.ehr.core.pim.domain.PIMPersonAbility;
import cn.ibizlab.ehr.core.pim.filter.PIMPersonAbilitySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMPersonAbility] 服务对象接口
 */
public interface IPIMPersonAbilityService extends IService<PIMPersonAbility>{

    boolean update(PIMPersonAbility et) ;
    void updateBatch(List<PIMPersonAbility> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMPersonAbility get(String key) ;
    boolean save(PIMPersonAbility et) ;
    void saveBatch(List<PIMPersonAbility> list) ;
    PIMPersonAbility getDraft(PIMPersonAbility et) ;
    PIMPersonAbility initData(PIMPersonAbility et) ;
    boolean create(PIMPersonAbility et) ;
    void createBatch(List<PIMPersonAbility> list) ;
    boolean checkKey(PIMPersonAbility et) ;
    Page<PIMPersonAbility> searchDefault(PIMPersonAbilitySearchContext context) ;
    List<PIMPersonAbility> selectByPimpersonid(String pimpersonid) ;
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

}


