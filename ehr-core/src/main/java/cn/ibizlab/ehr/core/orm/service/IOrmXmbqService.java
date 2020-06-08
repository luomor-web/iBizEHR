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

import cn.ibizlab.ehr.core.orm.domain.OrmXmbq;
import cn.ibizlab.ehr.core.orm.filter.OrmXmbqSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmXmbq] 服务对象接口
 */
public interface IOrmXmbqService extends IService<OrmXmbq>{

    OrmXmbq get(String key) ;
    boolean create(OrmXmbq et) ;
    void createBatch(List<OrmXmbq> list) ;
    boolean save(OrmXmbq et) ;
    void saveBatch(List<OrmXmbq> list) ;
    boolean checkKey(OrmXmbq et) ;
    OrmXmbq getDraft(OrmXmbq et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(OrmXmbq et) ;
    void updateBatch(List<OrmXmbq> list) ;
    Page<OrmXmbq> searchDefault(OrmXmbqSearchContext context) ;
    List<OrmXmbq> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<OrmXmbq> getOrmxmbqByIds(List<String> ids) ;
    List<OrmXmbq> getOrmxmbqByEntities(List<OrmXmbq> entities) ;

}


