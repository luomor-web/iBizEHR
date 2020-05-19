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

import cn.ibizlab.ehr.core.sal.domain.SALRULE;
import cn.ibizlab.ehr.core.sal.filter.SALRULESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALRULE] 服务对象接口
 */
public interface ISALRULEService extends IService<SALRULE>{

    SALRULE getDraft(SALRULE et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALRULE get(String key) ;
    boolean create(SALRULE et) ;
    void createBatch(List<SALRULE> list) ;
    boolean update(SALRULE et) ;
    void updateBatch(List<SALRULE> list) ;
    boolean save(SALRULE et) ;
    void saveBatch(List<SALRULE> list) ;
    boolean checkKey(SALRULE et) ;
    Page<SALRULE> searchDefault(SALRULESearchContext context) ;
    List<SALRULE> selectBySalparamid(String salparamid) ;
    void removeBySalparamid(String salparamid) ;
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


