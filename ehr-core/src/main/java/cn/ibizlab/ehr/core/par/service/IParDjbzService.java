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

import cn.ibizlab.ehr.core.par.domain.ParDjbz;
import cn.ibizlab.ehr.core.par.filter.ParDjbzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParDjbz] 服务对象接口
 */
public interface IParDjbzService extends IService<ParDjbz>{

    boolean create(ParDjbz et) ;
    void createBatch(List<ParDjbz> list) ;
    ParDjbz get(String key) ;
    boolean save(ParDjbz et) ;
    void saveBatch(List<ParDjbz> list) ;
    ParDjbz getDraft(ParDjbz et) ;
    boolean update(ParDjbz et) ;
    void updateBatch(List<ParDjbz> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ParDjbz et) ;
    Page<ParDjbz> searchDefault(ParDjbzSearchContext context) ;
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

    List<ParDjbz> getPardjbzByIds(List<String> ids) ;
    List<ParDjbz> getPardjbzByEntities(List<ParDjbz> entities) ;

}


