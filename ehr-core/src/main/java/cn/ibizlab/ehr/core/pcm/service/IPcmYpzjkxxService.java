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

import cn.ibizlab.ehr.core.pcm.domain.PcmYpzjkxx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYpzjkxxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYpzjkxx] 服务对象接口
 */
public interface IPcmYpzjkxxService extends IService<PcmYpzjkxx>{

    boolean update(PcmYpzjkxx et) ;
    void updateBatch(List<PcmYpzjkxx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PcmYpzjkxx et) ;
    PcmYpzjkxx get(String key) ;
    PcmYpzjkxx getDraft(PcmYpzjkxx et) ;
    boolean create(PcmYpzjkxx et) ;
    void createBatch(List<PcmYpzjkxx> list) ;
    boolean save(PcmYpzjkxx et) ;
    void saveBatch(List<PcmYpzjkxx> list) ;
    Page<PcmYpzjkxx> searchDefault(PcmYpzjkxxSearchContext context) ;
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

    List<PcmYpzjkxx> getPcmypzjkxxByIds(List<String> ids) ;
    List<PcmYpzjkxx> getPcmypzjkxxByEntities(List<PcmYpzjkxx> entities) ;

}


