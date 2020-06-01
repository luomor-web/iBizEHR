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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainDemand;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainDemandSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainDemand] 服务对象接口
 */
public interface ITrmTrainDemandService extends IService<TrmTrainDemand>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(TrmTrainDemand et) ;
    void updateBatch(List<TrmTrainDemand> list) ;
    boolean save(TrmTrainDemand et) ;
    void saveBatch(List<TrmTrainDemand> list) ;
    boolean checkKey(TrmTrainDemand et) ;
    TrmTrainDemand getDraft(TrmTrainDemand et) ;
    boolean create(TrmTrainDemand et) ;
    void createBatch(List<TrmTrainDemand> list) ;
    TrmTrainDemand get(String key) ;
    Page<TrmTrainDemand> searchDefault(TrmTrainDemandSearchContext context) ;
    List<TrmTrainDemand> selectByOrmorgid(String orgid) ;
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

    List<TrmTrainDemand> getTrmtraindemandByIds(List<String> ids) ;
    List<TrmTrainDemand> getTrmtraindemandByEntities(List<TrmTrainDemand> entities) ;

}


