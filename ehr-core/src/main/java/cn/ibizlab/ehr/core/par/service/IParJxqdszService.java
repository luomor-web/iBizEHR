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

import cn.ibizlab.ehr.core.par.domain.ParJxqdsz;
import cn.ibizlab.ehr.core.par.filter.ParJxqdszSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxqdsz] 服务对象接口
 */
public interface IParJxqdszService extends IService<ParJxqdsz>{

    boolean update(ParJxqdsz et) ;
    void updateBatch(List<ParJxqdsz> list) ;
    ParJxqdsz get(String key) ;
    boolean save(ParJxqdsz et) ;
    void saveBatch(List<ParJxqdsz> list) ;
    boolean checkKey(ParJxqdsz et) ;
    ParJxqdsz getDraft(ParJxqdsz et) ;
    boolean create(ParJxqdsz et) ;
    void createBatch(List<ParJxqdsz> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ParJxqdsz> searchDefault(ParJxqdszSearchContext context) ;
    List<ParJxqdsz> selectByOrmorgid(String orgid) ;
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

    List<ParJxqdsz> getParjxqdszByIds(List<String> ids) ;
    List<ParJxqdsz> getParjxqdszByEntities(List<ParJxqdsz> entities) ;

}


