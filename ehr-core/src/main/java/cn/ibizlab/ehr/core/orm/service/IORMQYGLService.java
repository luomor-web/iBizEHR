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

import cn.ibizlab.ehr.core.orm.domain.ORMQYGL;
import cn.ibizlab.ehr.core.orm.filter.ORMQYGLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMQYGL] 服务对象接口
 */
public interface IORMQYGLService extends IService<ORMQYGL>{

    boolean update(ORMQYGL et) ;
    void updateBatch(List<ORMQYGL> list) ;
    ORMQYGL get(String key) ;
    boolean create(ORMQYGL et) ;
    void createBatch(List<ORMQYGL> list) ;
    ORMQYGL getDraft(ORMQYGL et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ORMQYGL et) ;
    void saveBatch(List<ORMQYGL> list) ;
    boolean checkKey(ORMQYGL et) ;
    Page<ORMQYGL> searchDefault(ORMQYGLSearchContext context) ;
    List<ORMQYGL> selectByOrmorgid(String orgid) ;
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

}


