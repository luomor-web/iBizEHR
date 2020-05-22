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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDJPMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJPMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDJPMX] 服务对象接口
 */
public interface IPCMYDJPMXService extends IService<PCMYDJPMX>{

    PCMYDJPMX fillPersonInfo(PCMYDJPMX et) ;
    boolean update(PCMYDJPMX et) ;
    void updateBatch(List<PCMYDJPMX> list) ;
    PCMYDJPMX getDraft(PCMYDJPMX et) ;
    boolean checkKey(PCMYDJPMX et) ;
    boolean save(PCMYDJPMX et) ;
    void saveBatch(List<PCMYDJPMX> list) ;
    PCMYDJPMX get(String key) ;
    PCMYDJPMX jPWC(PCMYDJPMX et) ;
    boolean create(PCMYDJPMX et) ;
    void createBatch(List<PCMYDJPMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMYDJPMX> searchJLDS(PCMYDJPMXSearchContext context) ;
    Page<PCMYDJPMX> searchDefault(PCMYDJPMXSearchContext context) ;
    Page<PCMYDJPMX> searchGLDS(PCMYDJPMXSearchContext context) ;
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


