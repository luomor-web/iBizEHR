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

import cn.ibizlab.ehr.core.orm.domain.ORMPostDetails;
import cn.ibizlab.ehr.core.orm.filter.ORMPostDetailsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMPostDetails] 服务对象接口
 */
public interface IORMPostDetailsService extends IService<ORMPostDetails>{

    boolean create(ORMPostDetails et) ;
    void createBatch(List<ORMPostDetails> list) ;
    ORMPostDetails get(String key) ;
    boolean checkKey(ORMPostDetails et) ;
    boolean update(ORMPostDetails et) ;
    void updateBatch(List<ORMPostDetails> list) ;
    ORMPostDetails getDraft(ORMPostDetails et) ;
    boolean save(ORMPostDetails et) ;
    void saveBatch(List<ORMPostDetails> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ORMPostDetails> searchDefault(ORMPostDetailsSearchContext context) ;
    List<ORMPostDetails> selectByOrmpostlibid(String ormpostlibid) ;
    void removeByOrmpostlibid(String ormpostlibid) ;
    List<ORMPostDetails> selectByOrmpostid(String ormpostid) ;
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

}


