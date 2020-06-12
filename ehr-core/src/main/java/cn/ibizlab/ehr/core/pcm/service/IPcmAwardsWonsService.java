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

import cn.ibizlab.ehr.core.pcm.domain.PcmAwardsWons;
import cn.ibizlab.ehr.core.pcm.filter.PcmAwardsWonsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmAwardsWons] 服务对象接口
 */
public interface IPcmAwardsWonsService extends IService<PcmAwardsWons>{

    PcmAwardsWons getDraft(PcmAwardsWons et) ;
    PcmAwardsWons get(String key) ;
    boolean update(PcmAwardsWons et) ;
    void updateBatch(List<PcmAwardsWons> list) ;
    boolean create(PcmAwardsWons et) ;
    void createBatch(List<PcmAwardsWons> list) ;
    boolean checkKey(PcmAwardsWons et) ;
    boolean save(PcmAwardsWons et) ;
    void saveBatch(List<PcmAwardsWons> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmAwardsWons> searchDefault(PcmAwardsWonsSearchContext context) ;
    List<PcmAwardsWons> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
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

    List<PcmAwardsWons> getPcmawardswonsByIds(List<String> ids) ;
    List<PcmAwardsWons> getPcmawardswonsByEntities(List<PcmAwardsWons> entities) ;

}


