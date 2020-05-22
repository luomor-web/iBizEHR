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

import cn.ibizlab.ehr.core.att.domain.ATTENDANCERECORD;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCERECORDSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDANCERECORD] 服务对象接口
 */
public interface IATTENDANCERECORDService extends IService<ATTENDANCERECORD>{

    ATTENDANCERECORD getDraft(ATTENDANCERECORD et) ;
    boolean create(ATTENDANCERECORD et) ;
    void createBatch(List<ATTENDANCERECORD> list) ;
    boolean update(ATTENDANCERECORD et) ;
    void updateBatch(List<ATTENDANCERECORD> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ATTENDANCERECORD et) ;
    void saveBatch(List<ATTENDANCERECORD> list) ;
    ATTENDANCERECORD get(String key) ;
    ATTENDANCERECORD reflushPersonInfo(ATTENDANCERECORD et) ;
    boolean checkKey(ATTENDANCERECORD et) ;
    Page<ATTENDANCERECORD> searchDefault(ATTENDANCERECORDSearchContext context) ;
    List<ATTENDANCERECORD> selectByAttendancemreportid(String attendancemreportmxid) ;
    void removeByAttendancemreportid(String attendancemreportmxid) ;
    List<ATTENDANCERECORD> selectByOrmbmkqdzid(String ormbmkqdzid) ;
    void removeByOrmbmkqdzid(String ormbmkqdzid) ;
    List<ATTENDANCERECORD> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<ATTENDANCERECORD> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
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


