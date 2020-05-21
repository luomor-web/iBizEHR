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

import cn.ibizlab.ehr.core.common.domain.OrgSecUser;
import cn.ibizlab.ehr.core.common.filter.OrgSecUserSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrgSecUser] 服务对象接口
 */
public interface IOrgSecUserService extends IService<OrgSecUser>{

    boolean update(OrgSecUser et) ;
    void updateBatch(List<OrgSecUser> list) ;
    OrgSecUser getDraft(OrgSecUser et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(OrgSecUser et) ;
    void createBatch(List<OrgSecUser> list) ;
    boolean save(OrgSecUser et) ;
    void saveBatch(List<OrgSecUser> list) ;
    OrgSecUser removeDefault(OrgSecUser et) ;
    OrgSecUser get(String key) ;
    boolean checkKey(OrgSecUser et) ;
    Page<OrgSecUser> searchDefault(OrgSecUserSearchContext context) ;
    List<OrgSecUser> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<OrgSecUser> selectByOrgsecusertypeid(String orgsecusertypeid) ;
    void removeByOrgsecusertypeid(String orgsecusertypeid) ;
    List<OrgSecUser> selectByOrguserid(String orguserid) ;
    void removeByOrguserid(String orguserid) ;
    List<OrgSecUser> selectByOrgid(String orgid) ;
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


