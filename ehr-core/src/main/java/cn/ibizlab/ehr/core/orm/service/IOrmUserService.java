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

import cn.ibizlab.ehr.core.orm.domain.OrmUser;
import cn.ibizlab.ehr.core.orm.filter.OrmUserSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmUser] 服务对象接口
 */
public interface IOrmUserService extends IService<OrmUser>{

    OrmUser get(String key) ;
    boolean create(OrmUser et) ;
    void createBatch(List<OrmUser> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(OrmUser et) ;
    void updateBatch(List<OrmUser> list) ;
    boolean checkKey(OrmUser et) ;
    boolean save(OrmUser et) ;
    void saveBatch(List<OrmUser> list) ;
    OrmUser getDraft(OrmUser et) ;
    Page<OrmUser> searchDQZZJXJZZ(OrmUserSearchContext context) ;
    Page<OrmUser> searchDefault(OrmUserSearchContext context) ;
    List<OrmUser> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<OrmUser> selectByOrgid(String orgid) ;
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

    List<OrmUser> getOrmuserByIds(List<String> ids) ;
    List<OrmUser> getOrmuserByEntities(List<OrmUser> entities) ;

}


