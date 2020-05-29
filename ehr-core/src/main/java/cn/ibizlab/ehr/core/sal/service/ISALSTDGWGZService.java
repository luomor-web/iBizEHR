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

import cn.ibizlab.ehr.core.sal.domain.SALSTDGWGZ;
import cn.ibizlab.ehr.core.sal.filter.SALSTDGWGZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSTDGWGZ] 服务对象接口
 */
public interface ISALSTDGWGZService extends IService<SALSTDGWGZ>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SALSTDGWGZ et) ;
    void saveBatch(List<SALSTDGWGZ> list) ;
    boolean create(SALSTDGWGZ et) ;
    void createBatch(List<SALSTDGWGZ> list) ;
    SALSTDGWGZ get(String key) ;
    boolean checkKey(SALSTDGWGZ et) ;
    boolean update(SALSTDGWGZ et) ;
    void updateBatch(List<SALSTDGWGZ> list) ;
    SALSTDGWGZ getDraft(SALSTDGWGZ et) ;
    Page<SALSTDGWGZ> searchDefault(SALSTDGWGZSearchContext context) ;
    List<SALSTDGWGZ> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SALSTDGWGZ> selectByOrmorgid(String orgid) ;
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

    List<SALSTDGWGZ> getSalstdgwgzByIds(List<String> ids) ;
    List<SALSTDGWGZ> getSalstdgwgzByEntities(List<SALSTDGWGZ> entities) ;

}


