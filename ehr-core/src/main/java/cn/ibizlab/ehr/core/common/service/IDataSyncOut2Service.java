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

import cn.ibizlab.ehr.core.common.domain.DataSyncOut2;
import cn.ibizlab.ehr.core.common.filter.DataSyncOut2SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DataSyncOut2] 服务对象接口
 */
public interface IDataSyncOut2Service extends IService<DataSyncOut2>{

    boolean update(DataSyncOut2 et) ;
    void updateBatch(List<DataSyncOut2> list) ;
    DataSyncOut2 getDraft(DataSyncOut2 et) ;
    boolean save(DataSyncOut2 et) ;
    void saveBatch(List<DataSyncOut2> list) ;
    boolean create(DataSyncOut2 et) ;
    void createBatch(List<DataSyncOut2> list) ;
    boolean checkKey(DataSyncOut2 et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    DataSyncOut2 get(String key) ;
    Page<DataSyncOut2> searchDefault(DataSyncOut2SearchContext context) ;
    List<DataSyncOut2> selectByDeid(String deid) ;
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


