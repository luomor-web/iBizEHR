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

import cn.ibizlab.ehr.core.pcm.domain.PCMTXBZ;
import cn.ibizlab.ehr.core.pcm.filter.PCMTXBZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMTXBZ] 服务对象接口
 */
public interface IPCMTXBZService extends IService<PCMTXBZ>{

    boolean checkKey(PCMTXBZ et) ;
    PCMTXBZ get(String key) ;
    PCMTXBZ getDraft(PCMTXBZ et) ;
    boolean update(PCMTXBZ et) ;
    void updateBatch(List<PCMTXBZ> list) ;
    boolean create(PCMTXBZ et) ;
    void createBatch(List<PCMTXBZ> list) ;
    boolean save(PCMTXBZ et) ;
    void saveBatch(List<PCMTXBZ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMTXBZ> searchDefault(PCMTXBZSearchContext context) ;
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

    List<PCMTXBZ> getPcmtxbzByIds(List<String> ids) ;
    List<PCMTXBZ> getPcmtxbzByEntities(List<PCMTXBZ> entities) ;

}


