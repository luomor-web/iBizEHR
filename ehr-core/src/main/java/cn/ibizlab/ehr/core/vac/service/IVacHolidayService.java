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

import cn.ibizlab.ehr.core.vac.domain.VacHoliday;
import cn.ibizlab.ehr.core.vac.filter.VacHolidaySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacHoliday] 服务对象接口
 */
public interface IVacHolidayService extends IService<VacHoliday>{

    VacHoliday aPPOINTJZBJJR(VacHoliday et) ;
    boolean update(VacHoliday et) ;
    void updateBatch(List<VacHoliday> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(VacHoliday et) ;
    VacHoliday getDraft(VacHoliday et) ;
    VacHoliday get(String key) ;
    boolean save(VacHoliday et) ;
    void saveBatch(List<VacHoliday> list) ;
    boolean create(VacHoliday et) ;
    void createBatch(List<VacHoliday> list) ;
    Page<VacHoliday> searchDefault(VacHolidaySearchContext context) ;
    List<VacHoliday> selectByVacholidayrulesid(String vacholidayrulesid) ;
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

    List<VacHoliday> getVacholidayByIds(List<String> ids) ;
    List<VacHoliday> getVacholidayByEntities(List<VacHoliday> entities) ;

}


