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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINAGENCYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINAGENCY] 服务对象接口
 */
public interface ITRMTRAINAGENCYService extends IService<TRMTRAINAGENCY>{

    boolean save(TRMTRAINAGENCY et) ;
    void saveBatch(List<TRMTRAINAGENCY> list) ;
    boolean checkKey(TRMTRAINAGENCY et) ;
    TRMTRAINAGENCY getDraft(TRMTRAINAGENCY et) ;
    TRMTRAINAGENCY get(String key) ;
    boolean update(TRMTRAINAGENCY et) ;
    void updateBatch(List<TRMTRAINAGENCY> list) ;
    boolean create(TRMTRAINAGENCY et) ;
    void createBatch(List<TRMTRAINAGENCY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TRMTRAINAGENCY> searchDefault(TRMTRAINAGENCYSearchContext context) ;
    List<TRMTRAINAGENCY> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMTRAINAGENCY> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMTRAINAGENCY> selectByTrmtrainagencyid2(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid2(String trmtrainagencyid) ;
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


