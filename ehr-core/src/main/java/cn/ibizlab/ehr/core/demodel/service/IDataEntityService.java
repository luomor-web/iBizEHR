package cn.ibizlab.ehr.core.demodel.service;

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

import cn.ibizlab.ehr.core.demodel.domain.DataEntity;
import cn.ibizlab.ehr.core.demodel.filter.DataEntitySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DataEntity] 服务对象接口
 */
public interface IDataEntityService extends IService<DataEntity>{

    DataEntity initUserRoleData(DataEntity et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    DataEntity getDraft(DataEntity et) ;
    DataEntity get(String key) ;
    DataEntity initAll(DataEntity et) ;
    boolean create(DataEntity et) ;
    void createBatch(List<DataEntity> list) ;
    boolean save(DataEntity et) ;
    void saveBatch(List<DataEntity> list) ;
    boolean update(DataEntity et) ;
    void updateBatch(List<DataEntity> list) ;
    boolean checkKey(DataEntity et) ;
    Page<DataEntity> searchDefault(DataEntitySearchContext context) ;
    List<DataEntity> selectByDer11deid(String deid) ;
    void removeByDer11deid(String deid) ;
    List<DataEntity> selectByAcquerymodelid(String querymodelid) ;
    void removeByAcquerymodelid(String querymodelid) ;
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


