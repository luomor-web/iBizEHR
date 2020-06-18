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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPlanSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainPlan] 服务对象接口
 */
public interface ITrmTrainPlanService extends IService<TrmTrainPlan>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TrmTrainPlan et) ;
    void saveBatch(List<TrmTrainPlan> list) ;
    TrmTrainPlan setYfbZt(TrmTrainPlan et) ;
    TrmTrainPlan getDraft(TrmTrainPlan et) ;
    boolean checkKey(TrmTrainPlan et) ;
    TrmTrainPlan setDfbZt(TrmTrainPlan et) ;
    TrmTrainPlan setApprovalStatus(TrmTrainPlan et) ;
    TrmTrainPlan get(String key) ;
    boolean create(TrmTrainPlan et) ;
    void createBatch(List<TrmTrainPlan> list) ;
    TrmTrainPlan setRejectStatus(TrmTrainPlan et) ;
    boolean update(TrmTrainPlan et) ;
    void updateBatch(List<TrmTrainPlan> list) ;
    Page<TrmTrainPlan> searchDefault(TrmTrainPlanSearchContext context) ;
    List<TrmTrainPlan> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainPlan> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmTrainPlan> selectByTrmdemdeftionid(String trmdemdeftionid) ;
    void removeByTrmdemdeftionid(String trmdemdeftionid) ;
    List<TrmTrainPlan> selectByTrmplanformuid(String trmplanformuid) ;
    void removeByTrmplanformuid(String trmplanformuid) ;
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

    List<TrmTrainPlan> getTrmtrainplanByIds(List<String> ids) ;
    List<TrmTrainPlan> getTrmtrainplanByEntities(List<TrmTrainPlan> entities) ;

}


