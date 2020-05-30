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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainAddressSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainAddress] 服务对象接口
 */
public interface ITrmTrainAddressService extends IService<TrmTrainAddress>{

    boolean save(TrmTrainAddress et) ;
    void saveBatch(List<TrmTrainAddress> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmTrainAddress getDraft(TrmTrainAddress et) ;
    boolean create(TrmTrainAddress et) ;
    void createBatch(List<TrmTrainAddress> list) ;
    boolean update(TrmTrainAddress et) ;
    void updateBatch(List<TrmTrainAddress> list) ;
    TrmTrainAddress get(String key) ;
    boolean checkKey(TrmTrainAddress et) ;
    Page<TrmTrainAddress> searchDefault(TrmTrainAddressSearchContext context) ;
    List<TrmTrainAddress> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<TrmTrainAddress> getTrmtrainaddressByIds(List<String> ids) ;
    List<TrmTrainAddress> getTrmtrainaddressByEntities(List<TrmTrainAddress> entities) ;

}


