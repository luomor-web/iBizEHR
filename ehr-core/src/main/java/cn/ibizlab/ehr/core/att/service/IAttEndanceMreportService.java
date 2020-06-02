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

import cn.ibizlab.ehr.core.att.domain.AttEndanceMreport;
import cn.ibizlab.ehr.core.att.filter.AttEndanceMreportSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndanceMreport] 服务对象接口
 */
public interface IAttEndanceMreportService extends IService<AttEndanceMreport>{

    AttEndanceMreport getAttendencemanOfKQSZ(AttEndanceMreport et) ;
    boolean save(AttEndanceMreport et) ;
    void saveBatch(List<AttEndanceMreport> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    AttEndanceMreport exportKQYB(AttEndanceMreport et) ;
    boolean create(AttEndanceMreport et) ;
    void createBatch(List<AttEndanceMreport> list) ;
    AttEndanceMreport sCKQYB(AttEndanceMreport et) ;
    AttEndanceMreport get(String key) ;
    boolean checkKey(AttEndanceMreport et) ;
    AttEndanceMreport qR(AttEndanceMreport et) ;
    boolean update(AttEndanceMreport et) ;
    void updateBatch(List<AttEndanceMreport> list) ;
    AttEndanceMreport getDraft(AttEndanceMreport et) ;
    AttEndanceMreport printKQYB(AttEndanceMreport et) ;
    Page<AttEndanceMreport> searchKQYBDY(AttEndanceMreportSearchContext context) ;
    Page<AttEndanceMreport> searchDefault(AttEndanceMreportSearchContext context) ;
    Page<AttEndanceMreport> searchKQYCZKQYB(AttEndanceMreportSearchContext context) ;
    Page<AttEndanceMreport> searchCurORMORGKQYB(AttEndanceMreportSearchContext context) ;
    Page<AttEndanceMreport> searchCurORMORGSECTORKQYB(AttEndanceMreportSearchContext context) ;
    List<AttEndanceMreport> selectByAttendencesetupid(String attendencesetupid) ;
    void removeByAttendencesetupid(String attendencesetupid) ;
    List<AttEndanceMreport> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<AttEndanceMreport> getAttendancemreportByIds(List<String> ids) ;
    List<AttEndanceMreport> getAttendancemreportByEntities(List<AttEndanceMreport> entities) ;

}


