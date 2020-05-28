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

import cn.ibizlab.ehr.core.pcm.domain.PCMSYQGZ;
import cn.ibizlab.ehr.core.pcm.filter.PCMSYQGZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMSYQGZ] 服务对象接口
 */
public interface IPCMSYQGZService extends IService<PCMSYQGZ>{

    boolean update(PCMSYQGZ et) ;
    void updateBatch(List<PCMSYQGZ> list) ;
    PCMSYQGZ get(String key) ;
    boolean create(PCMSYQGZ et) ;
    void createBatch(List<PCMSYQGZ> list) ;
    boolean checkKey(PCMSYQGZ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PCMSYQGZ et) ;
    void saveBatch(List<PCMSYQGZ> list) ;
    PCMSYQGZ getDraft(PCMSYQGZ et) ;
    Page<PCMSYQGZ> searchDefault(PCMSYQGZSearchContext context) ;
    List<PCMSYQGZ> selectByOrmorgid(String orgid) ;
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

    List<PCMSYQGZ> getPcmsyqgzByIds(List<String> ids) ;
    List<PCMSYQGZ> getPcmsyqgzByEntities(List<PCMSYQGZ> entities) ;

}


