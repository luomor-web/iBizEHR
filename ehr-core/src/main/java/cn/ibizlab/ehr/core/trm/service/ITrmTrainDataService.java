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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainData;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainDataSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainData] 服务对象接口
 */
public interface ITrmTrainDataService extends IService<TrmTrainData>{

    boolean save(TrmTrainData et) ;
    void saveBatch(List<TrmTrainData> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmTrainData get(String key) ;
    TrmTrainData getDraft(TrmTrainData et) ;
    boolean update(TrmTrainData et) ;
    void updateBatch(List<TrmTrainData> list) ;
    boolean checkKey(TrmTrainData et) ;
    boolean create(TrmTrainData et) ;
    void createBatch(List<TrmTrainData> list) ;
    Page<TrmTrainData> searchDefault(TrmTrainDataSearchContext context) ;
    List<TrmTrainData> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainData> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmTrainData> getTrmtraindataByIds(List<String> ids) ;
    List<TrmTrainData> getTrmtraindataByEntities(List<TrmTrainData> entities) ;

}


