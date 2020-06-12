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

import cn.ibizlab.ehr.core.sal.domain.SalSubject;
import cn.ibizlab.ehr.core.sal.filter.SalSubjectSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalSubject] 服务对象接口
 */
public interface ISalSubjectService extends IService<SalSubject>{

    SalSubject getDraft(SalSubject et) ;
    boolean save(SalSubject et) ;
    void saveBatch(List<SalSubject> list) ;
    boolean checkKey(SalSubject et) ;
    boolean update(SalSubject et) ;
    void updateBatch(List<SalSubject> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalSubject get(String key) ;
    boolean create(SalSubject et) ;
    void createBatch(List<SalSubject> list) ;
    Page<SalSubject> searchDefault(SalSubjectSearchContext context) ;
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

    List<SalSubject> getSalsubjectByIds(List<String> ids) ;
    List<SalSubject> getSalsubjectByEntities(List<SalSubject> entities) ;

}


