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

import cn.ibizlab.ehr.core.par.domain.ParKhfa;
import cn.ibizlab.ehr.core.par.filter.ParKhfaSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParKhfa] 服务对象接口
 */
public interface IParKhfaService extends IService<ParKhfa>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParKhfa et) ;
    void saveBatch(List<ParKhfa> list) ;
    boolean create(ParKhfa et) ;
    void createBatch(List<ParKhfa> list) ;
    boolean checkKey(ParKhfa et) ;
    ParKhfa getDraft(ParKhfa et) ;
    ParKhfa get(String key) ;
    boolean update(ParKhfa et) ;
    void updateBatch(List<ParKhfa> list) ;
    Page<ParKhfa> searchDefault(ParKhfaSearchContext context) ;
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

    List<ParKhfa> getParkhfaByIds(List<String> ids) ;
    List<ParKhfa> getParkhfaByEntities(List<ParKhfa> entities) ;

}


