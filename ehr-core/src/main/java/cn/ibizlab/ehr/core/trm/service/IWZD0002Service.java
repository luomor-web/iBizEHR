package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.WZD0002;
import cn.ibizlab.ehr.core.trm.filter.WZD0002SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WZD0002] 服务对象接口
 */
public interface IWZD0002Service extends IService<WZD0002>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(WZD0002 et) ;
    void saveBatch(List<WZD0002> list) ;
    WZD0002 getDraft(WZD0002 et) ;
    boolean checkKey(WZD0002 et) ;
    WZD0002 get(String key) ;
    boolean create(WZD0002 et) ;
    void createBatch(List<WZD0002> list) ;
    boolean update(WZD0002 et) ;
    void updateBatch(List<WZD0002> list) ;
    Page<WZD0002> searchDefault(WZD0002SearchContext context) ;
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


