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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainDemandSum;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainDemandSumSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainDemandSum] 服务对象接口
 */
public interface ITrmTrainDemandSumService extends IService<TrmTrainDemandSum>{

    boolean save(TrmTrainDemandSum et) ;
    void saveBatch(List<TrmTrainDemandSum> list) ;
    TrmTrainDemandSum get(String key) ;
    boolean create(TrmTrainDemandSum et) ;
    void createBatch(List<TrmTrainDemandSum> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmTrainDemandSum getDraft(TrmTrainDemandSum et) ;
    boolean update(TrmTrainDemandSum et) ;
    void updateBatch(List<TrmTrainDemandSum> list) ;
    boolean checkKey(TrmTrainDemandSum et) ;
    Page<TrmTrainDemandSum> searchDefault(TrmTrainDemandSumSearchContext context) ;
    List<TrmTrainDemandSum> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainDemandSum> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TrmTrainDemandSum> selectByTrmtraindemandid(String trmtraindemandid) ;
    void removeByTrmtraindemandid(String trmtraindemandid) ;
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

    List<TrmTrainDemandSum> getTrmtraindemandsumByIds(List<String> ids) ;
    List<TrmTrainDemandSum> getTrmtraindemandsumByEntities(List<TrmTrainDemandSum> entities) ;

}


