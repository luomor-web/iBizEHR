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

import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZJLMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZJLMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMXYGZZJLMX] 服务对象接口
 */
public interface IPCMXYGZZJLMXService extends IService<PCMXYGZZJLMX>{

    PCMXYGZZJLMX xYGZZCZ(PCMXYGZZJLMX et) ;
    PCMXYGZZJLMX get(String key) ;
    PCMXYGZZJLMX sHTG(PCMXYGZZJLMX et) ;
    PCMXYGZZJLMX fillPersonInfo(PCMXYGZZJLMX et) ;
    boolean create(PCMXYGZZJLMX et) ;
    void createBatch(List<PCMXYGZZJLMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMXYGZZJLMX et) ;
    boolean update(PCMXYGZZJLMX et) ;
    void updateBatch(List<PCMXYGZZJLMX> list) ;
    PCMXYGZZJLMX getDraft(PCMXYGZZJLMX et) ;
    PCMXYGZZJLMX sHBTG(PCMXYGZZJLMX et) ;
    boolean save(PCMXYGZZJLMX et) ;
    void saveBatch(List<PCMXYGZZJLMX> list) ;
    Page<PCMXYGZZJLMX> searchZZWSHDS(PCMXYGZZJLMXSearchContext context) ;
    Page<PCMXYGZZJLMX> searchALLDS(PCMXYGZZJLMXSearchContext context) ;
    Page<PCMXYGZZJLMX> searchSYQZZJL(PCMXYGZZJLMXSearchContext context) ;
    Page<PCMXYGZZJLMX> searchDefault(PCMXYGZZJLMXSearchContext context) ;
    List<PCMXYGZZJLMX> selectByPcmxygzzkhjgjlid(String pcmxygzzkhjgjlid) ;
    void removeByPcmxygzzkhjgjlid(String pcmxygzzkhjgjlid) ;
    List<PCMXYGZZJLMX> selectByPcmxygzzsqid(String pcmxygzzsqid) ;
    void removeByPcmxygzzsqid(String pcmxygzzsqid) ;
    List<PCMXYGZZJLMX> selectByPimpersonid(String pimpersonid) ;
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

    List<PCMXYGZZJLMX> getPcmxygzzjlmxByIds(List<String> ids) ;
    List<PCMXYGZZJLMX> getPcmxygzzjlmxByEntities(List<PCMXYGZZJLMX> entities) ;

}


