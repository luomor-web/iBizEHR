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

import cn.ibizlab.ehr.core.par.domain.PARKHZCMX;
import cn.ibizlab.ehr.core.par.filter.PARKHZCMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARKHZCMX] 服务对象接口
 */
public interface IPARKHZCMXService extends IService<PARKHZCMX>{

    boolean create(PARKHZCMX et) ;
    void createBatch(List<PARKHZCMX> list) ;
    boolean save(PARKHZCMX et) ;
    void saveBatch(List<PARKHZCMX> list) ;
    PARKHZCMX get(String key) ;
    PARKHZCMX getDraft(PARKHZCMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PARKHZCMX et) ;
    boolean update(PARKHZCMX et) ;
    void updateBatch(List<PARKHZCMX> list) ;
    Page<PARKHZCMX> searchDefault(PARKHZCMXSearchContext context) ;
    List<PARKHZCMX> selectByParjxkhjcszid(String parjxkhjcszid) ;
    void removeByParjxkhjcszid(String parjxkhjcszid) ;
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

    List<PARKHZCMX> getParkhzcmxByIds(List<String> ids) ;
    List<PARKHZCMX> getParkhzcmxByEntities(List<PARKHZCMX> entities) ;

}


