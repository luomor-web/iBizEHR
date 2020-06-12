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

import cn.ibizlab.ehr.core.sal.domain.SalPersonStd;
import cn.ibizlab.ehr.core.sal.filter.SalPersonStdSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalPersonStd] 服务对象接口
 */
public interface ISalPersonStdService extends IService<SalPersonStd>{

    boolean save(SalPersonStd et) ;
    void saveBatch(List<SalPersonStd> list) ;
    boolean checkKey(SalPersonStd et) ;
    boolean create(SalPersonStd et) ;
    void createBatch(List<SalPersonStd> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalPersonStd getDraft(SalPersonStd et) ;
    boolean update(SalPersonStd et) ;
    void updateBatch(List<SalPersonStd> list) ;
    SalPersonStd get(String key) ;
    Page<SalPersonStd> searchDefault(SalPersonStdSearchContext context) ;
    List<SalPersonStd> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SalPersonStd> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<SalPersonStd> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SalPersonStd> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<SalPersonStd> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<SalPersonStd> getSalpersonstdByIds(List<String> ids) ;
    List<SalPersonStd> getSalpersonstdByEntities(List<SalPersonStd> entities) ;

}


