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

import cn.ibizlab.ehr.core.sal.domain.SalScheme;
import cn.ibizlab.ehr.core.sal.filter.SalSchemeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalScheme] 服务对象接口
 */
public interface ISalSchemeService extends IService<SalScheme>{

    boolean create(SalScheme et) ;
    void createBatch(List<SalScheme> list) ;
    boolean update(SalScheme et) ;
    void updateBatch(List<SalScheme> list) ;
    SalScheme getDraft(SalScheme et) ;
    boolean save(SalScheme et) ;
    void saveBatch(List<SalScheme> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalScheme get(String key) ;
    boolean checkKey(SalScheme et) ;
    Page<SalScheme> searchDefault(SalSchemeSearchContext context) ;
    List<SalScheme> selectByOrmorgid(String orgid) ;
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

    List<SalScheme> getSalschemeByIds(List<String> ids) ;
    List<SalScheme> getSalschemeByEntities(List<SalScheme> entities) ;

}


