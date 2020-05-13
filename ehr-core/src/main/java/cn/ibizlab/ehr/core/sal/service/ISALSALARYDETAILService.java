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

import cn.ibizlab.ehr.core.sal.domain.SALSALARYDETAIL;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYDETAILSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSALARYDETAIL] 服务对象接口
 */
public interface ISALSALARYDETAILService extends IService<SALSALARYDETAIL>{

    boolean update(SALSALARYDETAIL et) ;
    void updateBatch(List<SALSALARYDETAIL> list) ;
    boolean create(SALSALARYDETAIL et) ;
    void createBatch(List<SALSALARYDETAIL> list) ;
    SALSALARYDETAIL getDraft(SALSALARYDETAIL et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALSALARYDETAIL get(String key) ;
    boolean checkKey(SALSALARYDETAIL et) ;
    boolean save(SALSALARYDETAIL et) ;
    void saveBatch(List<SALSALARYDETAIL> list) ;
    Page<SALSALARYDETAIL> searchDefault(SALSALARYDETAILSearchContext context) ;
    List<SALSALARYDETAIL> selectBySalsalaryid(String salsalaryid) ;
    void removeBySalsalaryid(String salsalaryid) ;
    List<SALSALARYDETAIL> selectBySalschemeitemid(String salschemeitemid) ;
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

}


