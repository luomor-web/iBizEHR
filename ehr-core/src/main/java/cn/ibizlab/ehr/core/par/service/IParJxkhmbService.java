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

import cn.ibizlab.ehr.core.par.domain.ParJxkhmb;
import cn.ibizlab.ehr.core.par.filter.ParJxkhmbSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxkhmb] 服务对象接口
 */
public interface IParJxkhmbService extends IService<ParJxkhmb>{

    boolean checkKey(ParJxkhmb et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParJxkhmb get(String key) ;
    boolean create(ParJxkhmb et) ;
    void createBatch(List<ParJxkhmb> list) ;
    ParJxkhmb getDraft(ParJxkhmb et) ;
    boolean save(ParJxkhmb et) ;
    void saveBatch(List<ParJxkhmb> list) ;
    boolean update(ParJxkhmb et) ;
    void updateBatch(List<ParJxkhmb> list) ;
    Page<ParJxkhmb> searchDefault(ParJxkhmbSearchContext context) ;
    List<ParJxkhmb> selectByOrmorgid(String orgid) ;
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

    List<ParJxkhmb> getParjxkhmbByIds(List<String> ids) ;
    List<ParJxkhmb> getParjxkhmbByEntities(List<ParJxkhmb> entities) ;

}


