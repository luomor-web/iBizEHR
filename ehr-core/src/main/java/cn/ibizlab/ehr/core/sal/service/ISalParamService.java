package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SalParam;
import cn.ibizlab.ehr.core.sal.filter.SalParamSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalParam] 服务对象接口
 */
public interface ISalParamService extends IService<SalParam>{

    boolean save(SalParam et) ;
    void saveBatch(List<SalParam> list) ;
    SalParam get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SalParam et) ;
    boolean create(SalParam et) ;
    void createBatch(List<SalParam> list) ;
    boolean update(SalParam et) ;
    void updateBatch(List<SalParam> list) ;
    SalParam getDraft(SalParam et) ;
    Page<SalParam> searchDefault(SalParamSearchContext context) ;
    List<SalParam> selectBySalsourceid(String salsourceid) ;
    void removeBySalsourceid(String salsourceid) ;
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

    List<SalParam> getSalparamByIds(List<String> ids) ;
    List<SalParam> getSalparamByEntities(List<SalParam> entities) ;

}


