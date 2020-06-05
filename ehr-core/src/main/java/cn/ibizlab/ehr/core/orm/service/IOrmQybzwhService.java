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

import cn.ibizlab.ehr.core.orm.domain.OrmQybzwh;
import cn.ibizlab.ehr.core.orm.filter.OrmQybzwhSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmQybzwh] 服务对象接口
 */
public interface IOrmQybzwhService extends IService<OrmQybzwh>{

    boolean checkKey(OrmQybzwh et) ;
    OrmQybzwh get(String key) ;
    boolean save(OrmQybzwh et) ;
    void saveBatch(List<OrmQybzwh> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(OrmQybzwh et) ;
    void updateBatch(List<OrmQybzwh> list) ;
    OrmQybzwh getDraft(OrmQybzwh et) ;
    boolean create(OrmQybzwh et) ;
    void createBatch(List<OrmQybzwh> list) ;
    Page<OrmQybzwh> searchDefault(OrmQybzwhSearchContext context) ;
    List<OrmQybzwh> selectByOrmorgid(String orgid) ;
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

    List<OrmQybzwh> getOrmqybzwhByIds(List<String> ids) ;
    List<OrmQybzwh> getOrmqybzwhByEntities(List<OrmQybzwh> entities) ;

}


