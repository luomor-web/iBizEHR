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

import cn.ibizlab.ehr.core.par.domain.ParJgbmpjbz;
import cn.ibizlab.ehr.core.par.filter.ParJgbmpjbzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJgbmpjbz] 服务对象接口
 */
public interface IParJgbmpjbzService extends IService<ParJgbmpjbz>{

    boolean checkKey(ParJgbmpjbz et) ;
    ParJgbmpjbz get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ParJgbmpjbz et) ;
    void createBatch(List<ParJgbmpjbz> list) ;
    boolean update(ParJgbmpjbz et) ;
    void updateBatch(List<ParJgbmpjbz> list) ;
    boolean save(ParJgbmpjbz et) ;
    void saveBatch(List<ParJgbmpjbz> list) ;
    ParJgbmpjbz getDraft(ParJgbmpjbz et) ;
    Page<ParJgbmpjbz> searchDefault(ParJgbmpjbzSearchContext context) ;
    List<ParJgbmpjbz> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<ParJgbmpjbz> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<ParJgbmpjbz> selectByPjbzid(String parjgbmpjbzid) ;
    void removeByPjbzid(String parjgbmpjbzid) ;
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

    List<ParJgbmpjbz> getParjgbmpjbzByIds(List<String> ids) ;
    List<ParJgbmpjbz> getParjgbmpjbzByEntities(List<ParJgbmpjbz> entities) ;

}


