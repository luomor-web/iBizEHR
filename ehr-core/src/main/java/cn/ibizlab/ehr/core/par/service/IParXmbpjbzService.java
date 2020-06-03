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

import cn.ibizlab.ehr.core.par.domain.ParXmbpjbz;
import cn.ibizlab.ehr.core.par.filter.ParXmbpjbzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParXmbpjbz] 服务对象接口
 */
public interface IParXmbpjbzService extends IService<ParXmbpjbz>{

    ParXmbpjbz get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ParXmbpjbz et) ;
    boolean update(ParXmbpjbz et) ;
    void updateBatch(List<ParXmbpjbz> list) ;
    boolean create(ParXmbpjbz et) ;
    void createBatch(List<ParXmbpjbz> list) ;
    boolean save(ParXmbpjbz et) ;
    void saveBatch(List<ParXmbpjbz> list) ;
    ParXmbpjbz getDraft(ParXmbpjbz et) ;
    Page<ParXmbpjbz> searchDefault(ParXmbpjbzSearchContext context) ;
    List<ParXmbpjbz> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<ParXmbpjbz> selectByXmbpjbzid(String parxmbpjbzid) ;
    void removeByXmbpjbzid(String parxmbpjbzid) ;
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

    List<ParXmbpjbz> getParxmbpjbzByIds(List<String> ids) ;
    List<ParXmbpjbz> getParxmbpjbzByEntities(List<ParXmbpjbz> entities) ;

}


