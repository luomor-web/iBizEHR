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

import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzjgwh;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzjgwhSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmXygzzjgwh] 服务对象接口
 */
public interface IPcmXygzzjgwhService extends IService<PcmXygzzjgwh>{

    PcmXygzzjgwh getDraft(PcmXygzzjgwh et) ;
    boolean save(PcmXygzzjgwh et) ;
    void saveBatch(List<PcmXygzzjgwh> list) ;
    boolean update(PcmXygzzjgwh et) ;
    void updateBatch(List<PcmXygzzjgwh> list) ;
    boolean create(PcmXygzzjgwh et) ;
    void createBatch(List<PcmXygzzjgwh> list) ;
    boolean checkKey(PcmXygzzjgwh et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmXygzzjgwh get(String key) ;
    Page<PcmXygzzjgwh> searchDefault(PcmXygzzjgwhSearchContext context) ;
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

    List<PcmXygzzjgwh> getPcmxygzzjgwhByIds(List<String> ids) ;
    List<PcmXygzzjgwh> getPcmxygzzjgwhByEntities(List<PcmXygzzjgwh> entities) ;

}


