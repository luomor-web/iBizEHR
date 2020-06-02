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

import cn.ibizlab.ehr.core.pcm.domain.PcmZpmegl;
import cn.ibizlab.ehr.core.pcm.filter.PcmZpmeglSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmZpmegl] 服务对象接口
 */
public interface IPcmZpmeglService extends IService<PcmZpmegl>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PcmZpmegl et) ;
    boolean save(PcmZpmegl et) ;
    void saveBatch(List<PcmZpmegl> list) ;
    boolean update(PcmZpmegl et) ;
    void updateBatch(List<PcmZpmegl> list) ;
    boolean create(PcmZpmegl et) ;
    void createBatch(List<PcmZpmegl> list) ;
    PcmZpmegl get(String key) ;
    PcmZpmegl getDraft(PcmZpmegl et) ;
    Page<PcmZpmegl> searchCurND(PcmZpmeglSearchContext context) ;
    Page<PcmZpmegl> searchDefault(PcmZpmeglSearchContext context) ;
    List<PcmZpmegl> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<PcmZpmegl> getPcmzpmeglByIds(List<String> ids) ;
    List<PcmZpmegl> getPcmzpmeglByEntities(List<PcmZpmegl> entities) ;

}


