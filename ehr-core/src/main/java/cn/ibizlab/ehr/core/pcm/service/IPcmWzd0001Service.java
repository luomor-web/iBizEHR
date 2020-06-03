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

import cn.ibizlab.ehr.core.pcm.domain.PcmWzd0001;
import cn.ibizlab.ehr.core.pcm.filter.PcmWzd0001SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmWzd0001] 服务对象接口
 */
public interface IPcmWzd0001Service extends IService<PcmWzd0001>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmWzd0001 getDraft(PcmWzd0001 et) ;
    boolean save(PcmWzd0001 et) ;
    void saveBatch(List<PcmWzd0001> list) ;
    PcmWzd0001 get(String key) ;
    boolean update(PcmWzd0001 et) ;
    void updateBatch(List<PcmWzd0001> list) ;
    boolean checkKey(PcmWzd0001 et) ;
    boolean create(PcmWzd0001 et) ;
    void createBatch(List<PcmWzd0001> list) ;
    PcmWzd0001 updatePeopleNum(PcmWzd0001 et) ;
    Page<PcmWzd0001> searchDefault(PcmWzd0001SearchContext context) ;
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

    List<PcmWzd0001> getPcmwzd0001ByIds(List<String> ids) ;
    List<PcmWzd0001> getPcmwzd0001ByEntities(List<PcmWzd0001> entities) ;

}


