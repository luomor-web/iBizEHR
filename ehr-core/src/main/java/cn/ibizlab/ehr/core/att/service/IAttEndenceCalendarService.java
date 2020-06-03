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

import cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar;
import cn.ibizlab.ehr.core.att.filter.AttEndenceCalendarSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndenceCalendar] 服务对象接口
 */
public interface IAttEndenceCalendarService extends IService<AttEndenceCalendar>{

    boolean create(AttEndenceCalendar et) ;
    void createBatch(List<AttEndenceCalendar> list) ;
    boolean save(AttEndenceCalendar et) ;
    void saveBatch(List<AttEndenceCalendar> list) ;
    boolean update(AttEndenceCalendar et) ;
    void updateBatch(List<AttEndenceCalendar> list) ;
    boolean checkKey(AttEndenceCalendar et) ;
    AttEndenceCalendar get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    AttEndenceCalendar getDraft(AttEndenceCalendar et) ;
    Page<AttEndenceCalendar> searchDefault(AttEndenceCalendarSearchContext context) ;
    List<AttEndenceCalendar> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<AttEndenceCalendar> selectByVacholidayid(String vacholidayid) ;
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

    List<AttEndenceCalendar> getAttendencecalendarByIds(List<String> ids) ;
    List<AttEndenceCalendar> getAttendencecalendarByEntities(List<AttEndenceCalendar> entities) ;

}


