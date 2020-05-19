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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDTXMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDTXMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDTXMX] 服务对象接口
 */
public interface IPCMYDTXMXService extends IService<PCMYDTXMX>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PCMYDTXMX et) ;
    void createBatch(List<PCMYDTXMX> list) ;
    boolean save(PCMYDTXMX et) ;
    void saveBatch(List<PCMYDTXMX> list) ;
    PCMYDTXMX getDraft(PCMYDTXMX et) ;
    PCMYDTXMX get(String key) ;
    boolean checkKey(PCMYDTXMX et) ;
    boolean update(PCMYDTXMX et) ;
    void updateBatch(List<PCMYDTXMX> list) ;
    PCMYDTXMX fillPersonInfo(PCMYDTXMX et) ;
    Page<PCMYDTXMX> searchDefault(PCMYDTXMXSearchContext context) ;
    Page<PCMYDTXMX> searchGLDS(PCMYDTXMXSearchContext context) ;
    Page<PCMYDTXMX> searchJLDS(PCMYDTXMXSearchContext context) ;
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


