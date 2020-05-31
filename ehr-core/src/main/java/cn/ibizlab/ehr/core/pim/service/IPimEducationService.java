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

import cn.ibizlab.ehr.core.pim.domain.PimEducation;
import cn.ibizlab.ehr.core.pim.filter.PimEducationSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimEducation] 服务对象接口
 */
public interface IPimEducationService extends IService<PimEducation>{

    PimEducation checkHighestEdu(PimEducation et) ;
    PimEducation get(String key) ;
    boolean save(PimEducation et) ;
    void saveBatch(List<PimEducation> list) ;
    boolean create(PimEducation et) ;
    void createBatch(List<PimEducation> list) ;
    PimEducation getDraft(PimEducation et) ;
    boolean checkKey(PimEducation et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PimEducation et) ;
    void updateBatch(List<PimEducation> list) ;
    Page<PimEducation> searchFAZZSY(PimEducationSearchContext context) ;
    Page<PimEducation> searchJLSS(PimEducationSearchContext context) ;
    Page<PimEducation> searchZIZHU(PimEducationSearchContext context) ;
    Page<PimEducation> searchADMDYZG(PimEducationSearchContext context) ;
    Page<PimEducation> searchPERSONAL(PimEducationSearchContext context) ;
    Page<PimEducation> searchADMSYSTEM(PimEducationSearchContext context) ;
    Page<PimEducation> searchDefault(PimEducationSearchContext context) ;
    Page<HashMap> searchREP_EDU(PimEducationSearchContext context) ;
    List<PimEducation> selectByPimpersonid(String pimpersonid) ;
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

    List<PimEducation> getPimeducationByIds(List<String> ids) ;
    List<PimEducation> getPimeducationByEntities(List<PimEducation> entities) ;

}


