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

import cn.ibizlab.ehr.core.common.domain.DataSyncIn2;
import cn.ibizlab.ehr.core.common.filter.DataSyncIn2SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DataSyncIn2] 服务对象接口
 */
public interface IDataSyncIn2Service extends IService<DataSyncIn2>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(DataSyncIn2 et) ;
    void saveBatch(List<DataSyncIn2> list) ;
    DataSyncIn2 getDraft(DataSyncIn2 et) ;
    boolean update(DataSyncIn2 et) ;
    void updateBatch(List<DataSyncIn2> list) ;
    DataSyncIn2 get(String key) ;
    boolean create(DataSyncIn2 et) ;
    void createBatch(List<DataSyncIn2> list) ;
    boolean checkKey(DataSyncIn2 et) ;
    Page<DataSyncIn2> searchDefault(DataSyncIn2SearchContext context) ;
    List<DataSyncIn2> selectByDeid(String deid) ;
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


