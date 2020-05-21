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

import cn.ibizlab.ehr.core.trm.domain.TRMTEACHERTRAIN;
import cn.ibizlab.ehr.core.trm.filter.TRMTEACHERTRAINSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTEACHERTRAIN] 服务对象接口
 */
public interface ITRMTEACHERTRAINService extends IService<TRMTEACHERTRAIN>{

    boolean save(TRMTEACHERTRAIN et) ;
    void saveBatch(List<TRMTEACHERTRAIN> list) ;
    TRMTEACHERTRAIN getDraft(TRMTEACHERTRAIN et) ;
    boolean create(TRMTEACHERTRAIN et) ;
    void createBatch(List<TRMTEACHERTRAIN> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMTEACHERTRAIN get(String key) ;
    boolean update(TRMTEACHERTRAIN et) ;
    void updateBatch(List<TRMTEACHERTRAIN> list) ;
    boolean checkKey(TRMTEACHERTRAIN et) ;
    Page<TRMTEACHERTRAIN> searchDefault(TRMTEACHERTRAINSearchContext context) ;
    List<TRMTEACHERTRAIN> selectByTrmtrainaddressid(String trmtrainaddressid) ;
    void removeByTrmtrainaddressid(String trmtrainaddressid) ;
    List<TRMTEACHERTRAIN> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TRMTEACHERTRAIN> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
    List<TRMTEACHERTRAIN> selectByTrmtrainteacherid(String trmtrainteacherid) ;
    void removeByTrmtrainteacherid(String trmtrainteacherid) ;
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


