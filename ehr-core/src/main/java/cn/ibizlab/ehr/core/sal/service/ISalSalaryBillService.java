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

import cn.ibizlab.ehr.core.sal.domain.SalSalaryBill;
import cn.ibizlab.ehr.core.sal.filter.SalSalaryBillSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalSalaryBill] 服务对象接口
 */
public interface ISalSalaryBillService extends IService<SalSalaryBill>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SalSalaryBill et) ;
    boolean create(SalSalaryBill et) ;
    void createBatch(List<SalSalaryBill> list) ;
    SalSalaryBill getDraft(SalSalaryBill et) ;
    boolean update(SalSalaryBill et) ;
    void updateBatch(List<SalSalaryBill> list) ;
    SalSalaryBill get(String key) ;
    boolean save(SalSalaryBill et) ;
    void saveBatch(List<SalSalaryBill> list) ;
    Page<SalSalaryBill> searchDefault(SalSalaryBillSearchContext context) ;
    List<SalSalaryBill> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<SalSalaryBill> selectByOrmorgid(String orgid) ;
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

    List<SalSalaryBill> getSalsalarybillByIds(List<String> ids) ;
    List<SalSalaryBill> getSalsalarybillByEntities(List<SalSalaryBill> entities) ;

}


