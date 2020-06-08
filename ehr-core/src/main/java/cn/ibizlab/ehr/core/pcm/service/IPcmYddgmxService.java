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

import cn.ibizlab.ehr.core.pcm.domain.PcmYddgmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYddgmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYddgmx] 服务对象接口
 */
public interface IPcmYddgmxService extends IService<PcmYddgmx>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PcmYddgmx et) ;
    PcmYddgmx get(String key) ;
    boolean save(PcmYddgmx et) ;
    void saveBatch(List<PcmYddgmx> list) ;
    boolean create(PcmYddgmx et) ;
    void createBatch(List<PcmYddgmx> list) ;
    PcmYddgmx fillPersonInfo(PcmYddgmx et) ;
    PcmYddgmx getDraft(PcmYddgmx et) ;
    PcmYddgmx qXDG(PcmYddgmx et) ;
    boolean update(PcmYddgmx et) ;
    void updateBatch(List<PcmYddgmx> list) ;
    Page<PcmYddgmx> searchDefault(PcmYddgmxSearchContext context) ;
    Page<PcmYddgmx> searchJLDS(PcmYddgmxSearchContext context) ;
    Page<PcmYddgmx> searchGLDS(PcmYddgmxSearchContext context) ;
    List<PcmYddgmx> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<PcmYddgmx> getPcmyddgmxByIds(List<String> ids) ;
    List<PcmYddgmx> getPcmyddgmxByEntities(List<PcmYddgmx> entities) ;

}


