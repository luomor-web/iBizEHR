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

import cn.ibizlab.ehr.core.att.domain.ATTENDENCEORMORGSECTOR;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCEORMORGSECTORSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDENCEORMORGSECTOR] 服务对象接口
 */
public interface IATTENDENCEORMORGSECTORService extends IService<ATTENDENCEORMORGSECTOR>{

    ATTENDENCEORMORGSECTOR get(String key) ;
    boolean create(ATTENDENCEORMORGSECTOR et) ;
    void createBatch(List<ATTENDENCEORMORGSECTOR> list) ;
    boolean update(ATTENDENCEORMORGSECTOR et) ;
    void updateBatch(List<ATTENDENCEORMORGSECTOR> list) ;
    boolean checkKey(ATTENDENCEORMORGSECTOR et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ATTENDENCEORMORGSECTOR getDraft(ATTENDENCEORMORGSECTOR et) ;
    boolean save(ATTENDENCEORMORGSECTOR et) ;
    void saveBatch(List<ATTENDENCEORMORGSECTOR> list) ;
    Page<ATTENDENCEORMORGSECTOR> searchDefault(ATTENDENCEORMORGSECTORSearchContext context) ;
    List<ATTENDENCEORMORGSECTOR> selectByAttendencesetupid(String attendencesetupid) ;
    void removeByAttendencesetupid(String attendencesetupid) ;
    List<ATTENDENCEORMORGSECTOR> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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


