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

import cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh;
import cn.ibizlab.ehr.core.orm.filter.OrmXmxqjhSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmXmxqjh] 服务对象接口
 */
public interface IOrmXmxqjhService extends IService<OrmXmxqjh>{

    OrmXmxqjh get(String key) ;
    OrmXmxqjh getDraft(OrmXmxqjh et) ;
    boolean save(OrmXmxqjh et) ;
    void saveBatch(List<OrmXmxqjh> list) ;
    OrmXmxqjh tJ(OrmXmxqjh et) ;
    OrmXmxqjh cLWC(OrmXmxqjh et) ;
    boolean update(OrmXmxqjh et) ;
    void updateBatch(List<OrmXmxqjh> list) ;
    boolean create(OrmXmxqjh et) ;
    void createBatch(List<OrmXmxqjh> list) ;
    OrmXmxqjh sHBTG(OrmXmxqjh et) ;
    boolean checkKey(OrmXmxqjh et) ;
    OrmXmxqjh ensure(OrmXmxqjh et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<OrmXmxqjh> searchBaseInfo(OrmXmxqjhSearchContext context) ;
    Page<OrmXmxqjh> searchXMTJQX(OrmXmxqjhSearchContext context) ;
    Page<OrmXmxqjh> searchDefault(OrmXmxqjhSearchContext context) ;
    Page<OrmXmxqjh> searchRsshInfo(OrmXmxqjhSearchContext context) ;
    List<OrmXmxqjh> selectByOrmxmglid(String ormxmglid) ;
    void removeByOrmxmglid(String ormxmglid) ;
    List<OrmXmxqjh> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<OrmXmxqjh> getOrmxmxqjhByIds(List<String> ids) ;
    List<OrmXmxqjh> getOrmxmxqjhByEntities(List<OrmXmxqjh> entities) ;

}


