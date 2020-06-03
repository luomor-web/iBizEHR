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

import cn.ibizlab.ehr.core.pim.domain.PimVocational;
import cn.ibizlab.ehr.core.pim.filter.PimVocationalSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimVocational] 服务对象接口
 */
public interface IPimVocationalService extends IService<PimVocational>{

    boolean update(PimVocational et) ;
    void updateBatch(List<PimVocational> list) ;
    boolean create(PimVocational et) ;
    void createBatch(List<PimVocational> list) ;
    boolean checkKey(PimVocational et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PimVocational et) ;
    void saveBatch(List<PimVocational> list) ;
    PimVocational get(String key) ;
    PimVocational getDraft(PimVocational et) ;
    Page<HashMap> searchREP_VOCATIONAL(PimVocationalSearchContext context) ;
    Page<PimVocational> searchAscriptionSysDQ(PimVocationalSearchContext context) ;
    Page<PimVocational> searchDefault(PimVocationalSearchContext context) ;
    Page<PimVocational> searchJLSS(PimVocationalSearchContext context) ;
    Page<PimVocational> searchZIZHU(PimVocationalSearchContext context) ;
    List<PimVocational> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PimVocational> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimVocational> selectByOrmsignorgid(String ormsignorgid) ;
    void removeByOrmsignorgid(String ormsignorgid) ;
    List<PimVocational> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<PimVocational> selectByPimqualmajorid(String pimqualmajorid) ;
    void removeByPimqualmajorid(String pimqualmajorid) ;
    List<PimVocational> selectByPimqualtypeid(String pimqualtypeid) ;
    void removeByPimqualtypeid(String pimqualtypeid) ;
    List<PimVocational> selectByPimvocationalcatalogid(String pimvocationalcatalogid) ;
    void removeByPimvocationalcatalogid(String pimvocationalcatalogid) ;
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

    List<PimVocational> getPimvocationalByIds(List<String> ids) ;
    List<PimVocational> getPimvocationalByEntities(List<PimVocational> entities) ;

}


