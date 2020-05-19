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

import cn.ibizlab.ehr.core.sal.domain.SALSCHEMEITEM;
import cn.ibizlab.ehr.core.sal.filter.SALSCHEMEITEMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSCHEMEITEM] 服务对象接口
 */
public interface ISALSCHEMEITEMService extends IService<SALSCHEMEITEM>{

    boolean update(SALSCHEMEITEM et) ;
    void updateBatch(List<SALSCHEMEITEM> list) ;
    boolean save(SALSCHEMEITEM et) ;
    void saveBatch(List<SALSCHEMEITEM> list) ;
    SALSCHEMEITEM get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SALSCHEMEITEM et) ;
    boolean create(SALSCHEMEITEM et) ;
    void createBatch(List<SALSCHEMEITEM> list) ;
    SALSCHEMEITEM getDraft(SALSCHEMEITEM et) ;
    Page<SALSCHEMEITEM> searchDefault(SALSCHEMEITEMSearchContext context) ;
    List<SALSCHEMEITEM> selectBySalitemid(String salitemid) ;
    void removeBySalitemid(String salitemid) ;
    List<SALSCHEMEITEM> selectBySalruleid(String salruleid) ;
    void removeBySalruleid(String salruleid) ;
    List<SALSCHEMEITEM> selectBySalschemeid(String salschemeid) ;
    void removeBySalschemeid(String salschemeid) ;
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


