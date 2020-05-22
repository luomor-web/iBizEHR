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

import cn.ibizlab.ehr.core.pcm.domain.PCMReason;
import cn.ibizlab.ehr.core.pcm.filter.PCMReasonSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMReason] 服务对象接口
 */
public interface IPCMReasonService extends IService<PCMReason>{

    PCMReason getDraft(PCMReason et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMReason et) ;
    void updateBatch(List<PCMReason> list) ;
    PCMReason get(String key) ;
    boolean create(PCMReason et) ;
    void createBatch(List<PCMReason> list) ;
    boolean checkKey(PCMReason et) ;
    boolean save(PCMReason et) ;
    void saveBatch(List<PCMReason> list) ;
    Page<PCMReason> searchDefault(PCMReasonSearchContext context) ;
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


