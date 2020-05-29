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

import cn.ibizlab.ehr.core.orm.domain.OrmZwdqgz;
import cn.ibizlab.ehr.core.orm.filter.OrmZwdqgzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmZwdqgz] 服务对象接口
 */
public interface IOrmZwdqgzService extends IService<OrmZwdqgz>{

    OrmZwdqgz get(String key) ;
    boolean save(OrmZwdqgz et) ;
    void saveBatch(List<OrmZwdqgz> list) ;
    boolean checkKey(OrmZwdqgz et) ;
    boolean update(OrmZwdqgz et) ;
    void updateBatch(List<OrmZwdqgz> list) ;
    OrmZwdqgz getDraft(OrmZwdqgz et) ;
    boolean create(OrmZwdqgz et) ;
    void createBatch(List<OrmZwdqgz> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<OrmZwdqgz> searchDQYHZZ(OrmZwdqgzSearchContext context) ;
    Page<OrmZwdqgz> searchDefault(OrmZwdqgzSearchContext context) ;
    List<OrmZwdqgz> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<OrmZwdqgz> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<OrmZwdqgz> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
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

    List<OrmZwdqgz> getOrmzwdqgzByIds(List<String> ids) ;
    List<OrmZwdqgz> getOrmzwdqgzByEntities(List<OrmZwdqgz> entities) ;

}


