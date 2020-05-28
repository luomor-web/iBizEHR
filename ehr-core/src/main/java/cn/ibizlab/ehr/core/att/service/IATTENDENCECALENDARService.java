package cn.ibizlab.ehr.core.att.service;

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

import cn.ibizlab.ehr.core.att.domain.ATTENDENCECALENDAR;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCECALENDARSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDENCECALENDAR] 服务对象接口
 */
public interface IATTENDENCECALENDARService extends IService<ATTENDENCECALENDAR>{

    boolean create(ATTENDENCECALENDAR et) ;
    void createBatch(List<ATTENDENCECALENDAR> list) ;
    boolean save(ATTENDENCECALENDAR et) ;
    void saveBatch(List<ATTENDENCECALENDAR> list) ;
    boolean update(ATTENDENCECALENDAR et) ;
    void updateBatch(List<ATTENDENCECALENDAR> list) ;
    boolean checkKey(ATTENDENCECALENDAR et) ;
    ATTENDENCECALENDAR get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ATTENDENCECALENDAR getDraft(ATTENDENCECALENDAR et) ;
    Page<ATTENDENCECALENDAR> searchDefault(ATTENDENCECALENDARSearchContext context) ;
    List<ATTENDENCECALENDAR> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<ATTENDENCECALENDAR> selectByVacholidayid(String vacholidayid) ;
    void removeByVacholidayid(String vacholidayid) ;
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

    List<ATTENDENCECALENDAR> getAttendencecalendarByIds(List<String> ids) ;
    List<ATTENDENCECALENDAR> getAttendencecalendarByEntities(List<ATTENDENCECALENDAR> entities) ;

}


