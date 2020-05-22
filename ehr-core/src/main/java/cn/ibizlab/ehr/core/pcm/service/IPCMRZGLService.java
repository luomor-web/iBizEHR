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

import cn.ibizlab.ehr.core.pcm.domain.PCMRZGL;
import cn.ibizlab.ehr.core.pcm.filter.PCMRZGLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMRZGL] 服务对象接口
 */
public interface IPCMRZGLService extends IService<PCMRZGL>{

    PCMRZGL get(String key) ;
    boolean save(PCMRZGL et) ;
    void saveBatch(List<PCMRZGL> list) ;
    boolean checkKey(PCMRZGL et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PCMRZGL et) ;
    void createBatch(List<PCMRZGL> list) ;
    PCMRZGL getDraft(PCMRZGL et) ;
    boolean update(PCMRZGL et) ;
    void updateBatch(List<PCMRZGL> list) ;
    Page<PCMRZGL> searchDefault(PCMRZGLSearchContext context) ;
    Page<PCMRZGL> searchGBRZQXDQ(PCMRZGLSearchContext context) ;
    Page<PCMRZGL> searchRQCX(PCMRZGLSearchContext context) ;
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

}


