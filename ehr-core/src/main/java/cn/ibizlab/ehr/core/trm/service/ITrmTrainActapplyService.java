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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainActapplySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainActapply] 服务对象接口
 */
public interface ITrmTrainActapplyService extends IService<TrmTrainActapply>{

    TrmTrainActapply getDraft(TrmTrainActapply et) ;
    boolean checkKey(TrmTrainActapply et) ;
    boolean create(TrmTrainActapply et) ;
    void createBatch(List<TrmTrainActapply> list) ;
    TrmTrainActapply get(String key) ;
    boolean save(TrmTrainActapply et) ;
    void saveBatch(List<TrmTrainActapply> list) ;
    boolean update(TrmTrainActapply et) ;
    void updateBatch(List<TrmTrainActapply> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TrmTrainActapply> searchDefault(TrmTrainActapplySearchContext context) ;
    List<TrmTrainActapply> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<TrmTrainActapply> getTrmtrainactapplyByIds(List<String> ids) ;
    List<TrmTrainActapply> getTrmtrainactapplyByEntities(List<TrmTrainActapply> entities) ;

}


