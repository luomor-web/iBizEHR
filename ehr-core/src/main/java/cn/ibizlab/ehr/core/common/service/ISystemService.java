package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.System;
import cn.ibizlab.ehr.core.common.filter.SystemSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[System] 服务对象接口
 */
public interface ISystemService extends IService<System>{

    System getDraft(System et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(System et) ;
    boolean save(System et) ;
    void saveBatch(List<System> list) ;
    boolean create(System et) ;
    void createBatch(List<System> list) ;
    System get(String key) ;
    boolean update(System et) ;
    void updateBatch(List<System> list) ;
    Page<System> searchDefault(SystemSearchContext context) ;
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


