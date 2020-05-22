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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDLZMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDLZMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDLZMX] 服务对象接口
 */
public interface IPCMYDLZMXService extends IService<PCMYDLZMX>{

    boolean update(PCMYDLZMX et) ;
    void updateBatch(List<PCMYDLZMX> list) ;
    PCMYDLZMX fillPersonInfo(PCMYDLZMX et) ;
    PCMYDLZMX get(String key) ;
    boolean create(PCMYDLZMX et) ;
    void createBatch(List<PCMYDLZMX> list) ;
    boolean checkKey(PCMYDLZMX et) ;
    PCMYDLZMX finishLZ(PCMYDLZMX et) ;
    PCMYDLZMX getDraft(PCMYDLZMX et) ;
    boolean save(PCMYDLZMX et) ;
    void saveBatch(List<PCMYDLZMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMYDLZMX> searchGLDQ(PCMYDLZMXSearchContext context) ;
    Page<PCMYDLZMX> searchJLDQ(PCMYDLZMXSearchContext context) ;
    Page<PCMYDLZMX> searchDefault(PCMYDLZMXSearchContext context) ;
    List<PCMYDLZMX> selectByLzmtrid(String pimpersonid) ;
    void removeByLzmtrid(String pimpersonid) ;
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


