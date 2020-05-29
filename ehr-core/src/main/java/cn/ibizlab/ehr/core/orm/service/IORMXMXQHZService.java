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

import cn.ibizlab.ehr.core.orm.domain.ORMXMXQHZ;
import cn.ibizlab.ehr.core.orm.filter.ORMXMXQHZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMXQHZ] 服务对象接口
 */
public interface IORMXMXQHZService extends IService<ORMXMXQHZ>{

    boolean update(ORMXMXQHZ et) ;
    void updateBatch(List<ORMXMXQHZ> list) ;
    boolean save(ORMXMXQHZ et) ;
    void saveBatch(List<ORMXMXQHZ> list) ;
    ORMXMXQHZ getDraft(ORMXMXQHZ et) ;
    boolean checkKey(ORMXMXQHZ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMXMXQHZ get(String key) ;
    boolean create(ORMXMXQHZ et) ;
    void createBatch(List<ORMXMXQHZ> list) ;
    Page<ORMXMXQHZ> searchXMRYQKMX(ORMXMXQHZSearchContext context) ;
    Page<ORMXMXQHZ> searchDefault(ORMXMXQHZSearchContext context) ;
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

    List<ORMXMXQHZ> getOrmxmxqhzByIds(List<String> ids) ;
    List<ORMXMXQHZ> getOrmxmxqhzByEntities(List<ORMXMXQHZ> entities) ;

}


