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

import cn.ibizlab.ehr.core.orm.domain.ORMXMSFHZ;
import cn.ibizlab.ehr.core.orm.filter.ORMXMSFHZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMSFHZ] 服务对象接口
 */
public interface IORMXMSFHZService extends IService<ORMXMSFHZ>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ORMXMSFHZ et) ;
    void createBatch(List<ORMXMSFHZ> list) ;
    boolean update(ORMXMSFHZ et) ;
    void updateBatch(List<ORMXMSFHZ> list) ;
    ORMXMSFHZ getDraft(ORMXMSFHZ et) ;
    boolean checkKey(ORMXMSFHZ et) ;
    ORMXMSFHZ get(String key) ;
    boolean save(ORMXMSFHZ et) ;
    void saveBatch(List<ORMXMSFHZ> list) ;
    Page<ORMXMSFHZ> searchAccOrg(ORMXMSFHZSearchContext context) ;
    Page<ORMXMSFHZ> searchDefault(ORMXMSFHZSearchContext context) ;
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

    List<ORMXMSFHZ> getOrmxmsfhzByIds(List<String> ids) ;
    List<ORMXMSFHZ> getOrmxmsfhzByEntities(List<ORMXMSFHZ> entities) ;

}


