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

import cn.ibizlab.ehr.core.sal.domain.SALLOG;
import cn.ibizlab.ehr.core.sal.filter.SALLOGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALLOG] 服务对象接口
 */
public interface ISALLOGService extends IService<SALLOG>{

    SALLOG get(String key) ;
    boolean update(SALLOG et) ;
    void updateBatch(List<SALLOG> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SALLOG et) ;
    void createBatch(List<SALLOG> list) ;
    boolean save(SALLOG et) ;
    void saveBatch(List<SALLOG> list) ;
    SALLOG getDraft(SALLOG et) ;
    boolean checkKey(SALLOG et) ;
    Page<SALLOG> searchDefault(SALLOGSearchContext context) ;
    List<SALLOG> selectBySalsalarydetailid(String salsalarydetailid) ;
    void removeBySalsalarydetailid(String salsalarydetailid) ;
    List<SALLOG> selectBySalsalaryid(String salsalaryid) ;
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

}


