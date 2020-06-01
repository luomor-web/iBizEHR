package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.PcmReason;
import cn.ibizlab.ehr.core.pcm.filter.PcmReasonSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmReason] 服务对象接口
 */
public interface IPcmReasonService extends IService<PcmReason>{

    PcmReason getDraft(PcmReason et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PcmReason et) ;
    void updateBatch(List<PcmReason> list) ;
    PcmReason get(String key) ;
    boolean create(PcmReason et) ;
    void createBatch(List<PcmReason> list) ;
    boolean checkKey(PcmReason et) ;
    boolean save(PcmReason et) ;
    void saveBatch(List<PcmReason> list) ;
    Page<PcmReason> searchDefault(PcmReasonSearchContext context) ;
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

    List<PcmReason> getPcmreasonByIds(List<String> ids) ;
    List<PcmReason> getPcmreasonByEntities(List<PcmReason> entities) ;

}


