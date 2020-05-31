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

import cn.ibizlab.ehr.core.orm.domain.OrmXmxqhz;
import cn.ibizlab.ehr.core.orm.filter.OrmXmxqhzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmXmxqhz] 服务对象接口
 */
public interface IOrmXmxqhzService extends IService<OrmXmxqhz>{

    boolean update(OrmXmxqhz et) ;
    void updateBatch(List<OrmXmxqhz> list) ;
    boolean save(OrmXmxqhz et) ;
    void saveBatch(List<OrmXmxqhz> list) ;
    OrmXmxqhz getDraft(OrmXmxqhz et) ;
    boolean checkKey(OrmXmxqhz et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmXmxqhz get(String key) ;
    boolean create(OrmXmxqhz et) ;
    void createBatch(List<OrmXmxqhz> list) ;
    Page<OrmXmxqhz> searchXMRYQKMX(OrmXmxqhzSearchContext context) ;
    Page<OrmXmxqhz> searchDefault(OrmXmxqhzSearchContext context) ;
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

    List<OrmXmxqhz> getOrmxmxqhzByIds(List<String> ids) ;
    List<OrmXmxqhz> getOrmxmxqhzByEntities(List<OrmXmxqhz> entities) ;

}


