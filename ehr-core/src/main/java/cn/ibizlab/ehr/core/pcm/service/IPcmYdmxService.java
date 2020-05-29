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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdmx] 服务对象接口
 */
public interface IPcmYdmxService extends IService<PcmYdmx>{

    boolean create(PcmYdmx et) ;
    void createBatch(List<PcmYdmx> list) ;
    boolean save(PcmYdmx et) ;
    void saveBatch(List<PcmYdmx> list) ;
    PcmYdmx fillPersonInfo(PcmYdmx et) ;
    boolean checkKey(PcmYdmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PcmYdmx et) ;
    void updateBatch(List<PcmYdmx> list) ;
    PcmYdmx getDraft(PcmYdmx et) ;
    PcmYdmx get(String key) ;
    Page<PcmYdmx> searchIndexDER(PcmYdmxSearchContext context) ;
    Page<PcmYdmx> searchDefault(PcmYdmxSearchContext context) ;
    List<PcmYdmx> selectByBmid(String orgsectorid) ;
    void removeByBmid(String orgsectorid) ;
    List<PcmYdmx> selectByZzid(String orgid) ;
    void removeByZzid(String orgid) ;
    List<PcmYdmx> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<PcmYdmx> getPcmydmxByIds(List<String> ids) ;
    List<PcmYdmx> getPcmydmxByEntities(List<PcmYdmx> entities) ;

}


