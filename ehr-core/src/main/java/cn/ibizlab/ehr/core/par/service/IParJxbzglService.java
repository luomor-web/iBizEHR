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

import cn.ibizlab.ehr.core.par.domain.ParJxbzgl;
import cn.ibizlab.ehr.core.par.filter.ParJxbzglSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxbzgl] 服务对象接口
 */
public interface IParJxbzglService extends IService<ParJxbzgl>{

    ParJxbzgl get(String key) ;
    ParJxbzgl getDraft(ParJxbzgl et) ;
    boolean save(ParJxbzgl et) ;
    void saveBatch(List<ParJxbzgl> list) ;
    boolean create(ParJxbzgl et) ;
    void createBatch(List<ParJxbzgl> list) ;
    boolean update(ParJxbzgl et) ;
    void updateBatch(List<ParJxbzgl> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ParJxbzgl et) ;
    Page<ParJxbzgl> searchDefault(ParJxbzglSearchContext context) ;
    List<ParJxbzgl> selectByOrmorgid(String orgid) ;
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

    List<ParJxbzgl> getParjxbzglByIds(List<String> ids) ;
    List<ParJxbzgl> getParjxbzglByEntities(List<ParJxbzgl> entities) ;

}


