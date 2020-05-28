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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINFACIES;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINFACIESSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINFACIES] 服务对象接口
 */
public interface ITRMTRAINFACIESService extends IService<TRMTRAINFACIES>{

    boolean checkKey(TRMTRAINFACIES et) ;
    TRMTRAINFACIES getDraft(TRMTRAINFACIES et) ;
    boolean update(TRMTRAINFACIES et) ;
    void updateBatch(List<TRMTRAINFACIES> list) ;
    boolean create(TRMTRAINFACIES et) ;
    void createBatch(List<TRMTRAINFACIES> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMTRAINFACIES et) ;
    void saveBatch(List<TRMTRAINFACIES> list) ;
    TRMTRAINFACIES get(String key) ;
    Page<TRMTRAINFACIES> searchDefault(TRMTRAINFACIESSearchContext context) ;
    List<TRMTRAINFACIES> selectByTrmtrainaddressid(String trmtrainaddressid) ;
    void removeByTrmtrainaddressid(String trmtrainaddressid) ;
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

    List<TRMTRAINFACIES> getTrmtrainfaciesByIds(List<String> ids) ;
    List<TRMTRAINFACIES> getTrmtrainfaciesByEntities(List<TRMTRAINFACIES> entities) ;

}


