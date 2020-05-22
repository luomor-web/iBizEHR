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

import cn.ibizlab.ehr.core.att.domain.ATTENSUMMARY;
import cn.ibizlab.ehr.core.att.filter.ATTENSUMMARYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENSUMMARY] 服务对象接口
 */
public interface IATTENSUMMARYService extends IService<ATTENSUMMARY>{

    ATTENSUMMARY getDraft(ATTENSUMMARY et) ;
    boolean create(ATTENSUMMARY et) ;
    void createBatch(List<ATTENSUMMARY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ATTENSUMMARY et) ;
    void updateBatch(List<ATTENSUMMARY> list) ;
    ATTENSUMMARY get(String key) ;
    boolean save(ATTENSUMMARY et) ;
    void saveBatch(List<ATTENSUMMARY> list) ;
    boolean checkKey(ATTENSUMMARY et) ;
    ATTENSUMMARY exportKQHZ(ATTENSUMMARY et) ;
    Page<ATTENSUMMARY> searchCurZZKQHZ(ATTENSUMMARYSearchContext context) ;
    Page<ATTENSUMMARY> searchDefault(ATTENSUMMARYSearchContext context) ;
    List<ATTENSUMMARY> selectByPimpersonid(String pimpersonid) ;
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


