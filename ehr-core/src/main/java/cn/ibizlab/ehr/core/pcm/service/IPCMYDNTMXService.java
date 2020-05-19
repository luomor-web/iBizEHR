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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDNTMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDNTMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDNTMX] 服务对象接口
 */
public interface IPCMYDNTMXService extends IService<PCMYDNTMX>{

    PCMYDNTMX getDraft(PCMYDNTMX et) ;
    boolean checkKey(PCMYDNTMX et) ;
    PCMYDNTMX get(String key) ;
    boolean create(PCMYDNTMX et) ;
    void createBatch(List<PCMYDNTMX> list) ;
    boolean save(PCMYDNTMX et) ;
    void saveBatch(List<PCMYDNTMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMYDNTMX fillPersonInfo(PCMYDNTMX et) ;
    boolean update(PCMYDNTMX et) ;
    void updateBatch(List<PCMYDNTMX> list) ;
    PCMYDNTMX finishNT(PCMYDNTMX et) ;
    Page<PCMYDNTMX> searchJLDS(PCMYDNTMXSearchContext context) ;
    Page<PCMYDNTMX> searchDefault(PCMYDNTMXSearchContext context) ;
    Page<PCMYDNTMX> searchGLDS(PCMYDNTMXSearchContext context) ;
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


