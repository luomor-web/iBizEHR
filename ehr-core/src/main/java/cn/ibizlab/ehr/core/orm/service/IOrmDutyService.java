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

import cn.ibizlab.ehr.core.orm.domain.OrmDuty;
import cn.ibizlab.ehr.core.orm.filter.OrmDutySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmDuty] 服务对象接口
 */
public interface IOrmDutyService extends IService<OrmDuty>{

    boolean create(OrmDuty et) ;
    void createBatch(List<OrmDuty> list) ;
    OrmDuty synOrderNum(OrmDuty et) ;
    boolean update(OrmDuty et) ;
    void updateBatch(List<OrmDuty> list) ;
    OrmDuty getDraft(OrmDuty et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(OrmDuty et) ;
    OrmDuty get(String key) ;
    boolean save(OrmDuty et) ;
    void saveBatch(List<OrmDuty> list) ;
    Page<OrmDuty> searchBasDuty(OrmDutySearchContext context) ;
    Page<OrmDuty> searchCurOrgsector(OrmDutySearchContext context) ;
    Page<OrmDuty> searchSrfOrgData(OrmDutySearchContext context) ;
    Page<OrmDuty> searchDefault(OrmDutySearchContext context) ;
    Page<OrmDuty> searchCurOrg(OrmDutySearchContext context) ;
    Page<OrmDuty> searchCurOrmorgsector(OrmDutySearchContext context) ;
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

    List<OrmDuty> getOrmdutyByIds(List<String> ids) ;
    List<OrmDuty> getOrmdutyByEntities(List<OrmDuty> entities) ;

}


