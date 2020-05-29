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

import cn.ibizlab.ehr.core.att.domain.ATTENDANCEDATE;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCEDATESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDANCEDATE] 服务对象接口
 */
public interface IATTENDANCEDATEService extends IService<ATTENDANCEDATE>{

    ATTENDANCEDATE get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ATTENDANCEDATE et) ;
    void createBatch(List<ATTENDANCEDATE> list) ;
    ATTENDANCEDATE getDraft(ATTENDANCEDATE et) ;
    boolean save(ATTENDANCEDATE et) ;
    void saveBatch(List<ATTENDANCEDATE> list) ;
    boolean update(ATTENDANCEDATE et) ;
    void updateBatch(List<ATTENDANCEDATE> list) ;
    boolean checkKey(ATTENDANCEDATE et) ;
    Page<ATTENDANCEDATE> searchDefault(ATTENDANCEDATESearchContext context) ;
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

    List<ATTENDANCEDATE> getAttendancedateByIds(List<String> ids) ;
    List<ATTENDANCEDATE> getAttendancedateByEntities(List<ATTENDANCEDATE> entities) ;

}


