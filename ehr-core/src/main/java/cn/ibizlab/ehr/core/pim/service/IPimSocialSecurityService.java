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

import cn.ibizlab.ehr.core.pim.domain.PimSocialSecurity;
import cn.ibizlab.ehr.core.pim.filter.PimSocialSecuritySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimSocialSecurity] 服务对象接口
 */
public interface IPimSocialSecurityService extends IService<PimSocialSecurity>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PimSocialSecurity et) ;
    PimSocialSecurity get(String key) ;
    PimSocialSecurity getDraft(PimSocialSecurity et) ;
    boolean update(PimSocialSecurity et) ;
    void updateBatch(List<PimSocialSecurity> list) ;
    boolean create(PimSocialSecurity et) ;
    void createBatch(List<PimSocialSecurity> list) ;
    boolean save(PimSocialSecurity et) ;
    void saveBatch(List<PimSocialSecurity> list) ;
    Page<PimSocialSecurity> searchZIZHU(PimSocialSecuritySearchContext context) ;
    Page<PimSocialSecurity> searchDefault(PimSocialSecuritySearchContext context) ;
    Page<PimSocialSecurity> searchJLSS(PimSocialSecuritySearchContext context) ;
    List<PimSocialSecurity> selectByPimpersonid(String pimpersonid) ;
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

    List<PimSocialSecurity> getPimsocialsecurityByIds(List<String> ids) ;
    List<PimSocialSecurity> getPimsocialsecurityByEntities(List<PimSocialSecurity> entities) ;

}


