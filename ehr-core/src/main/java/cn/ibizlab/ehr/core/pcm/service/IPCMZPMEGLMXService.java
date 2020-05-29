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

import cn.ibizlab.ehr.core.pcm.domain.PCMZPMEGLMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMZPMEGLMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMZPMEGLMX] 服务对象接口
 */
public interface IPCMZPMEGLMXService extends IService<PCMZPMEGLMX>{

    boolean checkKey(PCMZPMEGLMX et) ;
    boolean create(PCMZPMEGLMX et) ;
    void createBatch(List<PCMZPMEGLMX> list) ;
    PCMZPMEGLMX get(String key) ;
    PCMZPMEGLMX getDraft(PCMZPMEGLMX et) ;
    boolean update(PCMZPMEGLMX et) ;
    void updateBatch(List<PCMZPMEGLMX> list) ;
    boolean save(PCMZPMEGLMX et) ;
    void saveBatch(List<PCMZPMEGLMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMZPMEGLMX> searchDefault(PCMZPMEGLMXSearchContext context) ;
    List<PCMZPMEGLMX> selectByPcmzpmeglid(String pcmzpmeglid) ;
    void removeByPcmzpmeglid(String pcmzpmeglid) ;
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

    List<PCMZPMEGLMX> getPcmzpmeglmxByIds(List<String> ids) ;
    List<PCMZPMEGLMX> getPcmzpmeglmxByEntities(List<PCMZPMEGLMX> entities) ;

}


