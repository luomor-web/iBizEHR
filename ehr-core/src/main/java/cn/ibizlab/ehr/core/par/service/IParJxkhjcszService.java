package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParJxkhjcsz;
import cn.ibizlab.ehr.core.par.filter.ParJxkhjcszSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxkhjcsz] 服务对象接口
 */
public interface IParJxkhjcszService extends IService<ParJxkhjcsz>{

    boolean update(ParJxkhjcsz et) ;
    void updateBatch(List<ParJxkhjcsz> list) ;
    ParJxkhjcsz getDraft(ParJxkhjcsz et) ;
    boolean checkKey(ParJxkhjcsz et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParJxkhjcsz et) ;
    void saveBatch(List<ParJxkhjcsz> list) ;
    boolean create(ParJxkhjcsz et) ;
    void createBatch(List<ParJxkhjcsz> list) ;
    ParJxkhjcsz get(String key) ;
    Page<ParJxkhjcsz> searchDefault(ParJxkhjcszSearchContext context) ;
    List<ParJxkhjcsz> selectByOrmorgid(String orgid) ;
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

    List<ParJxkhjcsz> getParjxkhjcszByIds(List<String> ids) ;
    List<ParJxkhjcsz> getParjxkhjcszByEntities(List<ParJxkhjcsz> entities) ;

}


