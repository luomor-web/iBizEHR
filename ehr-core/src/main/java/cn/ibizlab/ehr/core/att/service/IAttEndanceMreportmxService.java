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

import cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx;
import cn.ibizlab.ehr.core.att.filter.AttEndanceMreportmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndanceMreportmx] 服务对象接口
 */
public interface IAttEndanceMreportmxService extends IService<AttEndanceMreportmx>{

    AttEndanceMreportmx getDraft(AttEndanceMreportmx et) ;
    boolean update(AttEndanceMreportmx et) ;
    void updateBatch(List<AttEndanceMreportmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(AttEndanceMreportmx et) ;
    AttEndanceMreportmx get(String key) ;
    boolean save(AttEndanceMreportmx et) ;
    void saveBatch(List<AttEndanceMreportmx> list) ;
    boolean create(AttEndanceMreportmx et) ;
    void createBatch(List<AttEndanceMreportmx> list) ;
    AttEndanceMreportmx export2Excel(AttEndanceMreportmx et) ;
    Page<AttEndanceMreportmx> searchDefault(AttEndanceMreportmxSearchContext context) ;
    Page<AttEndanceMreportmx> searchKQYBMXDY(AttEndanceMreportmxSearchContext context) ;
    Page<AttEndanceMreportmx> searchCurPerson(AttEndanceMreportmxSearchContext context) ;
    List<AttEndanceMreportmx> selectByAttendancemreportid2(String attendancemreportid) ;
    void removeByAttendancemreportid2(String attendancemreportid) ;
    List<AttEndanceMreportmx> selectByPimpersonid(String pimpersonid) ;
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

    List<AttEndanceMreportmx> getAttendancemreportmxByIds(List<String> ids) ;
    List<AttEndanceMreportmx> getAttendancemreportmxByEntities(List<AttEndanceMreportmx> entities) ;

}


