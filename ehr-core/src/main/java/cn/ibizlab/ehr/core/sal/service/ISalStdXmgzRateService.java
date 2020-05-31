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

import cn.ibizlab.ehr.core.sal.domain.SalStdXmgzRate;
import cn.ibizlab.ehr.core.sal.filter.SalStdXmgzRateSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdXmgzRate] 服务对象接口
 */
public interface ISalStdXmgzRateService extends IService<SalStdXmgzRate>{

    SalStdXmgzRate getDraft(SalStdXmgzRate et) ;
    boolean checkKey(SalStdXmgzRate et) ;
    boolean save(SalStdXmgzRate et) ;
    void saveBatch(List<SalStdXmgzRate> list) ;
    boolean create(SalStdXmgzRate et) ;
    void createBatch(List<SalStdXmgzRate> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalStdXmgzRate get(String key) ;
    boolean update(SalStdXmgzRate et) ;
    void updateBatch(List<SalStdXmgzRate> list) ;
    Page<SalStdXmgzRate> searchDefault(SalStdXmgzRateSearchContext context) ;
    List<SalStdXmgzRate> selectByOrmorgid(String orgid) ;
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

    List<SalStdXmgzRate> getSalstdxmgzrateByIds(List<String> ids) ;
    List<SalStdXmgzRate> getSalstdxmgzrateByEntities(List<SalStdXmgzRate> entities) ;

}


