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

import cn.ibizlab.ehr.core.orm.domain.ORMXMXQJH;
import cn.ibizlab.ehr.core.orm.filter.ORMXMXQJHSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMXQJH] 服务对象接口
 */
public interface IORMXMXQJHService extends IService<ORMXMXQJH>{

    ORMXMXQJH get(String key) ;
    ORMXMXQJH getDraft(ORMXMXQJH et) ;
    boolean save(ORMXMXQJH et) ;
    void saveBatch(List<ORMXMXQJH> list) ;
    ORMXMXQJH tJ(ORMXMXQJH et) ;
    ORMXMXQJH cLWC(ORMXMXQJH et) ;
    boolean update(ORMXMXQJH et) ;
    void updateBatch(List<ORMXMXQJH> list) ;
    boolean create(ORMXMXQJH et) ;
    void createBatch(List<ORMXMXQJH> list) ;
    ORMXMXQJH sHBTG(ORMXMXQJH et) ;
    boolean checkKey(ORMXMXQJH et) ;
    ORMXMXQJH ensure(ORMXMXQJH et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ORMXMXQJH> searchBaseInfo(ORMXMXQJHSearchContext context) ;
    Page<ORMXMXQJH> searchXMTJQX(ORMXMXQJHSearchContext context) ;
    Page<ORMXMXQJH> searchDefault(ORMXMXQJHSearchContext context) ;
    Page<ORMXMXQJH> searchRsshInfo(ORMXMXQJHSearchContext context) ;
    List<ORMXMXQJH> selectByOrmxmglid(String ormxmglid) ;
    void removeByOrmxmglid(String ormxmglid) ;
    List<ORMXMXQJH> selectByPimpersonid(String pimpersonid) ;
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

    List<ORMXMXQJH> getOrmxmxqjhByIds(List<String> ids) ;
    List<ORMXMXQJH> getOrmxmxqjhByEntities(List<ORMXMXQJH> entities) ;

}


