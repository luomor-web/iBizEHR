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

import cn.ibizlab.ehr.core.sal.domain.SalStdgwgz;
import cn.ibizlab.ehr.core.sal.filter.SalStdgwgzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdgwgz] 服务对象接口
 */
public interface ISalStdgwgzService extends IService<SalStdgwgz>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SalStdgwgz et) ;
    void saveBatch(List<SalStdgwgz> list) ;
    boolean create(SalStdgwgz et) ;
    void createBatch(List<SalStdgwgz> list) ;
    SalStdgwgz get(String key) ;
    boolean checkKey(SalStdgwgz et) ;
    boolean update(SalStdgwgz et) ;
    void updateBatch(List<SalStdgwgz> list) ;
    SalStdgwgz getDraft(SalStdgwgz et) ;
    Page<SalStdgwgz> searchDefault(SalStdgwgzSearchContext context) ;
    List<SalStdgwgz> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SalStdgwgz> selectByOrmorgid(String orgid) ;
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

    List<SalStdgwgz> getSalstdgwgzByIds(List<String> ids) ;
    List<SalStdgwgz> getSalstdgwgzByEntities(List<SalStdgwgz> entities) ;

}


