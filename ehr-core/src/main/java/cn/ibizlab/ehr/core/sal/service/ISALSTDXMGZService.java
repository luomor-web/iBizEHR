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

import cn.ibizlab.ehr.core.sal.domain.SALSTDXMGZ;
import cn.ibizlab.ehr.core.sal.filter.SALSTDXMGZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSTDXMGZ] 服务对象接口
 */
public interface ISALSTDXMGZService extends IService<SALSTDXMGZ>{

    boolean checkKey(SALSTDXMGZ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(SALSTDXMGZ et) ;
    void updateBatch(List<SALSTDXMGZ> list) ;
    SALSTDXMGZ getDraft(SALSTDXMGZ et) ;
    boolean save(SALSTDXMGZ et) ;
    void saveBatch(List<SALSTDXMGZ> list) ;
    SALSTDXMGZ get(String key) ;
    boolean create(SALSTDXMGZ et) ;
    void createBatch(List<SALSTDXMGZ> list) ;
    Page<SALSTDXMGZ> searchDefault(SALSTDXMGZSearchContext context) ;
    List<SALSTDXMGZ> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SALSTDXMGZ> selectByOrmorgid(String orgid) ;
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

    List<SALSTDXMGZ> getSalstdxmgzByIds(List<String> ids) ;
    List<SALSTDXMGZ> getSalstdxmgzByEntities(List<SALSTDXMGZ> entities) ;

}


