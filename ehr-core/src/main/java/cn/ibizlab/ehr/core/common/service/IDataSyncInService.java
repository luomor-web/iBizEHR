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

import cn.ibizlab.ehr.core.common.domain.DataSyncIn;
import cn.ibizlab.ehr.core.common.filter.DataSyncInSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DataSyncIn] 服务对象接口
 */
public interface IDataSyncInService extends IService<DataSyncIn>{

    boolean save(DataSyncIn et) ;
    void saveBatch(List<DataSyncIn> list) ;
    boolean checkKey(DataSyncIn et) ;
    boolean update(DataSyncIn et) ;
    void updateBatch(List<DataSyncIn> list) ;
    DataSyncIn get(String key) ;
    DataSyncIn getDraft(DataSyncIn et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(DataSyncIn et) ;
    void createBatch(List<DataSyncIn> list) ;
    Page<DataSyncIn> searchDefault(DataSyncInSearchContext context) ;
    List<DataSyncIn> selectByDeid(String deid) ;
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


