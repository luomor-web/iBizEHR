package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACHOLIDAY;
import cn.ibizlab.ehr.core.vac.filter.VACHOLIDAYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACHOLIDAY] 服务对象接口
 */
public interface IVACHOLIDAYService extends IService<VACHOLIDAY>{

    VACHOLIDAY aPPOINTJZBJJR(VACHOLIDAY et) ;
    boolean update(VACHOLIDAY et) ;
    void updateBatch(List<VACHOLIDAY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(VACHOLIDAY et) ;
    VACHOLIDAY getDraft(VACHOLIDAY et) ;
    VACHOLIDAY get(String key) ;
    boolean save(VACHOLIDAY et) ;
    void saveBatch(List<VACHOLIDAY> list) ;
    boolean create(VACHOLIDAY et) ;
    void createBatch(List<VACHOLIDAY> list) ;
    VACHOLIDAY checkTime(VACHOLIDAY et) ;
    Page<VACHOLIDAY> searchDefault(VACHOLIDAYSearchContext context) ;
    List<VACHOLIDAY> selectByVacholidayrulesid(String vacholidayrulesid) ;
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


