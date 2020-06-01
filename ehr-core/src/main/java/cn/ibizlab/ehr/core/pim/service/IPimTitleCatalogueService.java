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

import cn.ibizlab.ehr.core.pim.domain.PimTitleCatalogue;
import cn.ibizlab.ehr.core.pim.filter.PimTitleCatalogueSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimTitleCatalogue] 服务对象接口
 */
public interface IPimTitleCatalogueService extends IService<PimTitleCatalogue>{

    boolean save(PimTitleCatalogue et) ;
    void saveBatch(List<PimTitleCatalogue> list) ;
    boolean update(PimTitleCatalogue et) ;
    void updateBatch(List<PimTitleCatalogue> list) ;
    PimTitleCatalogue getDraft(PimTitleCatalogue et) ;
    boolean create(PimTitleCatalogue et) ;
    void createBatch(List<PimTitleCatalogue> list) ;
    boolean checkKey(PimTitleCatalogue et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimTitleCatalogue get(String key) ;
    Page<PimTitleCatalogue> searchIsRootDQ(PimTitleCatalogueSearchContext context) ;
    Page<PimTitleCatalogue> searchNotRootDQ(PimTitleCatalogueSearchContext context) ;
    Page<PimTitleCatalogue> searchDefault(PimTitleCatalogueSearchContext context) ;
    List<PimTitleCatalogue> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimTitleCatalogue> selectByPimtitlecatalogueid2(String pimtitlecatalogueid) ;
    void removeByPimtitlecatalogueid2(String pimtitlecatalogueid) ;
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

    List<PimTitleCatalogue> getPimtitlecatalogueByIds(List<String> ids) ;
    List<PimTitleCatalogue> getPimtitlecatalogueByEntities(List<PimTitleCatalogue> entities) ;

}


