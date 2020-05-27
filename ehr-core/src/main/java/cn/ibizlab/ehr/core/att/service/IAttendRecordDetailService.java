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

import cn.ibizlab.ehr.core.att.domain.AttendRecordDetail;
import cn.ibizlab.ehr.core.att.filter.AttendRecordDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttendRecordDetail] 服务对象接口
 */
public interface IAttendRecordDetailService extends IService<AttendRecordDetail>{

    boolean create(AttendRecordDetail et) ;
    void createBatch(List<AttendRecordDetail> list) ;
    AttendRecordDetail getDraft(AttendRecordDetail et) ;
    AttendRecordDetail get(String key) ;
    boolean checkKey(AttendRecordDetail et) ;
    boolean save(AttendRecordDetail et) ;
    void saveBatch(List<AttendRecordDetail> list) ;
    boolean update(AttendRecordDetail et) ;
    void updateBatch(List<AttendRecordDetail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<AttendRecordDetail> searchDefault(AttendRecordDetailSearchContext context) ;
    List<AttendRecordDetail> selectByAttendancerecordid(String attendancerecordid) ;
    void removeByAttendancerecordid(String attendancerecordid) ;
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

    List<AttendRecordDetail> getAttendrecorddetailByIds(List<String> ids) ;
    List<AttendRecordDetail> getAttendrecorddetailByEntities(List<AttendRecordDetail> entities) ;

}


