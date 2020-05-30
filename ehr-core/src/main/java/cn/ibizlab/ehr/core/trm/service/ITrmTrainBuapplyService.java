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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainBuapply;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainBuapplySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainBuapply] 服务对象接口
 */
public interface ITrmTrainBuapplyService extends IService<TrmTrainBuapply>{

    boolean create(TrmTrainBuapply et) ;
    void createBatch(List<TrmTrainBuapply> list) ;
    boolean update(TrmTrainBuapply et) ;
    void updateBatch(List<TrmTrainBuapply> list) ;
    TrmTrainBuapply getDraft(TrmTrainBuapply et) ;
    TrmTrainBuapply get(String key) ;
    boolean checkKey(TrmTrainBuapply et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TrmTrainBuapply et) ;
    void saveBatch(List<TrmTrainBuapply> list) ;
    Page<TrmTrainBuapply> searchDefault(TrmTrainBuapplySearchContext context) ;
    List<TrmTrainBuapply> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainBuapply> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
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

    List<TrmTrainBuapply> getTrmtrainbuapplyByIds(List<String> ids) ;
    List<TrmTrainBuapply> getTrmtrainbuapplyByEntities(List<TrmTrainBuapply> entities) ;

}


