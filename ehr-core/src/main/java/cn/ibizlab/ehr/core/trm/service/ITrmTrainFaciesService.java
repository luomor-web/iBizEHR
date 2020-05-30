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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainFacies;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainFaciesSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainFacies] 服务对象接口
 */
public interface ITrmTrainFaciesService extends IService<TrmTrainFacies>{

    boolean checkKey(TrmTrainFacies et) ;
    TrmTrainFacies getDraft(TrmTrainFacies et) ;
    boolean update(TrmTrainFacies et) ;
    void updateBatch(List<TrmTrainFacies> list) ;
    boolean create(TrmTrainFacies et) ;
    void createBatch(List<TrmTrainFacies> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TrmTrainFacies et) ;
    void saveBatch(List<TrmTrainFacies> list) ;
    TrmTrainFacies get(String key) ;
    Page<TrmTrainFacies> searchDefault(TrmTrainFaciesSearchContext context) ;
    List<TrmTrainFacies> selectByTrmtrainaddressid(String trmtrainaddressid) ;
    void removeByTrmtrainaddressid(String trmtrainaddressid) ;
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

    List<TrmTrainFacies> getTrmtrainfaciesByIds(List<String> ids) ;
    List<TrmTrainFacies> getTrmtrainfaciesByEntities(List<TrmTrainFacies> entities) ;

}


