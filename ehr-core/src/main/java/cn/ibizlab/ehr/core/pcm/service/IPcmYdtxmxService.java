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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdtxmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdtxmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdtxmx] 服务对象接口
 */
public interface IPcmYdtxmxService extends IService<PcmYdtxmx>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PcmYdtxmx et) ;
    void createBatch(List<PcmYdtxmx> list) ;
    boolean save(PcmYdtxmx et) ;
    void saveBatch(List<PcmYdtxmx> list) ;
    PcmYdtxmx getDraft(PcmYdtxmx et) ;
    PcmYdtxmx get(String key) ;
    boolean checkKey(PcmYdtxmx et) ;
    boolean update(PcmYdtxmx et) ;
    void updateBatch(List<PcmYdtxmx> list) ;
    PcmYdtxmx fillPersonInfo(PcmYdtxmx et) ;
    Page<PcmYdtxmx> searchDefault(PcmYdtxmxSearchContext context) ;
    Page<PcmYdtxmx> searchGLDS(PcmYdtxmxSearchContext context) ;
    Page<PcmYdtxmx> searchJLDS(PcmYdtxmxSearchContext context) ;
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

    List<PcmYdtxmx> getPcmydtxmxByIds(List<String> ids) ;
    List<PcmYdtxmx> getPcmydtxmxByEntities(List<PcmYdtxmx> entities) ;

}


