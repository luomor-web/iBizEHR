package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SalSource;
import cn.ibizlab.ehr.core.sal.filter.SalSourceSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalSource] 服务对象接口
 */
public interface ISalSourceService extends IService<SalSource>{

    SalSource get(String key) ;
    boolean save(SalSource et) ;
    void saveBatch(List<SalSource> list) ;
    boolean update(SalSource et) ;
    void updateBatch(List<SalSource> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SalSource et) ;
    void createBatch(List<SalSource> list) ;
    boolean checkKey(SalSource et) ;
    SalSource getDraft(SalSource et) ;
    Page<SalSource> searchDefault(SalSourceSearchContext context) ;
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

    List<SalSource> getSalsourceByIds(List<String> ids) ;
    List<SalSource> getSalsourceByEntities(List<SalSource> entities) ;

}


