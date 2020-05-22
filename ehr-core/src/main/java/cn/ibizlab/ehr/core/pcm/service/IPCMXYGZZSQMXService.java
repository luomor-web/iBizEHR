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

import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZSQMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMXYGZZSQMX] 服务对象接口
 */
public interface IPCMXYGZZSQMXService extends IService<PCMXYGZZSQMX>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMXYGZZSQMX getDraft(PCMXYGZZSQMX et) ;
    PCMXYGZZSQMX get(String key) ;
    boolean update(PCMXYGZZSQMX et) ;
    void updateBatch(List<PCMXYGZZSQMX> list) ;
    PCMXYGZZSQMX sHBTG(PCMXYGZZSQMX et) ;
    boolean create(PCMXYGZZSQMX et) ;
    void createBatch(List<PCMXYGZZSQMX> list) ;
    boolean save(PCMXYGZZSQMX et) ;
    void saveBatch(List<PCMXYGZZSQMX> list) ;
    PCMXYGZZSQMX sHTG(PCMXYGZZSQMX et) ;
    PCMXYGZZSQMX zZCZ(PCMXYGZZSQMX et) ;
    boolean checkKey(PCMXYGZZSQMX et) ;
    Page<PCMXYGZZSQMX> searchWSHSQ(PCMXYGZZSQMXSearchContext context) ;
    Page<PCMXYGZZSQMX> searchDefault(PCMXYGZZSQMXSearchContext context) ;
    List<PCMXYGZZSQMX> selectByPcmxygzzsqid(String pcmxygzzsqid) ;
    void removeByPcmxygzzsqid(String pcmxygzzsqid) ;
    List<PCMXYGZZSQMX> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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


