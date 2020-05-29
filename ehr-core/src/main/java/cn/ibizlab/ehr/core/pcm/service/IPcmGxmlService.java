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

import cn.ibizlab.ehr.core.pcm.domain.PcmGxml;
import cn.ibizlab.ehr.core.pcm.filter.PcmGxmlSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmGxml] 服务对象接口
 */
public interface IPcmGxmlService extends IService<PcmGxml>{

    boolean update(PcmGxml et) ;
    void updateBatch(List<PcmGxml> list) ;
    boolean save(PcmGxml et) ;
    void saveBatch(List<PcmGxml> list) ;
    PcmGxml getDraft(PcmGxml et) ;
    boolean checkKey(PcmGxml et) ;
    PcmGxml get(String key) ;
    boolean create(PcmGxml et) ;
    void createBatch(List<PcmGxml> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmGxml> searchDefault(PcmGxmlSearchContext context) ;
    Page<PcmGxml> searchCurND(PcmGxmlSearchContext context) ;
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

    List<PcmGxml> getPcmgxmlByIds(List<String> ids) ;
    List<PcmGxml> getPcmgxmlByEntities(List<PcmGxml> entities) ;

}


