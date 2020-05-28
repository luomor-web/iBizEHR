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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDGZMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDGZMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDGZMX] 服务对象接口
 */
public interface IPCMYDGZMXService extends IService<PCMYDGZMX>{

    PCMYDGZMX rYHG(PCMYDGZMX et) ;
    PCMYDGZMX getDraft(PCMYDGZMX et) ;
    boolean update(PCMYDGZMX et) ;
    void updateBatch(List<PCMYDGZMX> list) ;
    PCMYDGZMX get(String key) ;
    PCMYDGZMX fillPersonInfo(PCMYDGZMX et) ;
    boolean create(PCMYDGZMX et) ;
    void createBatch(List<PCMYDGZMX> list) ;
    boolean save(PCMYDGZMX et) ;
    void saveBatch(List<PCMYDGZMX> list) ;
    boolean checkKey(PCMYDGZMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMYDGZMX> searchGZCRYDQ(PCMYDGZMXSearchContext context) ;
    Page<PCMYDGZMX> searchGZJLSJLDQ(PCMYDGZMXSearchContext context) ;
    Page<PCMYDGZMX> searchGZJRY(PCMYDGZMXSearchContext context) ;
    Page<PCMYDGZMX> searchDefault(PCMYDGZMXSearchContext context) ;
    Page<PCMYDGZMX> searchGZCLSJLDQ(PCMYDGZMXSearchContext context) ;
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

    List<PCMYDGZMX> getPcmydgzmxByIds(List<String> ids) ;
    List<PCMYDGZMX> getPcmydgzmxByEntities(List<PCMYDGZMX> entities) ;

}


