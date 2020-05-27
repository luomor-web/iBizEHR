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

import cn.ibizlab.ehr.core.pim.domain.ARCHIVALCATALOGUE;
import cn.ibizlab.ehr.core.pim.filter.ARCHIVALCATALOGUESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ARCHIVALCATALOGUE] 服务对象接口
 */
public interface IARCHIVALCATALOGUEService extends IService<ARCHIVALCATALOGUE>{

    boolean save(ARCHIVALCATALOGUE et) ;
    void saveBatch(List<ARCHIVALCATALOGUE> list) ;
    boolean checkKey(ARCHIVALCATALOGUE et) ;
    ARCHIVALCATALOGUE get(String key) ;
    ARCHIVALCATALOGUE getDraft(ARCHIVALCATALOGUE et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ARCHIVALCATALOGUE et) ;
    void updateBatch(List<ARCHIVALCATALOGUE> list) ;
    boolean create(ARCHIVALCATALOGUE et) ;
    void createBatch(List<ARCHIVALCATALOGUE> list) ;
    Page<ARCHIVALCATALOGUE> searchDefault(ARCHIVALCATALOGUESearchContext context) ;
    List<ARCHIVALCATALOGUE> selectByPimarchivesid(String pimarchivesid) ;
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

    List<ARCHIVALCATALOGUE> getArchivalcatalogueByIds(List<String> ids) ;
    List<ARCHIVALCATALOGUE> getArchivalcatalogueByEntities(List<ARCHIVALCATALOGUE> entities) ;

}


