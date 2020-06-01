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

import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsqmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzsqmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmJxsygzzsqmx] 服务对象接口
 */
public interface IPcmJxsygzzsqmxService extends IService<PcmJxsygzzsqmx>{

    boolean create(PcmJxsygzzsqmx et) ;
    void createBatch(List<PcmJxsygzzsqmx> list) ;
    boolean save(PcmJxsygzzsqmx et) ;
    void saveBatch(List<PcmJxsygzzsqmx> list) ;
    PcmJxsygzzsqmx getDraft(PcmJxsygzzsqmx et) ;
    boolean update(PcmJxsygzzsqmx et) ;
    void updateBatch(List<PcmJxsygzzsqmx> list) ;
    PcmJxsygzzsqmx get(String key) ;
    boolean checkKey(PcmJxsygzzsqmx et) ;
    PcmJxsygzzsqmx zZAction(PcmJxsygzzsqmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmJxsygzzsqmx> searchDefault(PcmJxsygzzsqmxSearchContext context) ;
    Page<PcmJxsygzzsqmx> searchDSHSQ(PcmJxsygzzsqmxSearchContext context) ;
    List<PcmJxsygzzsqmx> selectByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    void removeByPcmjxsygzzsqid(String pcmjxsygzzsqid) ;
    List<PcmJxsygzzsqmx> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmJxsygzzsqmx> getPcmjxsygzzsqmxByIds(List<String> ids) ;
    List<PcmJxsygzzsqmx> getPcmjxsygzzsqmxByEntities(List<PcmJxsygzzsqmx> entities) ;

}


