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

import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsqmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzsqmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmXygzzsqmx] 服务对象接口
 */
public interface IPcmXygzzsqmxService extends IService<PcmXygzzsqmx>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmXygzzsqmx getDraft(PcmXygzzsqmx et) ;
    PcmXygzzsqmx get(String key) ;
    boolean update(PcmXygzzsqmx et) ;
    void updateBatch(List<PcmXygzzsqmx> list) ;
    PcmXygzzsqmx sHBTG(PcmXygzzsqmx et) ;
    boolean create(PcmXygzzsqmx et) ;
    void createBatch(List<PcmXygzzsqmx> list) ;
    boolean save(PcmXygzzsqmx et) ;
    void saveBatch(List<PcmXygzzsqmx> list) ;
    PcmXygzzsqmx sHTG(PcmXygzzsqmx et) ;
    PcmXygzzsqmx zZCZ(PcmXygzzsqmx et) ;
    boolean checkKey(PcmXygzzsqmx et) ;
    Page<PcmXygzzsqmx> searchWSHSQ(PcmXygzzsqmxSearchContext context) ;
    Page<PcmXygzzsqmx> searchDefault(PcmXygzzsqmxSearchContext context) ;
    List<PcmXygzzsqmx> selectByPcmxygzzsqid(String pcmxygzzsqid) ;
    void removeByPcmxygzzsqid(String pcmxygzzsqid) ;
    List<PcmXygzzsqmx> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmXygzzsqmx> getPcmxygzzsqmxByIds(List<String> ids) ;
    List<PcmXygzzsqmx> getPcmxygzzsqmxByEntities(List<PcmXygzzsqmx> entities) ;

}


