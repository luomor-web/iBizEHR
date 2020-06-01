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

import cn.ibizlab.ehr.core.orm.domain.OrmBmgwbz;
import cn.ibizlab.ehr.core.orm.filter.OrmBmgwbzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmBmgwbz] 服务对象接口
 */
public interface IOrmBmgwbzService extends IService<OrmBmgwbz>{

    boolean create(OrmBmgwbz et) ;
    void createBatch(List<OrmBmgwbz> list) ;
    boolean checkKey(OrmBmgwbz et) ;
    OrmBmgwbz get(String key) ;
    boolean save(OrmBmgwbz et) ;
    void saveBatch(List<OrmBmgwbz> list) ;
    boolean update(OrmBmgwbz et) ;
    void updateBatch(List<OrmBmgwbz> list) ;
    OrmBmgwbz getDraft(OrmBmgwbz et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<OrmBmgwbz> searchDefault(OrmBmgwbzSearchContext context) ;
    List<OrmBmgwbz> selectByOrmgwbzid(String orgsectorid) ;
    void removeByOrmgwbzid(String orgsectorid) ;
    List<OrmBmgwbz> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
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

    List<OrmBmgwbz> getOrmbmgwbzByIds(List<String> ids) ;
    List<OrmBmgwbz> getOrmbmgwbzByEntities(List<OrmBmgwbz> entities) ;

}


