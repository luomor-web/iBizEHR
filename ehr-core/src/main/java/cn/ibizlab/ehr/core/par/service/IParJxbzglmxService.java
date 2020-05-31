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

import cn.ibizlab.ehr.core.par.domain.ParJxbzglmx;
import cn.ibizlab.ehr.core.par.filter.ParJxbzglmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxbzglmx] 服务对象接口
 */
public interface IParJxbzglmxService extends IService<ParJxbzglmx>{

    boolean update(ParJxbzglmx et) ;
    void updateBatch(List<ParJxbzglmx> list) ;
    boolean save(ParJxbzglmx et) ;
    void saveBatch(List<ParJxbzglmx> list) ;
    ParJxbzglmx get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ParJxbzglmx et) ;
    void createBatch(List<ParJxbzglmx> list) ;
    ParJxbzglmx getDraft(ParJxbzglmx et) ;
    boolean checkKey(ParJxbzglmx et) ;
    Page<ParJxbzglmx> searchDefault(ParJxbzglmxSearchContext context) ;
    List<ParJxbzglmx> selectByParjxbzglid(String parjxbzglid) ;
    void removeByParjxbzglid(String parjxbzglid) ;
    List<ParJxbzglmx> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<ParJxbzglmx> getParjxbzglmxByIds(List<String> ids) ;
    List<ParJxbzglmx> getParjxbzglmxByEntities(List<ParJxbzglmx> entities) ;

}


