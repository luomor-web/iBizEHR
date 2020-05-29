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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdgzmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdgzmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdgzmx] 服务对象接口
 */
public interface IPcmYdgzmxService extends IService<PcmYdgzmx>{

    PcmYdgzmx rYHG(PcmYdgzmx et) ;
    PcmYdgzmx getDraft(PcmYdgzmx et) ;
    boolean update(PcmYdgzmx et) ;
    void updateBatch(List<PcmYdgzmx> list) ;
    PcmYdgzmx get(String key) ;
    PcmYdgzmx fillPersonInfo(PcmYdgzmx et) ;
    boolean create(PcmYdgzmx et) ;
    void createBatch(List<PcmYdgzmx> list) ;
    boolean save(PcmYdgzmx et) ;
    void saveBatch(List<PcmYdgzmx> list) ;
    boolean checkKey(PcmYdgzmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmYdgzmx> searchGZCRYDQ(PcmYdgzmxSearchContext context) ;
    Page<PcmYdgzmx> searchGZJLSJLDQ(PcmYdgzmxSearchContext context) ;
    Page<PcmYdgzmx> searchGZJRY(PcmYdgzmxSearchContext context) ;
    Page<PcmYdgzmx> searchDefault(PcmYdgzmxSearchContext context) ;
    Page<PcmYdgzmx> searchGZCLSJLDQ(PcmYdgzmxSearchContext context) ;
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

    List<PcmYdgzmx> getPcmydgzmxByIds(List<String> ids) ;
    List<PcmYdgzmx> getPcmydgzmxByEntities(List<PcmYdgzmx> entities) ;

}


