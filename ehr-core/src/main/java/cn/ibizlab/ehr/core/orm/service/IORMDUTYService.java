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

import cn.ibizlab.ehr.core.orm.domain.ORMDUTY;
import cn.ibizlab.ehr.core.orm.filter.ORMDUTYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMDUTY] 服务对象接口
 */
public interface IORMDUTYService extends IService<ORMDUTY>{

    boolean create(ORMDUTY et) ;
    void createBatch(List<ORMDUTY> list) ;
    ORMDUTY synOrderNum(ORMDUTY et) ;
    boolean update(ORMDUTY et) ;
    void updateBatch(List<ORMDUTY> list) ;
    ORMDUTY getDraft(ORMDUTY et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ORMDUTY et) ;
    ORMDUTY get(String key) ;
    boolean save(ORMDUTY et) ;
    void saveBatch(List<ORMDUTY> list) ;
    Page<ORMDUTY> searchBasDuty(ORMDUTYSearchContext context) ;
    Page<ORMDUTY> searchCurOrgsector(ORMDUTYSearchContext context) ;
    Page<ORMDUTY> searchSrfOrgData(ORMDUTYSearchContext context) ;
    Page<ORMDUTY> searchDefault(ORMDUTYSearchContext context) ;
    Page<ORMDUTY> searchCurOrg(ORMDUTYSearchContext context) ;
    Page<ORMDUTY> searchCurOrmorgsector(ORMDUTYSearchContext context) ;
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

}


