package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.WZD0001;
import cn.ibizlab.ehr.core.pcm.filter.WZD0001SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WZD0001] 服务对象接口
 */
public interface IWZD0001Service extends IService<WZD0001>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WZD0001 getDraft(WZD0001 et) ;
    boolean save(WZD0001 et) ;
    void saveBatch(List<WZD0001> list) ;
    WZD0001 get(String key) ;
    boolean update(WZD0001 et) ;
    void updateBatch(List<WZD0001> list) ;
    boolean checkKey(WZD0001 et) ;
    boolean create(WZD0001 et) ;
    void createBatch(List<WZD0001> list) ;
    WZD0001 updatePeopleNum(WZD0001 et) ;
    Page<WZD0001> searchDefault(WZD0001SearchContext context) ;
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

}


