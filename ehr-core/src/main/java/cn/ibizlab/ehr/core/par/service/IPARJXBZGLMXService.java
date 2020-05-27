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

import cn.ibizlab.ehr.core.par.domain.PARJXBZGLMX;
import cn.ibizlab.ehr.core.par.filter.PARJXBZGLMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXBZGLMX] 服务对象接口
 */
public interface IPARJXBZGLMXService extends IService<PARJXBZGLMX>{

    boolean update(PARJXBZGLMX et) ;
    void updateBatch(List<PARJXBZGLMX> list) ;
    boolean save(PARJXBZGLMX et) ;
    void saveBatch(List<PARJXBZGLMX> list) ;
    PARJXBZGLMX get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PARJXBZGLMX et) ;
    void createBatch(List<PARJXBZGLMX> list) ;
    PARJXBZGLMX getDraft(PARJXBZGLMX et) ;
    boolean checkKey(PARJXBZGLMX et) ;
    Page<PARJXBZGLMX> searchDefault(PARJXBZGLMXSearchContext context) ;
    List<PARJXBZGLMX> selectByParjxbzglid(String parjxbzglid) ;
    void removeByParjxbzglid(String parjxbzglid) ;
    List<PARJXBZGLMX> selectByPimpersonid(String pimpersonid) ;
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

    List<PARJXBZGLMX> getParjxbzglmxByIds(List<String> ids) ;
    List<PARJXBZGLMX> getParjxbzglmxByEntities(List<PARJXBZGLMX> entities) ;

}


