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

import cn.ibizlab.ehr.core.sal.domain.SALRULEDETAIL;
import cn.ibizlab.ehr.core.sal.filter.SALRULEDETAILSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALRULEDETAIL] 服务对象接口
 */
public interface ISALRULEDETAILService extends IService<SALRULEDETAIL>{

    SALRULEDETAIL get(String key) ;
    boolean checkKey(SALRULEDETAIL et) ;
    boolean update(SALRULEDETAIL et) ;
    void updateBatch(List<SALRULEDETAIL> list) ;
    boolean save(SALRULEDETAIL et) ;
    void saveBatch(List<SALRULEDETAIL> list) ;
    boolean create(SALRULEDETAIL et) ;
    void createBatch(List<SALRULEDETAIL> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALRULEDETAIL getDraft(SALRULEDETAIL et) ;
    Page<SALRULEDETAIL> searchDefault(SALRULEDETAILSearchContext context) ;
    List<SALRULEDETAIL> selectBySalparamid(String salparamid) ;
    void removeBySalparamid(String salparamid) ;
    List<SALRULEDETAIL> selectBySalparamid2(String salparamid) ;
    void removeBySalparamid2(String salparamid) ;
    List<SALRULEDETAIL> selectBySalruleid(String salruleid) ;
    void removeBySalruleid(String salruleid) ;
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

    List<SALRULEDETAIL> getSalruledetailByIds(List<String> ids) ;
    List<SALRULEDETAIL> getSalruledetailByEntities(List<SALRULEDETAIL> entities) ;

}


