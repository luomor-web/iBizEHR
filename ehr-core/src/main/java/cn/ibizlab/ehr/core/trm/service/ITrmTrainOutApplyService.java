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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainOutApply;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainOutApplySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainOutApply] 服务对象接口
 */
public interface ITrmTrainOutApplyService extends IService<TrmTrainOutApply>{

    TrmTrainOutApply get(String key) ;
    boolean checkKey(TrmTrainOutApply et) ;
    boolean save(TrmTrainOutApply et) ;
    void saveBatch(List<TrmTrainOutApply> list) ;
    TrmTrainOutApply getDraft(TrmTrainOutApply et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(TrmTrainOutApply et) ;
    void updateBatch(List<TrmTrainOutApply> list) ;
    boolean create(TrmTrainOutApply et) ;
    void createBatch(List<TrmTrainOutApply> list) ;
    Page<TrmTrainOutApply> searchDefault(TrmTrainOutApplySearchContext context) ;
    List<TrmTrainOutApply> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<TrmTrainOutApply> getTrmtrainoutapplyByIds(List<String> ids) ;
    List<TrmTrainOutApply> getTrmtrainoutapplyByEntities(List<TrmTrainOutApply> entities) ;

}


