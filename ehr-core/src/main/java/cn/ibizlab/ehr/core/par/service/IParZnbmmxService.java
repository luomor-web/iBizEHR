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

import cn.ibizlab.ehr.core.par.domain.ParZnbmmx;
import cn.ibizlab.ehr.core.par.filter.ParZnbmmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParZnbmmx] 服务对象接口
 */
public interface IParZnbmmxService extends IService<ParZnbmmx>{

    boolean checkKey(ParZnbmmx et) ;
    boolean update(ParZnbmmx et) ;
    void updateBatch(List<ParZnbmmx> list) ;
    ParZnbmmx getDraft(ParZnbmmx et) ;
    boolean create(ParZnbmmx et) ;
    void createBatch(List<ParZnbmmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParZnbmmx et) ;
    void saveBatch(List<ParZnbmmx> list) ;
    ParZnbmmx get(String key) ;
    Page<ParZnbmmx> searchDefault(ParZnbmmxSearchContext context) ;
    List<ParZnbmmx> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<ParZnbmmx> selectByPartzggid(String partzggid) ;
    void removeByPartzggid(String partzggid) ;
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

    List<ParZnbmmx> getParznbmmxByIds(List<String> ids) ;
    List<ParZnbmmx> getParznbmmxByEntities(List<ParZnbmmx> entities) ;

}


