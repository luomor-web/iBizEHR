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

import cn.ibizlab.ehr.core.par.domain.ParPtryndlhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParPtryndlhmbmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParPtryndlhmbmx] 服务对象接口
 */
public interface IParPtryndlhmbmxService extends IService<ParPtryndlhmbmx>{

    ParPtryndlhmbmx getDraft(ParPtryndlhmbmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ParPtryndlhmbmx et) ;
    ParPtryndlhmbmx get(String key) ;
    boolean save(ParPtryndlhmbmx et) ;
    void saveBatch(List<ParPtryndlhmbmx> list) ;
    boolean update(ParPtryndlhmbmx et) ;
    void updateBatch(List<ParPtryndlhmbmx> list) ;
    boolean create(ParPtryndlhmbmx et) ;
    void createBatch(List<ParPtryndlhmbmx> list) ;
    Page<ParPtryndlhmbmx> searchDefault(ParPtryndlhmbmxSearchContext context) ;
    List<ParPtryndlhmbmx> selectByParptryndlhmbid(String parptryndlhmbid) ;
    void removeByParptryndlhmbid(String parptryndlhmbid) ;
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

    List<ParPtryndlhmbmx> getParptryndlhmbmxByIds(List<String> ids) ;
    List<ParPtryndlhmbmx> getParptryndlhmbmxByEntities(List<ParPtryndlhmbmx> entities) ;

}


