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

import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZJGWH;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZJGWHSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMXYGZZJGWH] 服务对象接口
 */
public interface IPCMXYGZZJGWHService extends IService<PCMXYGZZJGWH>{

    PCMXYGZZJGWH getDraft(PCMXYGZZJGWH et) ;
    boolean save(PCMXYGZZJGWH et) ;
    void saveBatch(List<PCMXYGZZJGWH> list) ;
    boolean update(PCMXYGZZJGWH et) ;
    void updateBatch(List<PCMXYGZZJGWH> list) ;
    boolean create(PCMXYGZZJGWH et) ;
    void createBatch(List<PCMXYGZZJGWH> list) ;
    boolean checkKey(PCMXYGZZJGWH et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMXYGZZJGWH get(String key) ;
    Page<PCMXYGZZJGWH> searchDefault(PCMXYGZZJGWHSearchContext context) ;
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


