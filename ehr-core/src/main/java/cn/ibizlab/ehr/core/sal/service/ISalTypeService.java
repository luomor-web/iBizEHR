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

import cn.ibizlab.ehr.core.sal.domain.SalType;
import cn.ibizlab.ehr.core.sal.filter.SalTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalType] 服务对象接口
 */
public interface ISalTypeService extends IService<SalType>{

    boolean checkKey(SalType et) ;
    SalType get(String key) ;
    SalType getDraft(SalType et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SalType et) ;
    void saveBatch(List<SalType> list) ;
    boolean create(SalType et) ;
    void createBatch(List<SalType> list) ;
    boolean update(SalType et) ;
    void updateBatch(List<SalType> list) ;
    Page<SalType> searchDefault(SalTypeSearchContext context) ;
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

    List<SalType> getSaltypeByIds(List<String> ids) ;
    List<SalType> getSaltypeByEntities(List<SalType> entities) ;

}


