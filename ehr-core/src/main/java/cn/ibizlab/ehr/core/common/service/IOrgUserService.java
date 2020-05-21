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

import cn.ibizlab.ehr.core.common.domain.OrgUser;
import cn.ibizlab.ehr.core.common.filter.OrgUserSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrgUser] 服务对象接口
 */
public interface IOrgUserService extends IService<OrgUser>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrgUser getDraft(OrgUser et) ;
    boolean update(OrgUser et) ;
    void updateBatch(List<OrgUser> list) ;
    OrgUser get(String key) ;
    boolean save(OrgUser et) ;
    void saveBatch(List<OrgUser> list) ;
    OrgUser updateCurUser(OrgUser et) ;
    boolean create(OrgUser et) ;
    void createBatch(List<OrgUser> list) ;
    OrgUser getCurUser(OrgUser et) ;
    boolean checkKey(OrgUser et) ;
    Page<OrgUser> searchCurOrg(OrgUserSearchContext context) ;
    Page<OrgUser> searchDefault(OrgUserSearchContext context) ;
    Page<OrgUser> searchCurOrgSector(OrgUserSearchContext context) ;
    Page<OrgUser> searchUserOrgSector(OrgUserSearchContext context) ;
    Page<OrgUser> searchUserOrg(OrgUserSearchContext context) ;
    Page<OrgUser> searchDQZZJXJZZ(OrgUserSearchContext context) ;
    List<OrgUser> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<OrgUser> selectByOrgsecusertypeid(String orgsecusertypeid) ;
    void removeByOrgsecusertypeid(String orgsecusertypeid) ;
    List<OrgUser> selectByOrguserlevelid(String orguserlevelid) ;
    void removeByOrguserlevelid(String orguserlevelid) ;
    List<OrgUser> selectByOrgid(String orgid) ;
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


