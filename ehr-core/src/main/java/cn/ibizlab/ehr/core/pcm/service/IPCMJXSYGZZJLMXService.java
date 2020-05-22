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

import cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZJLMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSYGZZJLMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMJXSYGZZJLMX] 服务对象接口
 */
public interface IPCMJXSYGZZJLMXService extends IService<PCMJXSYGZZJLMX>{

    PCMJXSYGZZJLMX sHBTG(PCMJXSYGZZJLMX et) ;
    PCMJXSYGZZJLMX sHTG(PCMJXSYGZZJLMX et) ;
    boolean save(PCMJXSYGZZJLMX et) ;
    void saveBatch(List<PCMJXSYGZZJLMX> list) ;
    PCMJXSYGZZJLMX fillPersonInfo(PCMJXSYGZZJLMX et) ;
    PCMJXSYGZZJLMX zZCZ(PCMJXSYGZZJLMX et) ;
    PCMJXSYGZZJLMX getDraft(PCMJXSYGZZJLMX et) ;
    PCMJXSYGZZJLMX get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PCMJXSYGZZJLMX et) ;
    void createBatch(List<PCMJXSYGZZJLMX> list) ;
    boolean update(PCMJXSYGZZJLMX et) ;
    void updateBatch(List<PCMJXSYGZZJLMX> list) ;
    boolean checkKey(PCMJXSYGZZJLMX et) ;
    Page<PCMJXSYGZZJLMX> searchDefault(PCMJXSYGZZJLMXSearchContext context) ;
    Page<PCMJXSYGZZJLMX> searchWSHSQ(PCMJXSYGZZJLMXSearchContext context) ;
    Page<PCMJXSYGZZJLMX> searchJXSZZJL(PCMJXSYGZZJLMXSearchContext context) ;
    Page<PCMJXSYGZZJLMX> searchALLDS(PCMJXSYGZZJLMXSearchContext context) ;
    List<PCMJXSYGZZJLMX> selectByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    void removeByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    List<PCMJXSYGZZJLMX> selectByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) ;
    void removeByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) ;
    List<PCMJXSYGZZJLMX> selectByPimpersonid(String pimpersonid) ;
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


