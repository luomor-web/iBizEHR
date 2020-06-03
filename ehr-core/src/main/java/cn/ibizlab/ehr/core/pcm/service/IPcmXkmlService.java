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

import cn.ibizlab.ehr.core.pcm.domain.PcmXkml;
import cn.ibizlab.ehr.core.pcm.filter.PcmXkmlSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmXkml] 服务对象接口
 */
public interface IPcmXkmlService extends IService<PcmXkml>{

    boolean update(PcmXkml et) ;
    void updateBatch(List<PcmXkml> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmXkml get(String key) ;
    boolean create(PcmXkml et) ;
    void createBatch(List<PcmXkml> list) ;
    boolean save(PcmXkml et) ;
    void saveBatch(List<PcmXkml> list) ;
    boolean checkKey(PcmXkml et) ;
    PcmXkml getDraft(PcmXkml et) ;
    Page<PcmXkml> searchDefault(PcmXkmlSearchContext context) ;
    Page<PcmXkml> searchCurND(PcmXkmlSearchContext context) ;
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

    List<PcmXkml> getPcmxkmlByIds(List<String> ids) ;
    List<PcmXkml> getPcmxkmlByEntities(List<PcmXkml> entities) ;

}


