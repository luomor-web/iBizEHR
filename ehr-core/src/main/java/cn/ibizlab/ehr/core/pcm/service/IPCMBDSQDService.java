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

import cn.ibizlab.ehr.core.pcm.domain.PCMBDSQD;
import cn.ibizlab.ehr.core.pcm.filter.PCMBDSQDSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMBDSQD] 服务对象接口
 */
public interface IPCMBDSQDService extends IService<PCMBDSQD>{

    boolean update(PCMBDSQD et) ;
    void updateBatch(List<PCMBDSQD> list) ;
    boolean save(PCMBDSQD et) ;
    void saveBatch(List<PCMBDSQD> list) ;
    PCMBDSQD get(String key) ;
    PCMBDSQD getDraft(PCMBDSQD et) ;
    boolean create(PCMBDSQD et) ;
    void createBatch(List<PCMBDSQD> list) ;
    boolean checkKey(PCMBDSQD et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMBDSQD> searchDefault(PCMBDSQDSearchContext context) ;
    List<PCMBDSQD> selectByPimpersonid(String pimpersonid) ;
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

    List<PCMBDSQD> getPcmbdsqdByIds(List<String> ids) ;
    List<PCMBDSQD> getPcmbdsqdByEntities(List<PCMBDSQD> entities) ;

}


