package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.OrgSector;
import cn.ibizlab.ehr.core.common.filter.OrgSectorSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrgSector] 服务对象接口
 */
public interface IOrgSectorService extends IService<OrgSector>{

    boolean create(OrgSector et) ;
    void createBatch(List<OrgSector> list) ;
    boolean save(OrgSector et) ;
    void saveBatch(List<OrgSector> list) ;
    OrgSector get(String key) ;
    OrgSector initUserObject(OrgSector et) ;
    boolean update(OrgSector et) ;
    void updateBatch(List<OrgSector> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(OrgSector et) ;
    OrgSector getDraft(OrgSector et) ;
    Page<OrgSector> searchCurChild(OrgSectorSearchContext context) ;
    Page<OrgSector> searchCurOrgOrg(OrgSectorSearchContext context) ;
    Page<OrgSector> searchUserOrgSector(OrgSectorSearchContext context) ;
    Page<OrgSector> searchOrgRoot(OrgSectorSearchContext context) ;
    Page<OrgSector> searchUserOrg(OrgSectorSearchContext context) ;
    Page<OrgSector> searchCurOrg(OrgSectorSearchContext context) ;
    Page<OrgSector> searchDefault(OrgSectorSearchContext context) ;
    List<OrgSector> selectByPorgsectorid(String orgsectorid) ;
    void removeByPorgsectorid(String orgsectorid) ;
    List<OrgSector> selectByReporgsectorid(String orgsectorid) ;
    void removeByReporgsectorid(String orgsectorid) ;
    List<OrgSector> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
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


