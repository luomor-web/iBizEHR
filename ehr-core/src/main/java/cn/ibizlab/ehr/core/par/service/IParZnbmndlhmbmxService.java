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

import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParZnbmndlhmbmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParZnbmndlhmbmx] 服务对象接口
 */
public interface IParZnbmndlhmbmxService extends IService<ParZnbmndlhmbmx>{

    boolean create(ParZnbmndlhmbmx et) ;
    void createBatch(List<ParZnbmndlhmbmx> list) ;
    boolean update(ParZnbmndlhmbmx et) ;
    void updateBatch(List<ParZnbmndlhmbmx> list) ;
    ParZnbmndlhmbmx getDraft(ParZnbmndlhmbmx et) ;
    ParZnbmndlhmbmx get(String key) ;
    boolean checkKey(ParZnbmndlhmbmx et) ;
    boolean save(ParZnbmndlhmbmx et) ;
    void saveBatch(List<ParZnbmndlhmbmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ParZnbmndlhmbmx> searchDefault(ParZnbmndlhmbmxSearchContext context) ;
    List<ParZnbmndlhmbmx> selectByParznbmndlhmbid(String parznbmndlhmbid) ;
    void removeByParznbmndlhmbid(String parznbmndlhmbid) ;
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

    List<ParZnbmndlhmbmx> getParznbmndlhmbmxByIds(List<String> ids) ;
    List<ParZnbmndlhmbmx> getParznbmndlhmbmxByEntities(List<ParZnbmndlhmbmx> entities) ;

}


