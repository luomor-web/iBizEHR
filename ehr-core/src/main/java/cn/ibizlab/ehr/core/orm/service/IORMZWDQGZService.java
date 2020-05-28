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

import cn.ibizlab.ehr.core.orm.domain.ORMZWDQGZ;
import cn.ibizlab.ehr.core.orm.filter.ORMZWDQGZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMZWDQGZ] 服务对象接口
 */
public interface IORMZWDQGZService extends IService<ORMZWDQGZ>{

    ORMZWDQGZ get(String key) ;
    boolean save(ORMZWDQGZ et) ;
    void saveBatch(List<ORMZWDQGZ> list) ;
    boolean checkKey(ORMZWDQGZ et) ;
    boolean update(ORMZWDQGZ et) ;
    void updateBatch(List<ORMZWDQGZ> list) ;
    ORMZWDQGZ getDraft(ORMZWDQGZ et) ;
    boolean create(ORMZWDQGZ et) ;
    void createBatch(List<ORMZWDQGZ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ORMZWDQGZ> searchDQYHZZ(ORMZWDQGZSearchContext context) ;
    Page<ORMZWDQGZ> searchDefault(ORMZWDQGZSearchContext context) ;
    List<ORMZWDQGZ> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<ORMZWDQGZ> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<ORMZWDQGZ> selectByOrmrankid(String ormrankid) ;
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

    List<ORMZWDQGZ> getOrmzwdqgzByIds(List<String> ids) ;
    List<ORMZWDQGZ> getOrmzwdqgzByEntities(List<ORMZWDQGZ> entities) ;

}


