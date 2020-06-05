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

import cn.ibizlab.ehr.core.pim.domain.PimExitandentry;
import cn.ibizlab.ehr.core.pim.filter.PimExitandentrySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimExitandentry] 服务对象接口
 */
public interface IPimExitandentryService extends IService<PimExitandentry>{

    boolean update(PimExitandentry et) ;
    void updateBatch(List<PimExitandentry> list) ;
    boolean save(PimExitandentry et) ;
    void saveBatch(List<PimExitandentry> list) ;
    PimExitandentry cX(PimExitandentry et) ;
    PimExitandentry get(String key) ;
    PimExitandentry getDraft(PimExitandentry et) ;
    PimExitandentry mobStart(PimExitandentry et) ;
    boolean create(PimExitandentry et) ;
    void createBatch(List<PimExitandentry> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimExitandentry cB(PimExitandentry et) ;
    boolean checkKey(PimExitandentry et) ;
    PimExitandentry start(PimExitandentry et) ;
    Page<PimExitandentry> searchYGCGJ(PimExitandentrySearchContext context) ;
    Page<PimExitandentry> searchYGZZ(PimExitandentrySearchContext context) ;
    Page<PimExitandentry> searchMOBJLSS(PimExitandentrySearchContext context) ;
    Page<PimExitandentry> searchYSCGJ(PimExitandentrySearchContext context) ;
    Page<PimExitandentry> searchFormType(PimExitandentrySearchContext context) ;
    Page<PimExitandentry> searchDefault(PimExitandentrySearchContext context) ;
    List<PimExitandentry> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<PimExitandentry> getPimexitandentryByIds(List<String> ids) ;
    List<PimExitandentry> getPimexitandentryByEntities(List<PimExitandentry> entities) ;

}


