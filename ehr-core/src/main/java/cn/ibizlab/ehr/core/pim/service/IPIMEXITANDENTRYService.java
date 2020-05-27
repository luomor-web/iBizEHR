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

import cn.ibizlab.ehr.core.pim.domain.PIMEXITANDENTRY;
import cn.ibizlab.ehr.core.pim.filter.PIMEXITANDENTRYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMEXITANDENTRY] 服务对象接口
 */
public interface IPIMEXITANDENTRYService extends IService<PIMEXITANDENTRY>{

    boolean update(PIMEXITANDENTRY et) ;
    void updateBatch(List<PIMEXITANDENTRY> list) ;
    boolean save(PIMEXITANDENTRY et) ;
    void saveBatch(List<PIMEXITANDENTRY> list) ;
    PIMEXITANDENTRY cX(PIMEXITANDENTRY et) ;
    PIMEXITANDENTRY get(String key) ;
    PIMEXITANDENTRY getDraft(PIMEXITANDENTRY et) ;
    PIMEXITANDENTRY mobStart(PIMEXITANDENTRY et) ;
    boolean create(PIMEXITANDENTRY et) ;
    void createBatch(List<PIMEXITANDENTRY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMEXITANDENTRY cB(PIMEXITANDENTRY et) ;
    boolean checkKey(PIMEXITANDENTRY et) ;
    PIMEXITANDENTRY start(PIMEXITANDENTRY et) ;
    Page<PIMEXITANDENTRY> searchYGCGJ(PIMEXITANDENTRYSearchContext context) ;
    Page<PIMEXITANDENTRY> searchYGZZ(PIMEXITANDENTRYSearchContext context) ;
    Page<PIMEXITANDENTRY> searchMOBJLSS(PIMEXITANDENTRYSearchContext context) ;
    Page<PIMEXITANDENTRY> searchYSCGJ(PIMEXITANDENTRYSearchContext context) ;
    Page<PIMEXITANDENTRY> searchFormType(PIMEXITANDENTRYSearchContext context) ;
    Page<PIMEXITANDENTRY> searchDefault(PIMEXITANDENTRYSearchContext context) ;
    List<PIMEXITANDENTRY> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMEXITANDENTRY> getPimexitandentryByIds(List<String> ids) ;
    List<PIMEXITANDENTRY> getPimexitandentryByEntities(List<PIMEXITANDENTRY> entities) ;

}


