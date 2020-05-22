package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PIMEDUCATION;
import cn.ibizlab.ehr.core.pim.filter.PIMEDUCATIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMEDUCATION] 服务对象接口
 */
public interface IPIMEDUCATIONService extends IService<PIMEDUCATION>{

    PIMEDUCATION checkHighestEdu(PIMEDUCATION et) ;
    PIMEDUCATION get(String key) ;
    boolean save(PIMEDUCATION et) ;
    void saveBatch(List<PIMEDUCATION> list) ;
    boolean create(PIMEDUCATION et) ;
    void createBatch(List<PIMEDUCATION> list) ;
    PIMEDUCATION getDraft(PIMEDUCATION et) ;
    boolean checkKey(PIMEDUCATION et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PIMEDUCATION et) ;
    void updateBatch(List<PIMEDUCATION> list) ;
    Page<PIMEDUCATION> searchFAZZSY(PIMEDUCATIONSearchContext context) ;
    Page<PIMEDUCATION> searchJLSS(PIMEDUCATIONSearchContext context) ;
    Page<PIMEDUCATION> searchZIZHU(PIMEDUCATIONSearchContext context) ;
    Page<PIMEDUCATION> searchADMDYZG(PIMEDUCATIONSearchContext context) ;
    Page<PIMEDUCATION> searchPERSONAL(PIMEDUCATIONSearchContext context) ;
    Page<PIMEDUCATION> searchADMSYSTEM(PIMEDUCATIONSearchContext context) ;
    Page<PIMEDUCATION> searchDefault(PIMEDUCATIONSearchContext context) ;
    Page<HashMap> searchREP_EDU(PIMEDUCATIONSearchContext context) ;
    List<PIMEDUCATION> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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


