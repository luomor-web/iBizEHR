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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDDGMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDDGMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDDGMX] 服务对象接口
 */
public interface IPCMYDDGMXService extends IService<PCMYDDGMX>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMYDDGMX et) ;
    PCMYDDGMX get(String key) ;
    boolean save(PCMYDDGMX et) ;
    void saveBatch(List<PCMYDDGMX> list) ;
    boolean create(PCMYDDGMX et) ;
    void createBatch(List<PCMYDDGMX> list) ;
    PCMYDDGMX fillPersonInfo(PCMYDDGMX et) ;
    PCMYDDGMX getDraft(PCMYDDGMX et) ;
    PCMYDDGMX qXDG(PCMYDDGMX et) ;
    boolean update(PCMYDDGMX et) ;
    void updateBatch(List<PCMYDDGMX> list) ;
    Page<PCMYDDGMX> searchDefault(PCMYDDGMXSearchContext context) ;
    Page<PCMYDDGMX> searchJLDS(PCMYDDGMXSearchContext context) ;
    Page<PCMYDDGMX> searchGLDS(PCMYDDGMXSearchContext context) ;
    List<PCMYDDGMX> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<PCMYDDGMX> getPcmyddgmxByIds(List<String> ids) ;
    List<PCMYDDGMX> getPcmyddgmxByEntities(List<PCMYDDGMX> entities) ;

}


