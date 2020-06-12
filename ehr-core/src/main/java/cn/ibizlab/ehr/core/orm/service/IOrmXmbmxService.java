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

import cn.ibizlab.ehr.core.orm.domain.OrmXmbmx;
import cn.ibizlab.ehr.core.orm.filter.OrmXmbmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmXmbmx] 服务对象接口
 */
public interface IOrmXmbmxService extends IService<OrmXmbmx>{

    boolean save(OrmXmbmx et) ;
    void saveBatch(List<OrmXmbmx> list) ;
    OrmXmbmx getDraft(OrmXmbmx et) ;
    boolean update(OrmXmbmx et) ;
    void updateBatch(List<OrmXmbmx> list) ;
    OrmXmbmx get(String key) ;
    boolean checkKey(OrmXmbmx et) ;
    boolean create(OrmXmbmx et) ;
    void createBatch(List<OrmXmbmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<OrmXmbmx> searchDefault(OrmXmbmxSearchContext context) ;
    List<OrmXmbmx> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<OrmXmbmx> selectByPimpersonid(String pimpersonid) ;
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

    List<OrmXmbmx> getOrmxmbmxByIds(List<String> ids) ;
    List<OrmXmbmx> getOrmxmbmxByEntities(List<OrmXmbmx> entities) ;

}


