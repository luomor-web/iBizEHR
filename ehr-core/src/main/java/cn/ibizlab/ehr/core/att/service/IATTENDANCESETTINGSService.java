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

import cn.ibizlab.ehr.core.att.domain.ATTENDANCESETTINGS;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCESETTINGSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDANCESETTINGS] 服务对象接口
 */
public interface IATTENDANCESETTINGSService extends IService<ATTENDANCESETTINGS>{

    ATTENDANCESETTINGS addToKqz(ATTENDANCESETTINGS et) ;
    boolean update(ATTENDANCESETTINGS et) ;
    void updateBatch(List<ATTENDANCESETTINGS> list) ;
    boolean create(ATTENDANCESETTINGS et) ;
    void createBatch(List<ATTENDANCESETTINGS> list) ;
    boolean save(ATTENDANCESETTINGS et) ;
    void saveBatch(List<ATTENDANCESETTINGS> list) ;
    ATTENDANCESETTINGS get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ATTENDANCESETTINGS et) ;
    ATTENDANCESETTINGS getDraft(ATTENDANCESETTINGS et) ;
    Page<ATTENDANCESETTINGS> searchYGSZKQ(ATTENDANCESETTINGSSearchContext context) ;
    Page<ATTENDANCESETTINGS> searchFYGZZKQ(ATTENDANCESETTINGSSearchContext context) ;
    Page<ATTENDANCESETTINGS> searchDefault(ATTENDANCESETTINGSSearchContext context) ;
    List<ATTENDANCESETTINGS> selectByAttendencesetupid(String attendencesetupid) ;
    void removeByAttendencesetupid(String attendencesetupid) ;
    List<ATTENDANCESETTINGS> selectByPimpersonid(String pimpersonid) ;
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

