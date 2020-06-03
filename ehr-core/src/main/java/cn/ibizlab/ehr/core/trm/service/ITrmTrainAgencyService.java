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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainAgencySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainAgency] 服务对象接口
 */
public interface ITrmTrainAgencyService extends IService<TrmTrainAgency>{

    boolean save(TrmTrainAgency et) ;
    void saveBatch(List<TrmTrainAgency> list) ;
    boolean checkKey(TrmTrainAgency et) ;
    TrmTrainAgency getDraft(TrmTrainAgency et) ;
    TrmTrainAgency get(String key) ;
    boolean update(TrmTrainAgency et) ;
    void updateBatch(List<TrmTrainAgency> list) ;
    boolean create(TrmTrainAgency et) ;
    void createBatch(List<TrmTrainAgency> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TrmTrainAgency> searchDefault(TrmTrainAgencySearchContext context) ;
    List<TrmTrainAgency> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainAgency> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmTrainAgency> selectByTrmtrainagencyid2(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid2(String trmtrainagencyid) ;
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

    List<TrmTrainAgency> getTrmtrainagencyByIds(List<String> ids) ;
    List<TrmTrainAgency> getTrmtrainagencyByEntities(List<TrmTrainAgency> entities) ;

}


