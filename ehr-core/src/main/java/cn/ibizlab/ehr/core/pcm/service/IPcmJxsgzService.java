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

import cn.ibizlab.ehr.core.pcm.domain.PcmJxsgz;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsgzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmJxsgz] 服务对象接口
 */
public interface IPcmJxsgzService extends IService<PcmJxsgz>{

    boolean checkKey(PcmJxsgz et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PcmJxsgz et) ;
    void updateBatch(List<PcmJxsgz> list) ;
    PcmJxsgz get(String key) ;
    PcmJxsgz getDraft(PcmJxsgz et) ;
    boolean create(PcmJxsgz et) ;
    void createBatch(List<PcmJxsgz> list) ;
    boolean save(PcmJxsgz et) ;
    void saveBatch(List<PcmJxsgz> list) ;
    Page<PcmJxsgz> searchDefault(PcmJxsgzSearchContext context) ;
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

    List<PcmJxsgz> getPcmjxsgzByIds(List<String> ids) ;
    List<PcmJxsgz> getPcmjxsgzByEntities(List<PcmJxsgz> entities) ;

}


