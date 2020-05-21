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

import cn.ibizlab.ehr.core.common.domain.DALog;
import cn.ibizlab.ehr.core.common.filter.DALogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DALog] 服务对象接口
 */
public interface IDALogService extends IService<DALog>{

    boolean save(DALog et) ;
    void saveBatch(List<DALog> list) ;
    boolean update(DALog et) ;
    void updateBatch(List<DALog> list) ;
    boolean checkKey(DALog et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    DALog getDraft(DALog et) ;
    boolean create(DALog et) ;
    void createBatch(List<DALog> list) ;
    DALog get(String key) ;
    Page<DALog> searchDefault(DALogSearchContext context) ;
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


