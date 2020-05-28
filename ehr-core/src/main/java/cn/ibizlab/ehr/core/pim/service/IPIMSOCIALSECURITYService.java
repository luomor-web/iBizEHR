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

import cn.ibizlab.ehr.core.pim.domain.PIMSOCIALSECURITY;
import cn.ibizlab.ehr.core.pim.filter.PIMSOCIALSECURITYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMSOCIALSECURITY] 服务对象接口
 */
public interface IPIMSOCIALSECURITYService extends IService<PIMSOCIALSECURITY>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PIMSOCIALSECURITY et) ;
    PIMSOCIALSECURITY get(String key) ;
    PIMSOCIALSECURITY getDraft(PIMSOCIALSECURITY et) ;
    boolean update(PIMSOCIALSECURITY et) ;
    void updateBatch(List<PIMSOCIALSECURITY> list) ;
    boolean create(PIMSOCIALSECURITY et) ;
    void createBatch(List<PIMSOCIALSECURITY> list) ;
    boolean save(PIMSOCIALSECURITY et) ;
    void saveBatch(List<PIMSOCIALSECURITY> list) ;
    Page<PIMSOCIALSECURITY> searchZIZHU(PIMSOCIALSECURITYSearchContext context) ;
    Page<PIMSOCIALSECURITY> searchDefault(PIMSOCIALSECURITYSearchContext context) ;
    Page<PIMSOCIALSECURITY> searchJLSS(PIMSOCIALSECURITYSearchContext context) ;
    List<PIMSOCIALSECURITY> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMSOCIALSECURITY> getPimsocialsecurityByIds(List<String> ids) ;
    List<PIMSOCIALSECURITY> getPimsocialsecurityByEntities(List<PIMSOCIALSECURITY> entities) ;

}


