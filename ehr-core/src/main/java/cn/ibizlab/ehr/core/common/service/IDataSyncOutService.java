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

import cn.ibizlab.ehr.core.common.domain.DataSyncOut;
import cn.ibizlab.ehr.core.common.filter.DataSyncOutSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DataSyncOut] 服务对象接口
 */
public interface IDataSyncOutService extends IService<DataSyncOut>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(DataSyncOut et) ;
    DataSyncOut get(String key) ;
    boolean create(DataSyncOut et) ;
    void createBatch(List<DataSyncOut> list) ;
    boolean update(DataSyncOut et) ;
    void updateBatch(List<DataSyncOut> list) ;
    DataSyncOut getDraft(DataSyncOut et) ;
    boolean save(DataSyncOut et) ;
    void saveBatch(List<DataSyncOut> list) ;
    Page<DataSyncOut> searchDefault(DataSyncOutSearchContext context) ;
    List<DataSyncOut> selectByDeid(String deid) ;
    void removeByDeid(String deid) ;
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


