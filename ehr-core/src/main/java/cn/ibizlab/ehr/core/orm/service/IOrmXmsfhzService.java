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

import cn.ibizlab.ehr.core.orm.domain.OrmXmsfhz;
import cn.ibizlab.ehr.core.orm.filter.OrmXmsfhzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmXmsfhz] 服务对象接口
 */
public interface IOrmXmsfhzService extends IService<OrmXmsfhz>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(OrmXmsfhz et) ;
    void createBatch(List<OrmXmsfhz> list) ;
    boolean update(OrmXmsfhz et) ;
    void updateBatch(List<OrmXmsfhz> list) ;
    OrmXmsfhz getDraft(OrmXmsfhz et) ;
    boolean checkKey(OrmXmsfhz et) ;
    OrmXmsfhz get(String key) ;
    boolean save(OrmXmsfhz et) ;
    void saveBatch(List<OrmXmsfhz> list) ;
    Page<OrmXmsfhz> searchAccOrg(OrmXmsfhzSearchContext context) ;
    Page<OrmXmsfhz> searchDefault(OrmXmsfhzSearchContext context) ;
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

    List<OrmXmsfhz> getOrmxmsfhzByIds(List<String> ids) ;
    List<OrmXmsfhz> getOrmxmsfhzByEntities(List<OrmXmsfhz> entities) ;

}


