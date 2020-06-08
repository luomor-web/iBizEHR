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

import cn.ibizlab.ehr.core.pcm.domain.PcmMspjxx;
import cn.ibizlab.ehr.core.pcm.filter.PcmMspjxxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmMspjxx] 服务对象接口
 */
public interface IPcmMspjxxService extends IService<PcmMspjxx>{

    PcmMspjxx getDraft(PcmMspjxx et) ;
    boolean create(PcmMspjxx et) ;
    void createBatch(List<PcmMspjxx> list) ;
    boolean checkKey(PcmMspjxx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmMspjxx get(String key) ;
    boolean save(PcmMspjxx et) ;
    void saveBatch(List<PcmMspjxx> list) ;
    boolean update(PcmMspjxx et) ;
    void updateBatch(List<PcmMspjxx> list) ;
    Page<PcmMspjxx> searchDefault(PcmMspjxxSearchContext context) ;
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

    List<PcmMspjxx> getPcmmspjxxByIds(List<String> ids) ;
    List<PcmMspjxx> getPcmmspjxxByEntities(List<PcmMspjxx> entities) ;

}


