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

import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQ;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZSQSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMXYGZZSQ] 服务对象接口
 */
public interface IPCMXYGZZSQService extends IService<PCMXYGZZSQ>{

    boolean create(PCMXYGZZSQ et) ;
    void createBatch(List<PCMXYGZZSQ> list) ;
    PCMXYGZZSQ get(String key) ;
    boolean save(PCMXYGZZSQ et) ;
    void saveBatch(List<PCMXYGZZSQ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMXYGZZSQ et) ;
    PCMXYGZZSQ getDraft(PCMXYGZZSQ et) ;
    boolean update(PCMXYGZZSQ et) ;
    void updateBatch(List<PCMXYGZZSQ> list) ;
    Page<PCMXYGZZSQ> searchDefault(PCMXYGZZSQSearchContext context) ;
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


