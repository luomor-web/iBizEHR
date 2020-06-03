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

import cn.ibizlab.ehr.core.att.domain.AttEndanceSettings;
import cn.ibizlab.ehr.core.att.filter.AttEndanceSettingsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndanceSettings] 服务对象接口
 */
public interface IAttEndanceSettingsService extends IService<AttEndanceSettings>{

    AttEndanceSettings addToKqz(AttEndanceSettings et) ;
    boolean update(AttEndanceSettings et) ;
    void updateBatch(List<AttEndanceSettings> list) ;
    boolean create(AttEndanceSettings et) ;
    void createBatch(List<AttEndanceSettings> list) ;
    boolean save(AttEndanceSettings et) ;
    void saveBatch(List<AttEndanceSettings> list) ;
    AttEndanceSettings get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(AttEndanceSettings et) ;
    AttEndanceSettings getDraft(AttEndanceSettings et) ;
    Page<AttEndanceSettings> searchYGSZKQ(AttEndanceSettingsSearchContext context) ;
    Page<AttEndanceSettings> searchFYGZZKQ(AttEndanceSettingsSearchContext context) ;
    Page<AttEndanceSettings> searchDefault(AttEndanceSettingsSearchContext context) ;
    List<AttEndanceSettings> selectByAttendencesetupid(String attendencesetupid) ;
    void removeByAttendencesetupid(String attendencesetupid) ;
    List<AttEndanceSettings> selectByPimpersonid(String pimpersonid) ;
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

    List<AttEndanceSettings> getAttendancesettingsByIds(List<String> ids) ;
    List<AttEndanceSettings> getAttendancesettingsByEntities(List<AttEndanceSettings> entities) ;

}


