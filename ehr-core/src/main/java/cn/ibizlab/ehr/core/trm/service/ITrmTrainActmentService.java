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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainActment;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainActmentSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainActment] 服务对象接口
 */
public interface ITrmTrainActmentService extends IService<TrmTrainActment>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmTrainActment getDraft(TrmTrainActment et) ;
    boolean checkKey(TrmTrainActment et) ;
    TrmTrainActment get(String key) ;
    boolean save(TrmTrainActment et) ;
    void saveBatch(List<TrmTrainActment> list) ;
    boolean create(TrmTrainActment et) ;
    void createBatch(List<TrmTrainActment> list) ;
    boolean update(TrmTrainActment et) ;
    void updateBatch(List<TrmTrainActment> list) ;
    Page<TrmTrainActment> searchDefault(TrmTrainActmentSearchContext context) ;
    List<TrmTrainActment> selectByTrmtrainactapplyid(String trmtrainactapplyid) ;
    void removeByTrmtrainactapplyid(String trmtrainactapplyid) ;
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

    List<TrmTrainActment> getTrmtrainactmentByIds(List<String> ids) ;
    List<TrmTrainActment> getTrmtrainactmentByEntities(List<TrmTrainActment> entities) ;

}


