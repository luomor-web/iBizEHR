package cn.ibizlab.ehr.core.wf.service;

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

import cn.ibizlab.ehr.core.wf.domain.WFDynamicUser;
import cn.ibizlab.ehr.core.wf.filter.WFDynamicUserSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFDynamicUser] 服务对象接口
 */
public interface IWFDynamicUserService extends IService<WFDynamicUser>{

    boolean create(WFDynamicUser et) ;
    void createBatch(List<WFDynamicUser> list) ;
    WFDynamicUser get(String key) ;
    boolean save(WFDynamicUser et) ;
    void saveBatch(List<WFDynamicUser> list) ;
    boolean checkKey(WFDynamicUser et) ;
    WFDynamicUser getDraft(WFDynamicUser et) ;
    boolean update(WFDynamicUser et) ;
    void updateBatch(List<WFDynamicUser> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<WFDynamicUser> searchDefault(WFDynamicUserSearchContext context) ;
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


