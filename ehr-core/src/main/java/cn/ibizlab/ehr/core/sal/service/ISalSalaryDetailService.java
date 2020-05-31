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

import cn.ibizlab.ehr.core.sal.domain.SalSalaryDetail;
import cn.ibizlab.ehr.core.sal.filter.SalSalaryDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalSalaryDetail] 服务对象接口
 */
public interface ISalSalaryDetailService extends IService<SalSalaryDetail>{

    boolean update(SalSalaryDetail et) ;
    void updateBatch(List<SalSalaryDetail> list) ;
    boolean create(SalSalaryDetail et) ;
    void createBatch(List<SalSalaryDetail> list) ;
    SalSalaryDetail getDraft(SalSalaryDetail et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalSalaryDetail get(String key) ;
    boolean checkKey(SalSalaryDetail et) ;
    boolean save(SalSalaryDetail et) ;
    void saveBatch(List<SalSalaryDetail> list) ;
    Page<SalSalaryDetail> searchDefault(SalSalaryDetailSearchContext context) ;
    List<SalSalaryDetail> selectBySalsalaryid(String salsalaryid) ;
    void removeBySalsalaryid(String salsalaryid) ;
    List<SalSalaryDetail> selectBySalschemeitemid(String salschemeitemid) ;
    void removeBySalschemeitemid(String salschemeitemid) ;
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

    List<SalSalaryDetail> getSalsalarydetailByIds(List<String> ids) ;
    List<SalSalaryDetail> getSalsalarydetailByEntities(List<SalSalaryDetail> entities) ;

}


