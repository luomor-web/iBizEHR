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

import cn.ibizlab.ehr.core.par.domain.ParJxjg;
import cn.ibizlab.ehr.core.par.filter.ParJxjgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxjg] 服务对象接口
 */
public interface IParJxjgService extends IService<ParJxjg>{

    ParJxjg getDraft(ParJxjg et) ;
    boolean checkKey(ParJxjg et) ;
    boolean create(ParJxjg et) ;
    void createBatch(List<ParJxjg> list) ;
    boolean save(ParJxjg et) ;
    void saveBatch(List<ParJxjg> list) ;
    ParJxjg get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ParJxjg et) ;
    void updateBatch(List<ParJxjg> list) ;
    Page<ParJxjg> searchDefault(ParJxjgSearchContext context) ;
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

    List<ParJxjg> getParjxjgByIds(List<String> ids) ;
    List<ParJxjg> getParjxjgByEntities(List<ParJxjg> entities) ;

}


