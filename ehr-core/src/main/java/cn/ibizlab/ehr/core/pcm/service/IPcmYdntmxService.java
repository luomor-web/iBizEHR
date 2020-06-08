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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdntmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdntmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdntmx] 服务对象接口
 */
public interface IPcmYdntmxService extends IService<PcmYdntmx>{

    PcmYdntmx getDraft(PcmYdntmx et) ;
    boolean checkKey(PcmYdntmx et) ;
    PcmYdntmx get(String key) ;
    boolean create(PcmYdntmx et) ;
    void createBatch(List<PcmYdntmx> list) ;
    boolean save(PcmYdntmx et) ;
    void saveBatch(List<PcmYdntmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmYdntmx fillPersonInfo(PcmYdntmx et) ;
    boolean update(PcmYdntmx et) ;
    void updateBatch(List<PcmYdntmx> list) ;
    PcmYdntmx finishNT(PcmYdntmx et) ;
    Page<PcmYdntmx> searchJLDS(PcmYdntmxSearchContext context) ;
    Page<PcmYdntmx> searchDefault(PcmYdntmxSearchContext context) ;
    Page<PcmYdntmx> searchGLDS(PcmYdntmxSearchContext context) ;
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

    List<PcmYdntmx> getPcmydntmxByIds(List<String> ids) ;
    List<PcmYdntmx> getPcmydntmxByEntities(List<PcmYdntmx> entities) ;

}


