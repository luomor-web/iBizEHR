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

import cn.ibizlab.ehr.core.orm.domain.OrmQygl;
import cn.ibizlab.ehr.core.orm.filter.OrmQyglSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmQygl] 服务对象接口
 */
public interface IOrmQyglService extends IService<OrmQygl>{

    boolean update(OrmQygl et) ;
    void updateBatch(List<OrmQygl> list) ;
    OrmQygl get(String key) ;
    boolean create(OrmQygl et) ;
    void createBatch(List<OrmQygl> list) ;
    OrmQygl getDraft(OrmQygl et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(OrmQygl et) ;
    void saveBatch(List<OrmQygl> list) ;
    boolean checkKey(OrmQygl et) ;
    Page<OrmQygl> searchDefault(OrmQyglSearchContext context) ;
    List<OrmQygl> selectByOrmorgid(String orgid) ;
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

    List<OrmQygl> getOrmqyglByIds(List<String> ids) ;
    List<OrmQygl> getOrmqyglByEntities(List<OrmQygl> entities) ;

}


