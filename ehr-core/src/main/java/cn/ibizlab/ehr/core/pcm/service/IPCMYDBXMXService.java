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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDBXMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDBXMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDBXMX] 服务对象接口
 */
public interface IPCMYDBXMXService extends IService<PCMYDBXMX>{

    PCMYDBXMX get(String key) ;
    PCMYDBXMX fillPersonInfo(PCMYDBXMX et) ;
    PCMYDBXMX getDraft(PCMYDBXMX et) ;
    boolean update(PCMYDBXMX et) ;
    void updateBatch(List<PCMYDBXMX> list) ;
    boolean checkKey(PCMYDBXMX et) ;
    boolean save(PCMYDBXMX et) ;
    void saveBatch(List<PCMYDBXMX> list) ;
    PCMYDBXMX finishBX(PCMYDBXMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PCMYDBXMX et) ;
    void createBatch(List<PCMYDBXMX> list) ;
    Page<PCMYDBXMX> searchGLDS(PCMYDBXMXSearchContext context) ;
    Page<PCMYDBXMX> searchDefault(PCMYDBXMXSearchContext context) ;
    Page<PCMYDBXMX> searchJLDS(PCMYDBXMXSearchContext context) ;
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

    List<PCMYDBXMX> getPcmydbxmxByIds(List<String> ids) ;
    List<PCMYDBXMX> getPcmydbxmxByEntities(List<PCMYDBXMX> entities) ;

}


