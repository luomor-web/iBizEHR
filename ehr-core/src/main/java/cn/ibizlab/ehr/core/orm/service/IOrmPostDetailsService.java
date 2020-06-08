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

import cn.ibizlab.ehr.core.orm.domain.OrmPostDetails;
import cn.ibizlab.ehr.core.orm.filter.OrmPostDetailsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmPostDetails] 服务对象接口
 */
public interface IOrmPostDetailsService extends IService<OrmPostDetails>{

    boolean create(OrmPostDetails et) ;
    void createBatch(List<OrmPostDetails> list) ;
    OrmPostDetails get(String key) ;
    boolean checkKey(OrmPostDetails et) ;
    boolean update(OrmPostDetails et) ;
    void updateBatch(List<OrmPostDetails> list) ;
    OrmPostDetails getDraft(OrmPostDetails et) ;
    boolean save(OrmPostDetails et) ;
    void saveBatch(List<OrmPostDetails> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<OrmPostDetails> searchDefault(OrmPostDetailsSearchContext context) ;
    List<OrmPostDetails> selectByOrmpostlibid(String ormpostlibid) ;
    void removeByOrmpostlibid(String ormpostlibid) ;
    List<OrmPostDetails> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
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

    List<OrmPostDetails> getOrmpostdetailsByIds(List<String> ids) ;
    List<OrmPostDetails> getOrmpostdetailsByEntities(List<OrmPostDetails> entities) ;

}


