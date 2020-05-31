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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainResment;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainResmentSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainResment] 服务对象接口
 */
public interface ITrmTrainResmentService extends IService<TrmTrainResment>{

    boolean update(TrmTrainResment et) ;
    void updateBatch(List<TrmTrainResment> list) ;
    TrmTrainResment getDraft(TrmTrainResment et) ;
    boolean save(TrmTrainResment et) ;
    void saveBatch(List<TrmTrainResment> list) ;
    boolean checkKey(TrmTrainResment et) ;
    boolean create(TrmTrainResment et) ;
    void createBatch(List<TrmTrainResment> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmTrainResment get(String key) ;
    Page<TrmTrainResment> searchDefault(TrmTrainResmentSearchContext context) ;
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

    List<TrmTrainResment> getTrmtrainresmentByIds(List<String> ids) ;
    List<TrmTrainResment> getTrmtrainresmentByEntities(List<TrmTrainResment> entities) ;

}


