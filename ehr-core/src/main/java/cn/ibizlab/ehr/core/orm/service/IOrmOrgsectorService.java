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

import cn.ibizlab.ehr.core.orm.domain.OrmOrgsector;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgsectorSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmOrgsector] 服务对象接口
 */
public interface IOrmOrgsectorService extends IService<OrmOrgsector>{

    OrmOrgsector changeEdition(OrmOrgsector et) ;
    boolean create(OrmOrgsector et) ;
    void createBatch(List<OrmOrgsector> list) ;
    OrmOrgsector synOrgSectPro(OrmOrgsector et) ;
    OrmOrgsector cLWC(OrmOrgsector et) ;
    boolean checkKey(OrmOrgsector et) ;
    boolean save(OrmOrgsector et) ;
    void saveBatch(List<OrmOrgsector> list) ;
    OrmOrgsector getDraft(OrmOrgsector et) ;
    OrmOrgsector tJ(OrmOrgsector et) ;
    boolean update(OrmOrgsector et) ;
    void updateBatch(List<OrmOrgsector> list) ;
    OrmOrgsector get(String key) ;
    OrmOrgsector synOrgSectOderNum(OrmOrgsector et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmOrgsector synOrgSec(OrmOrgsector et) ;
    Page<OrmOrgsector> searchCURORMORG(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchXMBBZGL(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchJSYXMB(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchCurZZBM(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchCurZZBM_KQSZ(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchCURORG(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchCurOrgSector(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchDefault(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchBaseInfo(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchDQZZXBM(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchRsshInfo(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchSubOrgsector(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchPimpersonInfoOrgsector(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchHisInfo(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchSubZZBM(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchProExpandInfo(OrmOrgsectorSearchContext context) ;
    Page<OrmOrgsector> searchBMBZGL(OrmOrgsectorSearchContext context) ;
    List<OrmOrgsector> selectByPorgsectorid(String orgsectorid) ;
    void removeByPorgsectorid(String orgsectorid) ;
    List<OrmOrgsector> selectByProdepid(String orgsectorid) ;
    void removeByProdepid(String orgsectorid) ;
    List<OrmOrgsector> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
    List<OrmOrgsector> selectByOrmxmglid(String ormxmglid) ;
    void removeByOrmxmglid(String ormxmglid) ;
    List<OrmOrgsector> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<OrmOrgsector> selectByProleaderid(String pimpersonid) ;
    void removeByProleaderid(String pimpersonid) ;
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

    List<OrmOrgsector> getOrmorgsectorByIds(List<String> ids) ;
    List<OrmOrgsector> getOrmorgsectorByEntities(List<OrmOrgsector> entities) ;

}


