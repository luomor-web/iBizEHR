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

import cn.ibizlab.ehr.core.sal.domain.SALSALARY;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSALARY] 服务对象接口
 */
public interface ISALSALARYService extends IService<SALSALARY>{

    boolean save(SALSALARY et) ;
    void saveBatch(List<SALSALARY> list) ;
    boolean checkKey(SALSALARY et) ;
    SALSALARY get(String key) ;
    SALSALARY getDraft(SALSALARY et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SALSALARY et) ;
    void createBatch(List<SALSALARY> list) ;
    boolean update(SALSALARY et) ;
    void updateBatch(List<SALSALARY> list) ;
    Page<SALSALARY> searchDefault(SALSALARYSearchContext context) ;
    List<SALSALARY> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SALSALARY> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<SALSALARY> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SALSALARY> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<SALSALARY> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<SALSALARY> selectBySalplanid(String salplanid) ;
    void removeBySalplanid(String salplanid) ;
    List<SALSALARY> selectBySalsalarybillid(String salsalarybillid) ;
    void removeBySalsalarybillid(String salsalarybillid) ;
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

    List<SALSALARY> getSalsalaryByIds(List<String> ids) ;
    List<SALSALARY> getSalsalaryByEntities(List<SALSALARY> entities) ;

}


