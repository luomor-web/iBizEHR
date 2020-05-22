package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SALSOURCE;
import cn.ibizlab.ehr.core.sal.filter.SALSOURCESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSOURCE] 服务对象接口
 */
public interface ISALSOURCEService extends IService<SALSOURCE>{

    SALSOURCE get(String key) ;
    boolean save(SALSOURCE et) ;
    void saveBatch(List<SALSOURCE> list) ;
    boolean update(SALSOURCE et) ;
    void updateBatch(List<SALSOURCE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SALSOURCE et) ;
    void createBatch(List<SALSOURCE> list) ;
    boolean checkKey(SALSOURCE et) ;
    SALSOURCE getDraft(SALSOURCE et) ;
    Page<SALSOURCE> searchDefault(SALSOURCESearchContext context) ;
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


