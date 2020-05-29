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

import cn.ibizlab.ehr.core.par.domain.ParJzszpsjg;
import cn.ibizlab.ehr.core.par.filter.ParJzszpsjgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJzszpsjg] 服务对象接口
 */
public interface IParJzszpsjgService extends IService<ParJzszpsjg>{

    ParJzszpsjg get(String key) ;
    boolean update(ParJzszpsjg et) ;
    void updateBatch(List<ParJzszpsjg> list) ;
    boolean save(ParJzszpsjg et) ;
    void saveBatch(List<ParJzszpsjg> list) ;
    boolean checkKey(ParJzszpsjg et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParJzszpsjg getDraft(ParJzszpsjg et) ;
    boolean create(ParJzszpsjg et) ;
    void createBatch(List<ParJzszpsjg> list) ;
    Page<ParJzszpsjg> searchDefault(ParJzszpsjgSearchContext context) ;
    List<ParJzszpsjg> selectByPimpersonid(String pimpersonid) ;
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

    List<ParJzszpsjg> getParjzszpsjgByIds(List<String> ids) ;
    List<ParJzszpsjg> getParjzszpsjgByEntities(List<ParJzszpsjg> entities) ;

}


