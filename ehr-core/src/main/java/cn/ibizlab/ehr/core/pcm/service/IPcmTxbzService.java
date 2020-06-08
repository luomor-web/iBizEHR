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

import cn.ibizlab.ehr.core.pcm.domain.PcmTxbz;
import cn.ibizlab.ehr.core.pcm.filter.PcmTxbzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmTxbz] 服务对象接口
 */
public interface IPcmTxbzService extends IService<PcmTxbz>{

    boolean checkKey(PcmTxbz et) ;
    PcmTxbz get(String key) ;
    PcmTxbz getDraft(PcmTxbz et) ;
    boolean update(PcmTxbz et) ;
    void updateBatch(List<PcmTxbz> list) ;
    boolean create(PcmTxbz et) ;
    void createBatch(List<PcmTxbz> list) ;
    boolean save(PcmTxbz et) ;
    void saveBatch(List<PcmTxbz> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmTxbz> searchDefault(PcmTxbzSearchContext context) ;
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

    List<PcmTxbz> getPcmtxbzByIds(List<String> ids) ;
    List<PcmTxbz> getPcmtxbzByEntities(List<PcmTxbz> entities) ;

}


