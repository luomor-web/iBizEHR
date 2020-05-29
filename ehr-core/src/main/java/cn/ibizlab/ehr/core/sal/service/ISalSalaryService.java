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

import cn.ibizlab.ehr.core.sal.domain.SalSalary;
import cn.ibizlab.ehr.core.sal.filter.SalSalarySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalSalary] 服务对象接口
 */
public interface ISalSalaryService extends IService<SalSalary>{

    boolean save(SalSalary et) ;
    void saveBatch(List<SalSalary> list) ;
    boolean checkKey(SalSalary et) ;
    SalSalary get(String key) ;
    SalSalary getDraft(SalSalary et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SalSalary et) ;
    void createBatch(List<SalSalary> list) ;
    boolean update(SalSalary et) ;
    void updateBatch(List<SalSalary> list) ;
    Page<SalSalary> searchDefault(SalSalarySearchContext context) ;
    List<SalSalary> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SalSalary> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<SalSalary> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SalSalary> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<SalSalary> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<SalSalary> selectBySalplanid(String salplanid) ;
    void removeBySalplanid(String salplanid) ;
    List<SalSalary> selectBySalsalarybillid(String salsalarybillid) ;
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

    List<SalSalary> getSalsalaryByIds(List<String> ids) ;
    List<SalSalary> getSalsalaryByEntities(List<SalSalary> entities) ;

}


