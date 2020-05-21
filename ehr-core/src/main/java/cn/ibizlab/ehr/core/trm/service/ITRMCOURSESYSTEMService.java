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

import cn.ibizlab.ehr.core.trm.domain.TRMCOURSESYSTEM;
import cn.ibizlab.ehr.core.trm.filter.TRMCOURSESYSTEMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMCOURSESYSTEM] 服务对象接口
 */
public interface ITRMCOURSESYSTEMService extends IService<TRMCOURSESYSTEM>{

    boolean update(TRMCOURSESYSTEM et) ;
    void updateBatch(List<TRMCOURSESYSTEM> list) ;
    boolean save(TRMCOURSESYSTEM et) ;
    void saveBatch(List<TRMCOURSESYSTEM> list) ;
    boolean checkKey(TRMCOURSESYSTEM et) ;
    TRMCOURSESYSTEM getDraft(TRMCOURSESYSTEM et) ;
    TRMCOURSESYSTEM get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(TRMCOURSESYSTEM et) ;
    void createBatch(List<TRMCOURSESYSTEM> list) ;
    Page<TRMCOURSESYSTEM> searchDefault(TRMCOURSESYSTEMSearchContext context) ;
    List<TRMCOURSESYSTEM> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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


