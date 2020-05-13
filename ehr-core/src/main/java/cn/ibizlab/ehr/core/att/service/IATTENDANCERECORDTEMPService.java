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

import cn.ibizlab.ehr.core.att.domain.ATTENDANCERECORDTEMP;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCERECORDTEMPSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDANCERECORDTEMP] 服务对象接口
 */
public interface IATTENDANCERECORDTEMPService extends IService<ATTENDANCERECORDTEMP>{

    boolean update(ATTENDANCERECORDTEMP et) ;
    void updateBatch(List<ATTENDANCERECORDTEMP> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ATTENDANCERECORDTEMP et) ;
    void saveBatch(List<ATTENDANCERECORDTEMP> list) ;
    ATTENDANCERECORDTEMP getDraft(ATTENDANCERECORDTEMP et) ;
    ATTENDANCERECORDTEMP get(String key) ;
    boolean create(ATTENDANCERECORDTEMP et) ;
    void createBatch(List<ATTENDANCERECORDTEMP> list) ;
    boolean checkKey(ATTENDANCERECORDTEMP et) ;
    Page<ATTENDANCERECORDTEMP> searchDefault(ATTENDANCERECORDTEMPSearchContext context) ;
    List<ATTENDANCERECORDTEMP> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<ATTENDANCERECORDTEMP> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<ATTENDANCERECORDTEMP> selectByPimpersonid(String pimpersonid) ;
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


