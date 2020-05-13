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

import cn.ibizlab.ehr.core.trm.domain.TRMEMPLOYRETION;
import cn.ibizlab.ehr.core.trm.filter.TRMEMPLOYRETIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMEMPLOYRETION] 服务对象接口
 */
public interface ITRMEMPLOYRETIONService extends IService<TRMEMPLOYRETION>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMEMPLOYRETION getDraft(TRMEMPLOYRETION et) ;
    boolean update(TRMEMPLOYRETION et) ;
    void updateBatch(List<TRMEMPLOYRETION> list) ;
    boolean save(TRMEMPLOYRETION et) ;
    void saveBatch(List<TRMEMPLOYRETION> list) ;
    boolean create(TRMEMPLOYRETION et) ;
    void createBatch(List<TRMEMPLOYRETION> list) ;
    boolean checkKey(TRMEMPLOYRETION et) ;
    TRMEMPLOYRETION get(String key) ;
    Page<TRMEMPLOYRETION> searchDefault(TRMEMPLOYRETIONSearchContext context) ;
    List<TRMEMPLOYRETION> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMEMPLOYRETION> selectByTrmcouarrangeid(String trmcouarrangeid) ;
    void removeByTrmcouarrangeid(String trmcouarrangeid) ;
    List<TRMEMPLOYRETION> selectByTrmtrainactapplyid(String trmtrainactapplyid) ;
    void removeByTrmtrainactapplyid(String trmtrainactapplyid) ;
    List<TRMEMPLOYRETION> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
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


