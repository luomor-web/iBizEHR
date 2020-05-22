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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINFILLINSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINFILLIN] 服务对象接口
 */
public interface ITRMTRAINFILLINService extends IService<TRMTRAINFILLIN>{

    TRMTRAINFILLIN get(String key) ;
    boolean update(TRMTRAINFILLIN et) ;
    void updateBatch(List<TRMTRAINFILLIN> list) ;
    boolean checkKey(TRMTRAINFILLIN et) ;
    boolean create(TRMTRAINFILLIN et) ;
    void createBatch(List<TRMTRAINFILLIN> list) ;
    boolean save(TRMTRAINFILLIN et) ;
    void saveBatch(List<TRMTRAINFILLIN> list) ;
    TRMTRAINFILLIN getDraft(TRMTRAINFILLIN et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TRMTRAINFILLIN> searchDefault(TRMTRAINFILLINSearchContext context) ;
    List<TRMTRAINFILLIN> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TRMTRAINFILLIN> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMTRAINFILLIN> selectByTrmdepartid(String trmdepartid) ;
    void removeByTrmdepartid(String trmdepartid) ;
    List<TRMTRAINFILLIN> selectByTrmtrainfillinid2(String trmtrainfillinid) ;
    void removeByTrmtrainfillinid2(String trmtrainfillinid) ;
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


