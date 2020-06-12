package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParLdkhqz;
import cn.ibizlab.ehr.core.par.filter.ParLdkhqzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParLdkhqz] 服务对象接口
 */
public interface IParLdkhqzService extends IService<ParLdkhqz>{

    boolean checkKey(ParLdkhqz et) ;
    boolean create(ParLdkhqz et) ;
    void createBatch(List<ParLdkhqz> list) ;
    ParLdkhqz getDraft(ParLdkhqz et) ;
    ParLdkhqz get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParLdkhqz et) ;
    void saveBatch(List<ParLdkhqz> list) ;
    boolean update(ParLdkhqz et) ;
    void updateBatch(List<ParLdkhqz> list) ;
    Page<ParLdkhqz> searchDefault(ParLdkhqzSearchContext context) ;
    List<ParLdkhqz> selectByParkhzcmxid(String parkhzcmxid) ;
    void removeByParkhzcmxid(String parkhzcmxid) ;
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

    List<ParLdkhqz> getParldkhqzByIds(List<String> ids) ;
    List<ParLdkhqz> getParldkhqzByEntities(List<ParLdkhqz> entities) ;

}


