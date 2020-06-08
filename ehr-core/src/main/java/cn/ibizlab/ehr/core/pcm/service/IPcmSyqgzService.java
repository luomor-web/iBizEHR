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

import cn.ibizlab.ehr.core.pcm.domain.PcmSyqgz;
import cn.ibizlab.ehr.core.pcm.filter.PcmSyqgzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmSyqgz] 服务对象接口
 */
public interface IPcmSyqgzService extends IService<PcmSyqgz>{

    boolean update(PcmSyqgz et) ;
    void updateBatch(List<PcmSyqgz> list) ;
    PcmSyqgz get(String key) ;
    boolean create(PcmSyqgz et) ;
    void createBatch(List<PcmSyqgz> list) ;
    boolean checkKey(PcmSyqgz et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PcmSyqgz et) ;
    void saveBatch(List<PcmSyqgz> list) ;
    PcmSyqgz getDraft(PcmSyqgz et) ;
    Page<PcmSyqgz> searchDefault(PcmSyqgzSearchContext context) ;
    List<PcmSyqgz> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<PcmSyqgz> getPcmsyqgzByIds(List<String> ids) ;
    List<PcmSyqgz> getPcmsyqgzByEntities(List<PcmSyqgz> entities) ;

}


