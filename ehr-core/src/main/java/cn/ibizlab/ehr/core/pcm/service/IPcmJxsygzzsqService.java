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

import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzsqSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmJxsygzzsq] 服务对象接口
 */
public interface IPcmJxsygzzsqService extends IService<PcmJxsygzzsq>{

    boolean update(PcmJxsygzzsq et) ;
    void updateBatch(List<PcmJxsygzzsq> list) ;
    boolean save(PcmJxsygzzsq et) ;
    void saveBatch(List<PcmJxsygzzsq> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PcmJxsygzzsq et) ;
    PcmJxsygzzsq getDraft(PcmJxsygzzsq et) ;
    boolean create(PcmJxsygzzsq et) ;
    void createBatch(List<PcmJxsygzzsq> list) ;
    PcmJxsygzzsq get(String key) ;
    Page<PcmJxsygzzsq> searchDefault(PcmJxsygzzsqSearchContext context) ;
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

    List<PcmJxsygzzsq> getPcmjxsygzzsqByIds(List<String> ids) ;
    List<PcmJxsygzzsq> getPcmjxsygzzsqByEntities(List<PcmJxsygzzsq> entities) ;

}


