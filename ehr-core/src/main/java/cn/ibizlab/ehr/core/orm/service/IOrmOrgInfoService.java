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

import cn.ibizlab.ehr.core.orm.domain.OrmOrgInfo;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgInfoSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmOrgInfo] 服务对象接口
 */
public interface IOrmOrgInfoService extends IService<OrmOrgInfo>{

    boolean checkKey(OrmOrgInfo et) ;
    boolean save(OrmOrgInfo et) ;
    void saveBatch(List<OrmOrgInfo> list) ;
    OrmOrgInfo getDraft(OrmOrgInfo et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmOrgInfo get(String key) ;
    boolean create(OrmOrgInfo et) ;
    void createBatch(List<OrmOrgInfo> list) ;
    boolean update(OrmOrgInfo et) ;
    void updateBatch(List<OrmOrgInfo> list) ;
    Page<OrmOrgInfo> searchSubOrgsector(OrmOrgInfoSearchContext context) ;
    Page<OrmOrgInfo> searchCX(OrmOrgInfoSearchContext context) ;
    Page<OrmOrgInfo> searchCurOrgsector(OrmOrgInfoSearchContext context) ;
    Page<OrmOrgInfo> searchCurChild(OrmOrgInfoSearchContext context) ;
    Page<OrmOrgInfo> searchCurPorg(OrmOrgInfoSearchContext context) ;
    Page<OrmOrgInfo> searchSubPerson(OrmOrgInfoSearchContext context) ;
    Page<OrmOrgInfo> searchDefault(OrmOrgInfoSearchContext context) ;
    Page<OrmOrgInfo> searchSuborg(OrmOrgInfoSearchContext context) ;
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

    List<OrmOrgInfo> getOrmorginfoByIds(List<String> ids) ;
    List<OrmOrgInfo> getOrmorginfoByEntities(List<OrmOrgInfo> entities) ;

}


