package cn.ibizlab.ehr.core.orm.service;

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

import cn.ibizlab.ehr.core.orm.domain.OrmOrg;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmOrg] 服务对象接口
 */
public interface IOrmOrgService extends IService<OrmOrg>{

    boolean update(OrmOrg et) ;
    void updateBatch(List<OrmOrg> list) ;
    OrmOrg synOrg(OrmOrg et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmOrg getDraft(OrmOrg et) ;
    OrmOrg get(String key) ;
    boolean checkKey(OrmOrg et) ;
    boolean create(OrmOrg et) ;
    void createBatch(List<OrmOrg> list) ;
    boolean save(OrmOrg et) ;
    void saveBatch(List<OrmOrg> list) ;
    Page<OrmOrg> searchALLSIGNORG(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchAllLevelTwoOrg2(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchOrglist_Profile(OrmOrgSearchContext context) ;
    Page<HashMap> searchREP_ORG(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchAuthOrg(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchGSGWZY(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchSubSubOrg(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchDefault(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchCurChild(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchSJYXZZ(OrmOrgSearchContext context) ;
    Page<HashMap> searchREP_ORGPNUM(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchKZSJZZXZ(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchDanQian(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchAllLevelTwoOrg(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchSubOrg(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchHTGLDW(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchKZXLXZ(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchAuthSJYXZZ(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchUseByFP(OrmOrgSearchContext context) ;
    Page<OrmOrg> searchCurPorg(OrmOrgSearchContext context) ;
    List<OrmOrg> selectByPorgid(String orgid) ;
    void removeByPorgid(String orgid) ;
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

    List<OrmOrg> getOrmorgByIds(List<String> ids) ;
    List<OrmOrg> getOrmorgByEntities(List<OrmOrg> entities) ;

}


