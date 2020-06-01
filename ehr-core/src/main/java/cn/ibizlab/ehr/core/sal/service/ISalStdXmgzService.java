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

import cn.ibizlab.ehr.core.sal.domain.SalStdXmgz;
import cn.ibizlab.ehr.core.sal.filter.SalStdXmgzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdXmgz] 服务对象接口
 */
public interface ISalStdXmgzService extends IService<SalStdXmgz>{

    boolean checkKey(SalStdXmgz et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(SalStdXmgz et) ;
    void updateBatch(List<SalStdXmgz> list) ;
    SalStdXmgz getDraft(SalStdXmgz et) ;
    boolean save(SalStdXmgz et) ;
    void saveBatch(List<SalStdXmgz> list) ;
    SalStdXmgz get(String key) ;
    boolean create(SalStdXmgz et) ;
    void createBatch(List<SalStdXmgz> list) ;
    Page<SalStdXmgz> searchDefault(SalStdXmgzSearchContext context) ;
    List<SalStdXmgz> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SalStdXmgz> selectByOrmorgid(String orgid) ;
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

    List<SalStdXmgz> getSalstdxmgzByIds(List<String> ids) ;
    List<SalStdXmgz> getSalstdxmgzByEntities(List<SalStdXmgz> entities) ;

}


