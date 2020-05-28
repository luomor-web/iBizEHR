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

import cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz;
import cn.ibizlab.ehr.core.orm.filter.OrmBmkqdzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmBmkqdz] 服务对象接口
 */
public interface IOrmBmkqdzService extends IService<OrmBmkqdz>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmBmkqdz getDraft(OrmBmkqdz et) ;
    boolean checkKey(OrmBmkqdz et) ;
    boolean save(OrmBmkqdz et) ;
    void saveBatch(List<OrmBmkqdz> list) ;
    boolean update(OrmBmkqdz et) ;
    void updateBatch(List<OrmBmkqdz> list) ;
    boolean create(OrmBmkqdz et) ;
    void createBatch(List<OrmBmkqdz> list) ;
    OrmBmkqdz get(String key) ;
    Page<OrmBmkqdz> searchDefault(OrmBmkqdzSearchContext context) ;
    List<OrmBmkqdz> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<OrmBmkqdz> getOrmbmkqdzByIds(List<String> ids) ;
    List<OrmBmkqdz> getOrmbmkqdzByEntities(List<OrmBmkqdz> entities) ;

}


