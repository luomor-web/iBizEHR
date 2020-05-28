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

import cn.ibizlab.ehr.core.sal.domain.SALPERSONSTDDETAIL;
import cn.ibizlab.ehr.core.sal.filter.SALPERSONSTDDETAILSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALPERSONSTDDETAIL] 服务对象接口
 */
public interface ISALPERSONSTDDETAILService extends IService<SALPERSONSTDDETAIL>{

    boolean save(SALPERSONSTDDETAIL et) ;
    void saveBatch(List<SALPERSONSTDDETAIL> list) ;
    boolean checkKey(SALPERSONSTDDETAIL et) ;
    boolean create(SALPERSONSTDDETAIL et) ;
    void createBatch(List<SALPERSONSTDDETAIL> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALPERSONSTDDETAIL get(String key) ;
    SALPERSONSTDDETAIL getDraft(SALPERSONSTDDETAIL et) ;
    boolean update(SALPERSONSTDDETAIL et) ;
    void updateBatch(List<SALPERSONSTDDETAIL> list) ;
    Page<SALPERSONSTDDETAIL> searchDefault(SALPERSONSTDDETAILSearchContext context) ;
    List<SALPERSONSTDDETAIL> selectBySalpersonstdid(String salpersonstdid) ;
    void removeBySalpersonstdid(String salpersonstdid) ;
    List<SALPERSONSTDDETAIL> selectBySalschemeitemid(String salschemeitemid) ;
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

    List<SALPERSONSTDDETAIL> getSalpersonstddetailByIds(List<String> ids) ;
    List<SALPERSONSTDDETAIL> getSalpersonstddetailByEntities(List<SALPERSONSTDDETAIL> entities) ;

}


