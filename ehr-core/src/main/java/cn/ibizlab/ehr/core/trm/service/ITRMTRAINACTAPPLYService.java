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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTAPPLY;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINACTAPPLYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINACTAPPLY] 服务对象接口
 */
public interface ITRMTRAINACTAPPLYService extends IService<TRMTRAINACTAPPLY>{

    TRMTRAINACTAPPLY getDraft(TRMTRAINACTAPPLY et) ;
    boolean checkKey(TRMTRAINACTAPPLY et) ;
    boolean create(TRMTRAINACTAPPLY et) ;
    void createBatch(List<TRMTRAINACTAPPLY> list) ;
    TRMTRAINACTAPPLY get(String key) ;
    boolean save(TRMTRAINACTAPPLY et) ;
    void saveBatch(List<TRMTRAINACTAPPLY> list) ;
    boolean update(TRMTRAINACTAPPLY et) ;
    void updateBatch(List<TRMTRAINACTAPPLY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TRMTRAINACTAPPLY> searchDefault(TRMTRAINACTAPPLYSearchContext context) ;
    List<TRMTRAINACTAPPLY> selectByOrmorgsectorid(String orgsectorid) ;
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

}


