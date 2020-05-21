package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.ServiceRT;
import cn.ibizlab.ehr.core.common.filter.ServiceRTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ServiceRT] 服务对象接口
 */
public interface IServiceRTService extends IService<ServiceRT>{

    ServiceRT stopService(ServiceRT et) ;
    ServiceRT getDraft(ServiceRT et) ;
    boolean create(ServiceRT et) ;
    void createBatch(List<ServiceRT> list) ;
    ServiceRT get(String key) ;
    boolean checkKey(ServiceRT et) ;
    boolean save(ServiceRT et) ;
    void saveBatch(List<ServiceRT> list) ;
    boolean update(ServiceRT et) ;
    void updateBatch(List<ServiceRT> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ServiceRT startService(ServiceRT et) ;
    Page<ServiceRT> searchDefault(ServiceRTSearchContext context) ;
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


