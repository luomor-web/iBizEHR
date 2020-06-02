package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PimSearchFieldSet;
import cn.ibizlab.ehr.core.pim.filter.PimSearchFieldSetSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimSearchFieldSet] 服务对象接口
 */
public interface IPimSearchFieldSetService extends IService<PimSearchFieldSet>{

    PimSearchFieldSet initDictionary(PimSearchFieldSet et) ;
    boolean save(PimSearchFieldSet et) ;
    void saveBatch(List<PimSearchFieldSet> list) ;
    boolean update(PimSearchFieldSet et) ;
    void updateBatch(List<PimSearchFieldSet> list) ;
    PimSearchFieldSet getDraft(PimSearchFieldSet et) ;
    boolean checkKey(PimSearchFieldSet et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimSearchFieldSet get(String key) ;
    boolean create(PimSearchFieldSet et) ;
    void createBatch(List<PimSearchFieldSet> list) ;
    Page<PimSearchFieldSet> searchAllDATA(PimSearchFieldSetSearchContext context) ;
    Page<PimSearchFieldSet> searchDefault(PimSearchFieldSetSearchContext context) ;
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

    List<PimSearchFieldSet> getPimsearchfieldsetByIds(List<String> ids) ;
    List<PimSearchFieldSet> getPimsearchfieldsetByEntities(List<PimSearchFieldSet> entities) ;

}


