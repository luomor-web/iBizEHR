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

import cn.ibizlab.ehr.core.att.domain.ATTENDENCESETUP;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCESETUPSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDENCESETUP] 服务对象接口
 */
public interface IATTENDENCESETUPService extends IService<ATTENDENCESETUP>{

    boolean update(ATTENDENCESETUP et) ;
    void updateBatch(List<ATTENDENCESETUP> list) ;
    boolean save(ATTENDENCESETUP et) ;
    void saveBatch(List<ATTENDENCESETUP> list) ;
    ATTENDENCESETUP reflushUpdatedate(ATTENDENCESETUP et) ;
    ATTENDENCESETUP get(String key) ;
    ATTENDENCESETUP getDraft(ATTENDENCESETUP et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ATTENDENCESETUP et) ;
    void createBatch(List<ATTENDENCESETUP> list) ;
    boolean checkKey(ATTENDENCESETUP et) ;
    Page<ATTENDENCESETUP> searchDefault(ATTENDENCESETUPSearchContext context) ;
    Page<ATTENDENCESETUP> searchCurOrgKQSZ(ATTENDENCESETUPSearchContext context) ;
    Page<ATTENDENCESETUP> searchKQYBXKQB(ATTENDENCESETUPSearchContext context) ;
    Page<ATTENDENCESETUP> searchKQYCZKQSZ(ATTENDENCESETUPSearchContext context) ;
    List<ATTENDENCESETUP> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<ATTENDENCESETUP> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<ATTENDENCESETUP> selectByVacholidayrulesid(String vacholidayrulesid) ;
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

}


