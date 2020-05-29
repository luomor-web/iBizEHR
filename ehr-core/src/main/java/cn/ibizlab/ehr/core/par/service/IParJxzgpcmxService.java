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

import cn.ibizlab.ehr.core.par.domain.ParJxzgpcmx;
import cn.ibizlab.ehr.core.par.filter.ParJxzgpcmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxzgpcmx] 服务对象接口
 */
public interface IParJxzgpcmxService extends IService<ParJxzgpcmx>{

    ParJxzgpcmx getDraft(ParJxzgpcmx et) ;
    boolean update(ParJxzgpcmx et) ;
    void updateBatch(List<ParJxzgpcmx> list) ;
    boolean save(ParJxzgpcmx et) ;
    void saveBatch(List<ParJxzgpcmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ParJxzgpcmx et) ;
    void createBatch(List<ParJxzgpcmx> list) ;
    ParJxzgpcmx get(String key) ;
    boolean checkKey(ParJxzgpcmx et) ;
    Page<ParJxzgpcmx> searchDefault(ParJxzgpcmxSearchContext context) ;
    List<ParJxzgpcmx> selectByParjxzgpcid(String parjxzgpcid) ;
    void removeByParjxzgpcid(String parjxzgpcid) ;
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

    List<ParJxzgpcmx> getParjxzgpcmxByIds(List<String> ids) ;
    List<ParJxzgpcmx> getParjxzgpcmxByEntities(List<ParJxzgpcmx> entities) ;

}


