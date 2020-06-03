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

import cn.ibizlab.ehr.core.sal.domain.SalLog;
import cn.ibizlab.ehr.core.sal.filter.SalLogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalLog] 服务对象接口
 */
public interface ISalLogService extends IService<SalLog>{

    SalLog get(String key) ;
    boolean update(SalLog et) ;
    void updateBatch(List<SalLog> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SalLog et) ;
    void createBatch(List<SalLog> list) ;
    boolean save(SalLog et) ;
    void saveBatch(List<SalLog> list) ;
    SalLog getDraft(SalLog et) ;
    boolean checkKey(SalLog et) ;
    Page<SalLog> searchDefault(SalLogSearchContext context) ;
    List<SalLog> selectBySalsalarydetailid(String salsalarydetailid) ;
    void removeBySalsalarydetailid(String salsalarydetailid) ;
    List<SalLog> selectBySalsalaryid(String salsalaryid) ;
    void removeBySalsalaryid(String salsalaryid) ;
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

    List<SalLog> getSallogByIds(List<String> ids) ;
    List<SalLog> getSallogByEntities(List<SalLog> entities) ;

}


