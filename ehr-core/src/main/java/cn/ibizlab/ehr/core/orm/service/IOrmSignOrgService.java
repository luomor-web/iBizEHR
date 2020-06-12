package cn.ibizlab.ehr.core.orm.service;

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

import cn.ibizlab.ehr.core.orm.domain.OrmSignOrg;
import cn.ibizlab.ehr.core.orm.filter.OrmSignOrgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmSignOrg] 服务对象接口
 */
public interface IOrmSignOrgService extends IService<OrmSignOrg>{

    boolean checkKey(OrmSignOrg et) ;
    boolean update(OrmSignOrg et) ;
    void updateBatch(List<OrmSignOrg> list) ;
    boolean save(OrmSignOrg et) ;
    void saveBatch(List<OrmSignOrg> list) ;
    OrmSignOrg getDraft(OrmSignOrg et) ;
    OrmSignOrg get(String key) ;
    boolean create(OrmSignOrg et) ;
    void createBatch(List<OrmSignOrg> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<OrmSignOrg> searchHTQDDW(OrmSignOrgSearchContext context) ;
    Page<OrmSignOrg> searchDefault(OrmSignOrgSearchContext context) ;
    Page<OrmSignOrg> searchCKBDWDFRZT(OrmSignOrgSearchContext context) ;
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

    List<OrmSignOrg> getOrmsignorgByIds(List<String> ids) ;
    List<OrmSignOrg> getOrmsignorgByEntities(List<OrmSignOrg> entities) ;

}


