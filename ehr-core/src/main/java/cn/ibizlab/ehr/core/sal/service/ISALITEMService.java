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

import cn.ibizlab.ehr.core.sal.domain.SALITEM;
import cn.ibizlab.ehr.core.sal.filter.SALITEMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALITEM] 服务对象接口
 */
public interface ISALITEMService extends IService<SALITEM>{

    SALITEM get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SALITEM et) ;
    void saveBatch(List<SALITEM> list) ;
    SALITEM getDraft(SALITEM et) ;
    boolean checkKey(SALITEM et) ;
    boolean update(SALITEM et) ;
    void updateBatch(List<SALITEM> list) ;
    boolean create(SALITEM et) ;
    void createBatch(List<SALITEM> list) ;
    Page<SALITEM> searchDefault(SALITEMSearchContext context) ;
    List<SALITEM> selectBySalsubjectid(String salsubjectid) ;
    void removeBySalsubjectid(String salsubjectid) ;
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


