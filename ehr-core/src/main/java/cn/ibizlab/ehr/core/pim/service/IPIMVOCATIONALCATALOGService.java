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

import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONALCATALOG;
import cn.ibizlab.ehr.core.pim.filter.PIMVOCATIONALCATALOGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMVOCATIONALCATALOG] 服务对象接口
 */
public interface IPIMVOCATIONALCATALOGService extends IService<PIMVOCATIONALCATALOG>{

    boolean save(PIMVOCATIONALCATALOG et) ;
    void saveBatch(List<PIMVOCATIONALCATALOG> list) ;
    PIMVOCATIONALCATALOG getDraft(PIMVOCATIONALCATALOG et) ;
    PIMVOCATIONALCATALOG get(String key) ;
    boolean checkKey(PIMVOCATIONALCATALOG et) ;
    boolean update(PIMVOCATIONALCATALOG et) ;
    void updateBatch(List<PIMVOCATIONALCATALOG> list) ;
    boolean create(PIMVOCATIONALCATALOG et) ;
    void createBatch(List<PIMVOCATIONALCATALOG> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PIMVOCATIONALCATALOG> searchDefault(PIMVOCATIONALCATALOGSearchContext context) ;
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


