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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainFillin;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainFillinSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainFillin] 服务对象接口
 */
public interface ITrmTrainFillinService extends IService<TrmTrainFillin>{

    TrmTrainFillin get(String key) ;
    boolean update(TrmTrainFillin et) ;
    void updateBatch(List<TrmTrainFillin> list) ;
    boolean checkKey(TrmTrainFillin et) ;
    boolean create(TrmTrainFillin et) ;
    void createBatch(List<TrmTrainFillin> list) ;
    boolean save(TrmTrainFillin et) ;
    void saveBatch(List<TrmTrainFillin> list) ;
    TrmTrainFillin getDraft(TrmTrainFillin et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TrmTrainFillin> searchDefault(TrmTrainFillinSearchContext context) ;
    List<TrmTrainFillin> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TrmTrainFillin> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainFillin> selectByTrmdepartid(String trmdepartid) ;
    void removeByTrmdepartid(String trmdepartid) ;
    List<TrmTrainFillin> selectByTrmtrainfillinid2(String trmtrainfillinid) ;
    void removeByTrmtrainfillinid2(String trmtrainfillinid) ;
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

    List<TrmTrainFillin> getTrmtrainfillinByIds(List<String> ids) ;
    List<TrmTrainFillin> getTrmtrainfillinByEntities(List<TrmTrainFillin> entities) ;

}


