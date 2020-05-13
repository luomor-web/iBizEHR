package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TRMDEPARTNEEDS;
import cn.ibizlab.ehr.core.trm.filter.TRMDEPARTNEEDSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMDEPARTNEEDS] 服务对象接口
 */
public interface ITRMDEPARTNEEDSService extends IService<TRMDEPARTNEEDS>{

    boolean update(TRMDEPARTNEEDS et) ;
    void updateBatch(List<TRMDEPARTNEEDS> list) ;
    TRMDEPARTNEEDS get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMDEPARTNEEDS et) ;
    void saveBatch(List<TRMDEPARTNEEDS> list) ;
    TRMDEPARTNEEDS getDraft(TRMDEPARTNEEDS et) ;
    boolean checkKey(TRMDEPARTNEEDS et) ;
    boolean create(TRMDEPARTNEEDS et) ;
    void createBatch(List<TRMDEPARTNEEDS> list) ;
    Page<TRMDEPARTNEEDS> searchDefault(TRMDEPARTNEEDSSearchContext context) ;
    List<TRMDEPARTNEEDS> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
    List<TRMDEPARTNEEDS> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
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


