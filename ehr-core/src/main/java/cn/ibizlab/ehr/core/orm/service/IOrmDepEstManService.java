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

import cn.ibizlab.ehr.core.orm.domain.OrmDepEstMan;
import cn.ibizlab.ehr.core.orm.filter.OrmDepEstManSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmDepEstMan] 服务对象接口
 */
public interface IOrmDepEstManService extends IService<OrmDepEstMan>{

    OrmDepEstMan getDraft(OrmDepEstMan et) ;
    boolean checkKey(OrmDepEstMan et) ;
    boolean create(OrmDepEstMan et) ;
    void createBatch(List<OrmDepEstMan> list) ;
    OrmDepEstMan get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(OrmDepEstMan et) ;
    void updateBatch(List<OrmDepEstMan> list) ;
    boolean save(OrmDepEstMan et) ;
    void saveBatch(List<OrmDepEstMan> list) ;
    Page<OrmDepEstMan> searchDefault(OrmDepEstManSearchContext context) ;
    List<OrmDepEstMan> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<OrmDepEstMan> selectByOrmzwbzid(String orgsectorid) ;
    void removeByOrmzwbzid(String orgsectorid) ;
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

    List<OrmDepEstMan> getOrmdepestmanByIds(List<String> ids) ;
    List<OrmDepEstMan> getOrmdepestmanByEntities(List<OrmDepEstMan> entities) ;

}


