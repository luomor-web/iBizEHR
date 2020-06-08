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

import cn.ibizlab.ehr.core.att.domain.AttEndanceRecord;
import cn.ibizlab.ehr.core.att.filter.AttEndanceRecordSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndanceRecord] 服务对象接口
 */
public interface IAttEndanceRecordService extends IService<AttEndanceRecord>{

    AttEndanceRecord getDraft(AttEndanceRecord et) ;
    boolean create(AttEndanceRecord et) ;
    void createBatch(List<AttEndanceRecord> list) ;
    boolean update(AttEndanceRecord et) ;
    void updateBatch(List<AttEndanceRecord> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(AttEndanceRecord et) ;
    void saveBatch(List<AttEndanceRecord> list) ;
    AttEndanceRecord get(String key) ;
    AttEndanceRecord reflushPersonInfo(AttEndanceRecord et) ;
    boolean checkKey(AttEndanceRecord et) ;
    Page<AttEndanceRecord> searchDefault(AttEndanceRecordSearchContext context) ;
    List<AttEndanceRecord> selectByAttendancemreportid(String attendancemreportmxid) ;
    void removeByAttendancemreportid(String attendancemreportmxid) ;
    List<AttEndanceRecord> selectByOrmbmkqdzid(String ormbmkqdzid) ;
    void removeByOrmbmkqdzid(String ormbmkqdzid) ;
    List<AttEndanceRecord> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<AttEndanceRecord> selectByTrmtrainplantermid(String trmtrainplantermid) ;
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

    List<AttEndanceRecord> getAttendancerecordByIds(List<String> ids) ;
    List<AttEndanceRecord> getAttendancerecordByEntities(List<AttEndanceRecord> entities) ;

}


