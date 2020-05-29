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

import cn.ibizlab.ehr.core.par.domain.ParJxkhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParJxkhmbmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxkhmbmx] 服务对象接口
 */
public interface IParJxkhmbmxService extends IService<ParJxkhmbmx>{

    boolean create(ParJxkhmbmx et) ;
    void createBatch(List<ParJxkhmbmx> list) ;
    boolean checkKey(ParJxkhmbmx et) ;
    ParJxkhmbmx getDraft(ParJxkhmbmx et) ;
    boolean update(ParJxkhmbmx et) ;
    void updateBatch(List<ParJxkhmbmx> list) ;
    ParJxkhmbmx get(String key) ;
    boolean save(ParJxkhmbmx et) ;
    void saveBatch(List<ParJxkhmbmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ParJxkhmbmx> searchDefault(ParJxkhmbmxSearchContext context) ;
    List<ParJxkhmbmx> selectByParjxkhmbid(String parjxkhmbid) ;
    void removeByParjxkhmbid(String parjxkhmbid) ;
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

    List<ParJxkhmbmx> getParjxkhmbmxByIds(List<String> ids) ;
    List<ParJxkhmbmx> getParjxkhmbmxByEntities(List<ParJxkhmbmx> entities) ;

}


