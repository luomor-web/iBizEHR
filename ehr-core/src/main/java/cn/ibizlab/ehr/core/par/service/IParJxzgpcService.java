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

import cn.ibizlab.ehr.core.par.domain.ParJxzgpc;
import cn.ibizlab.ehr.core.par.filter.ParJxzgpcSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxzgpc] 服务对象接口
 */
public interface IParJxzgpcService extends IService<ParJxzgpc>{

    boolean create(ParJxzgpc et) ;
    void createBatch(List<ParJxzgpc> list) ;
    boolean save(ParJxzgpc et) ;
    void saveBatch(List<ParJxzgpc> list) ;
    ParJxzgpc getDraft(ParJxzgpc et) ;
    ParJxzgpc get(String key) ;
    boolean checkKey(ParJxzgpc et) ;
    boolean update(ParJxzgpc et) ;
    void updateBatch(List<ParJxzgpc> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ParJxzgpc> searchDefault(ParJxzgpcSearchContext context) ;
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

    List<ParJxzgpc> getParjxzgpcByIds(List<String> ids) ;
    List<ParJxzgpc> getParjxzgpcByEntities(List<ParJxzgpc> entities) ;

}


