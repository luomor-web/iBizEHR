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

import cn.ibizlab.ehr.core.sal.domain.SALSALARYBILL;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYBILLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSALARYBILL] 服务对象接口
 */
public interface ISALSALARYBILLService extends IService<SALSALARYBILL>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SALSALARYBILL et) ;
    boolean create(SALSALARYBILL et) ;
    void createBatch(List<SALSALARYBILL> list) ;
    SALSALARYBILL getDraft(SALSALARYBILL et) ;
    boolean update(SALSALARYBILL et) ;
    void updateBatch(List<SALSALARYBILL> list) ;
    SALSALARYBILL get(String key) ;
    boolean save(SALSALARYBILL et) ;
    void saveBatch(List<SALSALARYBILL> list) ;
    Page<SALSALARYBILL> searchDefault(SALSALARYBILLSearchContext context) ;
    List<SALSALARYBILL> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<SALSALARYBILL> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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


