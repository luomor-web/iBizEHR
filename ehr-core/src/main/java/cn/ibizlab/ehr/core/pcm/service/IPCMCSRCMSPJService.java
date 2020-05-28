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

import cn.ibizlab.ehr.core.pcm.domain.PCMCSRCMSPJ;
import cn.ibizlab.ehr.core.pcm.filter.PCMCSRCMSPJSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMCSRCMSPJ] 服务对象接口
 */
public interface IPCMCSRCMSPJService extends IService<PCMCSRCMSPJ>{

    boolean create(PCMCSRCMSPJ et) ;
    void createBatch(List<PCMCSRCMSPJ> list) ;
    PCMCSRCMSPJ getDraft(PCMCSRCMSPJ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMCSRCMSPJ et) ;
    void updateBatch(List<PCMCSRCMSPJ> list) ;
    boolean save(PCMCSRCMSPJ et) ;
    void saveBatch(List<PCMCSRCMSPJ> list) ;
    boolean checkKey(PCMCSRCMSPJ et) ;
    PCMCSRCMSPJ get(String key) ;
    Page<PCMCSRCMSPJ> searchDefault(PCMCSRCMSPJSearchContext context) ;
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

    List<PCMCSRCMSPJ> getPcmcsrcmspjByIds(List<String> ids) ;
    List<PCMCSRCMSPJ> getPcmcsrcmspjByEntities(List<PCMCSRCMSPJ> entities) ;

}


