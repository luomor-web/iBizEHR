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

import cn.ibizlab.ehr.core.pcm.domain.PcmLog;
import cn.ibizlab.ehr.core.pcm.filter.PcmLogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmLog] 服务对象接口
 */
public interface IPcmLogService extends IService<PcmLog>{

    boolean create(PcmLog et) ;
    void createBatch(List<PcmLog> list) ;
    boolean update(PcmLog et) ;
    void updateBatch(List<PcmLog> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmLog getDraft(PcmLog et) ;
    PcmLog get(String key) ;
    boolean checkKey(PcmLog et) ;
    boolean save(PcmLog et) ;
    void saveBatch(List<PcmLog> list) ;
    Page<PcmLog> searchDefault(PcmLogSearchContext context) ;
    List<PcmLog> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmLog> getPcmlogByIds(List<String> ids) ;
    List<PcmLog> getPcmlogByEntities(List<PcmLog> entities) ;

}


