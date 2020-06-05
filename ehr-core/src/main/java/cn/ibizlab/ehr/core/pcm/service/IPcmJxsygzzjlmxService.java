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

import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzjlmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzjlmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmJxsygzzjlmx] 服务对象接口
 */
public interface IPcmJxsygzzjlmxService extends IService<PcmJxsygzzjlmx>{

    PcmJxsygzzjlmx sHBTG(PcmJxsygzzjlmx et) ;
    PcmJxsygzzjlmx sHTG(PcmJxsygzzjlmx et) ;
    boolean save(PcmJxsygzzjlmx et) ;
    void saveBatch(List<PcmJxsygzzjlmx> list) ;
    PcmJxsygzzjlmx fillPersonInfo(PcmJxsygzzjlmx et) ;
    PcmJxsygzzjlmx zZCZ(PcmJxsygzzjlmx et) ;
    PcmJxsygzzjlmx setPass(PcmJxsygzzjlmx et) ;
    PcmJxsygzzjlmx getDraft(PcmJxsygzzjlmx et) ;
    PcmJxsygzzjlmx get(String key) ;
    PcmJxsygzzjlmx setReject(PcmJxsygzzjlmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PcmJxsygzzjlmx et) ;
    void createBatch(List<PcmJxsygzzjlmx> list) ;
    boolean update(PcmJxsygzzjlmx et) ;
    void updateBatch(List<PcmJxsygzzjlmx> list) ;
    boolean checkKey(PcmJxsygzzjlmx et) ;
    Page<PcmJxsygzzjlmx> searchDefault(PcmJxsygzzjlmxSearchContext context) ;
    Page<PcmJxsygzzjlmx> searchWSHSQ(PcmJxsygzzjlmxSearchContext context) ;
    Page<PcmJxsygzzjlmx> searchJXSZZJL(PcmJxsygzzjlmxSearchContext context) ;
    Page<PcmJxsygzzjlmx> searchALLDS(PcmJxsygzzjlmxSearchContext context) ;
    List<PcmJxsygzzjlmx> selectByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    void removeByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    List<PcmJxsygzzjlmx> selectByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) ;
    void removeByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) ;
    List<PcmJxsygzzjlmx> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmJxsygzzjlmx> getPcmjxsygzzjlmxByIds(List<String> ids) ;
    List<PcmJxsygzzjlmx> getPcmjxsygzzjlmxByEntities(List<PcmJxsygzzjlmx> entities) ;

}


