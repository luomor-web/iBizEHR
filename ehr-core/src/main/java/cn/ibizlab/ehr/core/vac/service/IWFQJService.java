package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.WFQJ;
import cn.ibizlab.ehr.core.vac.filter.WFQJSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFQJ] 服务对象接口
 */
public interface IWFQJService extends IService<WFQJ>{

    boolean update(WFQJ et) ;
    void updateBatch(List<WFQJ> list) ;
    boolean checkKey(WFQJ et) ;
    boolean create(WFQJ et) ;
    void createBatch(List<WFQJ> list) ;
    boolean save(WFQJ et) ;
    void saveBatch(List<WFQJ> list) ;
    WFQJ getDraft(WFQJ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFQJ get(String key) ;
    Page<WFQJ> searchDefault(WFQJSearchContext context) ;
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

    List<WFQJ> getWfqjByIds(List<String> ids) ;
    List<WFQJ> getWfqjByEntities(List<WFQJ> entities) ;

}


