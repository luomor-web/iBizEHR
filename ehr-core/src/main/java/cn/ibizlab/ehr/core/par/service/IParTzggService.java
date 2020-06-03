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

import cn.ibizlab.ehr.core.par.domain.ParTzgg;
import cn.ibizlab.ehr.core.par.filter.ParTzggSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParTzgg] 服务对象接口
 */
public interface IParTzggService extends IService<ParTzgg>{

    ParTzgg getDraft(ParTzgg et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParTzgg et) ;
    void saveBatch(List<ParTzgg> list) ;
    boolean create(ParTzgg et) ;
    void createBatch(List<ParTzgg> list) ;
    ParTzgg get(String key) ;
    boolean checkKey(ParTzgg et) ;
    boolean update(ParTzgg et) ;
    void updateBatch(List<ParTzgg> list) ;
    Page<ParTzgg> searchDefault(ParTzggSearchContext context) ;
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

    List<ParTzgg> getPartzggByIds(List<String> ids) ;
    List<ParTzgg> getPartzggByEntities(List<ParTzgg> entities) ;

}


