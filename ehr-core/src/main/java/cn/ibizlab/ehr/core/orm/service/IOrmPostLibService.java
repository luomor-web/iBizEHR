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

import cn.ibizlab.ehr.core.orm.domain.OrmPostLib;
import cn.ibizlab.ehr.core.orm.filter.OrmPostLibSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmPostLib] 服务对象接口
 */
public interface IOrmPostLibService extends IService<OrmPostLib>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(OrmPostLib et) ;
    void saveBatch(List<OrmPostLib> list) ;
    boolean update(OrmPostLib et) ;
    void updateBatch(List<OrmPostLib> list) ;
    boolean create(OrmPostLib et) ;
    void createBatch(List<OrmPostLib> list) ;
    OrmPostLib getDraft(OrmPostLib et) ;
    OrmPostLib get(String key) ;
    boolean checkKey(OrmPostLib et) ;
    Page<OrmPostLib> searchDefault(OrmPostLibSearchContext context) ;
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

    List<OrmPostLib> getOrmpostlibByIds(List<String> ids) ;
    List<OrmPostLib> getOrmpostlibByEntities(List<OrmPostLib> entities) ;

}


