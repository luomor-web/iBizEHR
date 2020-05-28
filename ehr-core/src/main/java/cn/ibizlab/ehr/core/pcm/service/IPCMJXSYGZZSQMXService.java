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

import cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZSQMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSYGZZSQMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMJXSYGZZSQMX] 服务对象接口
 */
public interface IPCMJXSYGZZSQMXService extends IService<PCMJXSYGZZSQMX>{

    boolean create(PCMJXSYGZZSQMX et) ;
    void createBatch(List<PCMJXSYGZZSQMX> list) ;
    boolean save(PCMJXSYGZZSQMX et) ;
    void saveBatch(List<PCMJXSYGZZSQMX> list) ;
    PCMJXSYGZZSQMX getDraft(PCMJXSYGZZSQMX et) ;
    boolean update(PCMJXSYGZZSQMX et) ;
    void updateBatch(List<PCMJXSYGZZSQMX> list) ;
    PCMJXSYGZZSQMX get(String key) ;
    boolean checkKey(PCMJXSYGZZSQMX et) ;
    PCMJXSYGZZSQMX zZAction(PCMJXSYGZZSQMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMJXSYGZZSQMX> searchDefault(PCMJXSYGZZSQMXSearchContext context) ;
    Page<PCMJXSYGZZSQMX> searchDSHSQ(PCMJXSYGZZSQMXSearchContext context) ;
    List<PCMJXSYGZZSQMX> selectByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    void removeByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    List<PCMJXSYGZZSQMX> selectByPimpersonid(String pimpersonid) ;
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

    List<PCMJXSYGZZSQMX> getPcmjxsygzzsqmxByIds(List<String> ids) ;
    List<PCMJXSYGZZSQMX> getPcmjxsygzzsqmxByEntities(List<PCMJXSYGZZSQMX> entities) ;

}


