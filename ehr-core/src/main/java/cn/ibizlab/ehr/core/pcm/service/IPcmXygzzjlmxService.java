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

import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzjlmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzjlmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmXygzzjlmx] 服务对象接口
 */
public interface IPcmXygzzjlmxService extends IService<PcmXygzzjlmx>{

    PcmXygzzjlmx xYGZZCZ(PcmXygzzjlmx et) ;
    PcmXygzzjlmx get(String key) ;
    PcmXygzzjlmx sHTG(PcmXygzzjlmx et) ;
    PcmXygzzjlmx fillPersonInfo(PcmXygzzjlmx et) ;
    PcmXygzzjlmx setPass(PcmXygzzjlmx et) ;
    boolean create(PcmXygzzjlmx et) ;
    void createBatch(List<PcmXygzzjlmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PcmXygzzjlmx et) ;
    boolean update(PcmXygzzjlmx et) ;
    void updateBatch(List<PcmXygzzjlmx> list) ;
    PcmXygzzjlmx getDraft(PcmXygzzjlmx et) ;
    PcmXygzzjlmx setRejcet(PcmXygzzjlmx et) ;
    PcmXygzzjlmx sHBTG(PcmXygzzjlmx et) ;
    boolean save(PcmXygzzjlmx et) ;
    void saveBatch(List<PcmXygzzjlmx> list) ;
    Page<PcmXygzzjlmx> searchZZWSHDS(PcmXygzzjlmxSearchContext context) ;
    Page<PcmXygzzjlmx> searchALLDS(PcmXygzzjlmxSearchContext context) ;
    Page<PcmXygzzjlmx> searchSYQZZJL(PcmXygzzjlmxSearchContext context) ;
    Page<PcmXygzzjlmx> searchDefault(PcmXygzzjlmxSearchContext context) ;
    List<PcmXygzzjlmx> selectByPcmxygzzkhjgjlid(String pcmxygzzkhjgjlid) ;
    void removeByPcmxygzzkhjgjlid(String pcmxygzzkhjgjlid) ;
    List<PcmXygzzjlmx> selectByPcmxygzzsqid(String pcmxygzzsqid) ;
    void removeByPcmxygzzsqid(String pcmxygzzsqid) ;
    List<PcmXygzzjlmx> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmXygzzjlmx> getPcmxygzzjlmxByIds(List<String> ids) ;
    List<PcmXygzzjlmx> getPcmxygzzjlmxByEntities(List<PcmXygzzjlmx> entities) ;

}


