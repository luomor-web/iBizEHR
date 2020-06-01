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

import cn.ibizlab.ehr.core.orm.domain.OrmXmgl;
import cn.ibizlab.ehr.core.orm.filter.OrmXmglSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmXmgl] 服务对象接口
 */
public interface IOrmXmglService extends IService<OrmXmgl>{

    OrmXmgl get(String key) ;
    boolean checkKey(OrmXmgl et) ;
    OrmXmgl getDraft(OrmXmgl et) ;
    boolean update(OrmXmgl et) ;
    void updateBatch(List<OrmXmgl> list) ;
    boolean create(OrmXmgl et) ;
    void createBatch(List<OrmXmgl> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmXmgl synchro(OrmXmgl et) ;
    boolean save(OrmXmgl et) ;
    void saveBatch(List<OrmXmgl> list) ;
    Page<OrmXmgl> searchDefault(OrmXmglSearchContext context) ;
    Page<OrmXmgl> searchValidPro(OrmXmglSearchContext context) ;
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

    List<OrmXmgl> getOrmxmglByIds(List<String> ids) ;
    List<OrmXmgl> getOrmxmglByEntities(List<OrmXmgl> entities) ;

}


