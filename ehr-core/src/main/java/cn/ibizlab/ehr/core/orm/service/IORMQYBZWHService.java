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

import cn.ibizlab.ehr.core.orm.domain.ORMQYBZWH;
import cn.ibizlab.ehr.core.orm.filter.ORMQYBZWHSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMQYBZWH] 服务对象接口
 */
public interface IORMQYBZWHService extends IService<ORMQYBZWH>{

    boolean checkKey(ORMQYBZWH et) ;
    ORMQYBZWH get(String key) ;
    boolean save(ORMQYBZWH et) ;
    void saveBatch(List<ORMQYBZWH> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ORMQYBZWH et) ;
    void updateBatch(List<ORMQYBZWH> list) ;
    ORMQYBZWH getDraft(ORMQYBZWH et) ;
    boolean create(ORMQYBZWH et) ;
    void createBatch(List<ORMQYBZWH> list) ;
    Page<ORMQYBZWH> searchDefault(ORMQYBZWHSearchContext context) ;
    List<ORMQYBZWH> selectByOrmorgid(String orgid) ;
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

    List<ORMQYBZWH> getOrmqybzwhByIds(List<String> ids) ;
    List<ORMQYBZWH> getOrmqybzwhByEntities(List<ORMQYBZWH> entities) ;

}


