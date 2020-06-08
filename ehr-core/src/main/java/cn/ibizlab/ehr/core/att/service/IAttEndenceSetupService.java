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

import cn.ibizlab.ehr.core.att.domain.AttEndenceSetup;
import cn.ibizlab.ehr.core.att.filter.AttEndenceSetupSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndenceSetup] 服务对象接口
 */
public interface IAttEndenceSetupService extends IService<AttEndenceSetup>{

    boolean update(AttEndenceSetup et) ;
    void updateBatch(List<AttEndenceSetup> list) ;
    boolean save(AttEndenceSetup et) ;
    void saveBatch(List<AttEndenceSetup> list) ;
    AttEndenceSetup reflushUpdatedate(AttEndenceSetup et) ;
    AttEndenceSetup get(String key) ;
    AttEndenceSetup getDraft(AttEndenceSetup et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(AttEndenceSetup et) ;
    void createBatch(List<AttEndenceSetup> list) ;
    boolean checkKey(AttEndenceSetup et) ;
    Page<AttEndenceSetup> searchDefault(AttEndenceSetupSearchContext context) ;
    Page<AttEndenceSetup> searchCurOrgKQSZ(AttEndenceSetupSearchContext context) ;
    Page<AttEndenceSetup> searchKQYBXKQB(AttEndenceSetupSearchContext context) ;
    Page<AttEndenceSetup> searchKQYCZKQSZ(AttEndenceSetupSearchContext context) ;
    List<AttEndenceSetup> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<AttEndenceSetup> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<AttEndenceSetup> selectByVacholidayrulesid(String vacholidayrulesid) ;
    void removeByVacholidayrulesid(String vacholidayrulesid) ;
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

    List<AttEndenceSetup> getAttendencesetupByIds(List<String> ids) ;
    List<AttEndenceSetup> getAttendencesetupByEntities(List<AttEndenceSetup> entities) ;

}


