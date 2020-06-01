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

import cn.ibizlab.ehr.core.pim.domain.PimVocationalCatalog;
import cn.ibizlab.ehr.core.pim.filter.PimVocationalCatalogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimVocationalCatalog] 服务对象接口
 */
public interface IPimVocationalCatalogService extends IService<PimVocationalCatalog>{

    boolean save(PimVocationalCatalog et) ;
    void saveBatch(List<PimVocationalCatalog> list) ;
    PimVocationalCatalog getDraft(PimVocationalCatalog et) ;
    PimVocationalCatalog get(String key) ;
    boolean checkKey(PimVocationalCatalog et) ;
    boolean update(PimVocationalCatalog et) ;
    void updateBatch(List<PimVocationalCatalog> list) ;
    boolean create(PimVocationalCatalog et) ;
    void createBatch(List<PimVocationalCatalog> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimVocationalCatalog> searchDefault(PimVocationalCatalogSearchContext context) ;
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

    List<PimVocationalCatalog> getPimvocationalcatalogByIds(List<String> ids) ;
    List<PimVocationalCatalog> getPimvocationalcatalogByEntities(List<PimVocationalCatalog> entities) ;

}


