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

import cn.ibizlab.ehr.core.pcm.domain.PCMGXML;
import cn.ibizlab.ehr.core.pcm.filter.PCMGXMLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMGXML] 服务对象接口
 */
public interface IPCMGXMLService extends IService<PCMGXML>{

    boolean update(PCMGXML et) ;
    void updateBatch(List<PCMGXML> list) ;
    boolean save(PCMGXML et) ;
    void saveBatch(List<PCMGXML> list) ;
    PCMGXML getDraft(PCMGXML et) ;
    boolean checkKey(PCMGXML et) ;
    PCMGXML get(String key) ;
    boolean create(PCMGXML et) ;
    void createBatch(List<PCMGXML> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMGXML> searchDefault(PCMGXMLSearchContext context) ;
    Page<PCMGXML> searchCurND(PCMGXMLSearchContext context) ;
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

    List<PCMGXML> getPcmgxmlByIds(List<String> ids) ;
    List<PCMGXML> getPcmgxmlByEntities(List<PCMGXML> entities) ;

}


