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

import cn.ibizlab.ehr.core.orm.domain.ORMORGDZ;
import cn.ibizlab.ehr.core.orm.filter.ORMORGDZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMORGDZ] 服务对象接口
 */
public interface IORMORGDZService extends IService<ORMORGDZ>{

    ORMORGDZ get(String key) ;
    ORMORGDZ getDraft(ORMORGDZ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ORMORGDZ et) ;
    void saveBatch(List<ORMORGDZ> list) ;
    boolean create(ORMORGDZ et) ;
    void createBatch(List<ORMORGDZ> list) ;
    boolean update(ORMORGDZ et) ;
    void updateBatch(List<ORMORGDZ> list) ;
    boolean checkKey(ORMORGDZ et) ;
    Page<ORMORGDZ> searchDefault(ORMORGDZSearchContext context) ;
    List<ORMORGDZ> selectByOrmorgid(String orgid) ;
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

}


