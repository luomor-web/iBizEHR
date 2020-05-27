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

import cn.ibizlab.ehr.core.pcm.domain.PCMZSGL;
import cn.ibizlab.ehr.core.pcm.filter.PCMZSGLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMZSGL] 服务对象接口
 */
public interface IPCMZSGLService extends IService<PCMZSGL>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMZSGL get(String key) ;
    PCMZSGL getDraft(PCMZSGL et) ;
    boolean checkKey(PCMZSGL et) ;
    boolean update(PCMZSGL et) ;
    void updateBatch(List<PCMZSGL> list) ;
    boolean save(PCMZSGL et) ;
    void saveBatch(List<PCMZSGL> list) ;
    boolean create(PCMZSGL et) ;
    void createBatch(List<PCMZSGL> list) ;
    Page<PCMZSGL> searchDefault(PCMZSGLSearchContext context) ;
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

    List<PCMZSGL> getPcmzsglByIds(List<String> ids) ;
    List<PCMZSGL> getPcmzsglByEntities(List<PCMZSGL> entities) ;

}


