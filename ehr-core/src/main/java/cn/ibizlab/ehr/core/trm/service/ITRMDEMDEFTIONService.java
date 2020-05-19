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

import cn.ibizlab.ehr.core.trm.domain.TRMDEMDEFTION;
import cn.ibizlab.ehr.core.trm.filter.TRMDEMDEFTIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMDEMDEFTION] 服务对象接口
 */
public interface ITRMDEMDEFTIONService extends IService<TRMDEMDEFTION>{

    TRMDEMDEFTION getDraft(TRMDEMDEFTION et) ;
    boolean create(TRMDEMDEFTION et) ;
    void createBatch(List<TRMDEMDEFTION> list) ;
    boolean update(TRMDEMDEFTION et) ;
    void updateBatch(List<TRMDEMDEFTION> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMDEMDEFTION et) ;
    void saveBatch(List<TRMDEMDEFTION> list) ;
    boolean checkKey(TRMDEMDEFTION et) ;
    TRMDEMDEFTION get(String key) ;
    Page<TRMDEMDEFTION> searchDefault(TRMDEMDEFTIONSearchContext context) ;
    List<TRMDEMDEFTION> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMDEMDEFTION> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMDEMDEFTION> selectByTrmdepartid(String trmdepartid) ;
    void removeByTrmdepartid(String trmdepartid) ;
    List<TRMDEMDEFTION> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TRMDEMDEFTION> selectByTrmtrainfillinid(String trmtrainfillinid) ;
    void removeByTrmtrainfillinid(String trmtrainfillinid) ;
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


