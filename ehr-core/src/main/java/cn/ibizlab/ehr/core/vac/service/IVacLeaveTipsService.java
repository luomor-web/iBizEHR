package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VacLeaveTips;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveTipsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacLeaveTips] 服务对象接口
 */
public interface IVacLeaveTipsService extends IService<VacLeaveTips>{

    VacLeaveTips checkQJZL(VacLeaveTips et) ;
    boolean create(VacLeaveTips et) ;
    void createBatch(List<VacLeaveTips> list) ;
    VacLeaveTips getDraft(VacLeaveTips et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(VacLeaveTips et) ;
    VacLeaveTips checkRepeat(VacLeaveTips et) ;
    VacLeaveTips get(String key) ;
    boolean update(VacLeaveTips et) ;
    void updateBatch(List<VacLeaveTips> list) ;
    boolean save(VacLeaveTips et) ;
    void saveBatch(List<VacLeaveTips> list) ;
    Page<VacLeaveTips> searchDefault(VacLeaveTipsSearchContext context) ;
    List<VacLeaveTips> selectByVacholidayrulesid(String vacholidayrulesid) ;
    void removeByVacholidayrulesid(String vacholidayrulesid) ;
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

    List<VacLeaveTips> getVacleavetipsByIds(List<String> ids) ;
    List<VacLeaveTips> getVacleavetipsByEntities(List<VacLeaveTips> entities) ;

}


