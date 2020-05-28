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

import cn.ibizlab.ehr.core.par.domain.PARYDGZJH;
import cn.ibizlab.ehr.core.par.filter.PARYDGZJHSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARYDGZJH] 服务对象接口
 */
public interface IPARYDGZJHService extends IService<PARYDGZJH>{

    PARYDGZJH getDraft(PARYDGZJH et) ;
    boolean update(PARYDGZJH et) ;
    void updateBatch(List<PARYDGZJH> list) ;
    boolean checkKey(PARYDGZJH et) ;
    boolean save(PARYDGZJH et) ;
    void saveBatch(List<PARYDGZJH> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PARYDGZJH get(String key) ;
    boolean create(PARYDGZJH et) ;
    void createBatch(List<PARYDGZJH> list) ;
    Page<PARYDGZJH> searchDefault(PARYDGZJHSearchContext context) ;
    List<PARYDGZJH> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<PARYDGZJH> getParydgzjhByIds(List<String> ids) ;
    List<PARYDGZJH> getParydgzjhByEntities(List<PARYDGZJH> entities) ;

}


