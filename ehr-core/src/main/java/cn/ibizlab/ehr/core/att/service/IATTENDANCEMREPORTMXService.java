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

import cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORTMX;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCEMREPORTMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDANCEMREPORTMX] 服务对象接口
 */
public interface IATTENDANCEMREPORTMXService extends IService<ATTENDANCEMREPORTMX>{

    ATTENDANCEMREPORTMX getDraft(ATTENDANCEMREPORTMX et) ;
    boolean update(ATTENDANCEMREPORTMX et) ;
    void updateBatch(List<ATTENDANCEMREPORTMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ATTENDANCEMREPORTMX et) ;
    ATTENDANCEMREPORTMX get(String key) ;
    boolean save(ATTENDANCEMREPORTMX et) ;
    void saveBatch(List<ATTENDANCEMREPORTMX> list) ;
    boolean create(ATTENDANCEMREPORTMX et) ;
    void createBatch(List<ATTENDANCEMREPORTMX> list) ;
    ATTENDANCEMREPORTMX export2Excel(ATTENDANCEMREPORTMX et) ;
    Page<ATTENDANCEMREPORTMX> searchDefault(ATTENDANCEMREPORTMXSearchContext context) ;
    Page<ATTENDANCEMREPORTMX> searchKQYBMXDY(ATTENDANCEMREPORTMXSearchContext context) ;
    Page<ATTENDANCEMREPORTMX> searchCurPerson(ATTENDANCEMREPORTMXSearchContext context) ;
    List<ATTENDANCEMREPORTMX> selectByAttendancemreportid2(String attendancemreportid) ;
    void removeByAttendancemreportid2(String attendancemreportid) ;
    List<ATTENDANCEMREPORTMX> selectByPimpersonid(String pimpersonid) ;
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


