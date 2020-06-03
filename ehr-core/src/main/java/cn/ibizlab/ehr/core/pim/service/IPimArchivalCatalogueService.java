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

import cn.ibizlab.ehr.core.pim.domain.PimArchivalCatalogue;
import cn.ibizlab.ehr.core.pim.filter.PimArchivalCatalogueSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArchivalCatalogue] 服务对象接口
 */
public interface IPimArchivalCatalogueService extends IService<PimArchivalCatalogue>{

    boolean save(PimArchivalCatalogue et) ;
    void saveBatch(List<PimArchivalCatalogue> list) ;
    boolean checkKey(PimArchivalCatalogue et) ;
    PimArchivalCatalogue get(String key) ;
    PimArchivalCatalogue getDraft(PimArchivalCatalogue et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PimArchivalCatalogue et) ;
    void updateBatch(List<PimArchivalCatalogue> list) ;
    boolean create(PimArchivalCatalogue et) ;
    void createBatch(List<PimArchivalCatalogue> list) ;
    Page<PimArchivalCatalogue> searchDefault(PimArchivalCatalogueSearchContext context) ;
    List<PimArchivalCatalogue> selectByPimarchivesid(String pimarchivesid) ;
    void removeByPimarchivesid(String pimarchivesid) ;
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

    List<PimArchivalCatalogue> getPimarchivalcatalogueByIds(List<String> ids) ;
    List<PimArchivalCatalogue> getPimarchivalcatalogueByEntities(List<PimArchivalCatalogue> entities) ;

}


