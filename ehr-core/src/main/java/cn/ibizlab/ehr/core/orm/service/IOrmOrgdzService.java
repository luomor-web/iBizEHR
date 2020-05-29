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

import cn.ibizlab.ehr.core.orm.domain.OrmOrgdz;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgdzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmOrgdz] 服务对象接口
 */
public interface IOrmOrgdzService extends IService<OrmOrgdz>{

    OrmOrgdz get(String key) ;
    OrmOrgdz getDraft(OrmOrgdz et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(OrmOrgdz et) ;
    void saveBatch(List<OrmOrgdz> list) ;
    boolean create(OrmOrgdz et) ;
    void createBatch(List<OrmOrgdz> list) ;
    boolean update(OrmOrgdz et) ;
    void updateBatch(List<OrmOrgdz> list) ;
    boolean checkKey(OrmOrgdz et) ;
    Page<OrmOrgdz> searchDefault(OrmOrgdzSearchContext context) ;
    List<OrmOrgdz> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<OrmOrgdz> getOrmorgdzByIds(List<String> ids) ;
    List<OrmOrgdz> getOrmorgdzByEntities(List<OrmOrgdz> entities) ;

}


