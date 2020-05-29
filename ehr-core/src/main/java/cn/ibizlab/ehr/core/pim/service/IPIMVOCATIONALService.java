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

import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONAL;
import cn.ibizlab.ehr.core.pim.filter.PIMVOCATIONALSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMVOCATIONAL] 服务对象接口
 */
public interface IPIMVOCATIONALService extends IService<PIMVOCATIONAL>{

    boolean update(PIMVOCATIONAL et) ;
    void updateBatch(List<PIMVOCATIONAL> list) ;
    boolean create(PIMVOCATIONAL et) ;
    void createBatch(List<PIMVOCATIONAL> list) ;
    boolean checkKey(PIMVOCATIONAL et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PIMVOCATIONAL et) ;
    void saveBatch(List<PIMVOCATIONAL> list) ;
    PIMVOCATIONAL get(String key) ;
    PIMVOCATIONAL getDraft(PIMVOCATIONAL et) ;
    Page<HashMap> searchREP_VOCATIONAL(PIMVOCATIONALSearchContext context) ;
    Page<PIMVOCATIONAL> searchAscriptionSysDQ(PIMVOCATIONALSearchContext context) ;
    Page<PIMVOCATIONAL> searchDefault(PIMVOCATIONALSearchContext context) ;
    Page<PIMVOCATIONAL> searchJLSS(PIMVOCATIONALSearchContext context) ;
    Page<PIMVOCATIONAL> searchZIZHU(PIMVOCATIONALSearchContext context) ;
    List<PIMVOCATIONAL> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PIMVOCATIONAL> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PIMVOCATIONAL> selectByOrmsignorgid(String ormsignorgid) ;
    void removeByOrmsignorgid(String ormsignorgid) ;
    List<PIMVOCATIONAL> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<PIMVOCATIONAL> selectByPimqualmajorid(String pimqualmajorid) ;
    void removeByPimqualmajorid(String pimqualmajorid) ;
    List<PIMVOCATIONAL> selectByPimqualtypeid(String pimqualtypeid) ;
    void removeByPimqualtypeid(String pimqualtypeid) ;
    List<PIMVOCATIONAL> selectByPimvocationalcatalogid(String pimvocationalcatalogid) ;
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

    List<PIMVOCATIONAL> getPimvocationalByIds(List<String> ids) ;
    List<PIMVOCATIONAL> getPimvocationalByEntities(List<PIMVOCATIONAL> entities) ;

}


