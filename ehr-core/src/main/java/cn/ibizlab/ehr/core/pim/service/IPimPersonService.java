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

import cn.ibizlab.ehr.core.pim.domain.PimPerson;
import cn.ibizlab.ehr.core.pim.filter.PimPersonSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimPerson] 服务对象接口
 */
public interface IPimPersonService extends IService<PimPerson>{

    boolean update(PimPerson et) ;
    void updateBatch(List<PimPerson> list) ;
    PimPerson yZSFYZFP(PimPerson et) ;
    PimPerson toggleLeader(PimPerson et) ;
    PimPerson get(String key) ;
    PimPerson personUpdateInfo(PimPerson et) ;
    PimPerson fillPersonType(PimPerson et) ;
    boolean create(PimPerson et) ;
    void createBatch(List<PimPerson> list) ;
    boolean save(PimPerson et) ;
    void saveBatch(List<PimPerson> list) ;
    PimPerson getJTLXRDH(PimPerson et) ;
    PimPerson synPerson(PimPerson et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PimPerson et) ;
    PimPerson qRTX(PimPerson et) ;
    PimPerson getDraft(PimPerson et) ;
    PimPerson generatePersonFile(PimPerson et) ;
    Page<PimPerson> searchKFPRY(PimPersonSearchContext context) ;
    Page<PimPerson> searchSetAttRules(PimPersonSearchContext context) ;
    Page<PimPerson> searchSetSocArchives(PimPersonSearchContext context) ;
    Page<PimPerson> searchYGXXGLY(PimPersonSearchContext context) ;
    Page<PimPerson> searchXMBRYCX(PimPersonSearchContext context) ;
    Page<PimPerson> searchCurOrgPerson(PimPersonSearchContext context) ;
    Page<PimPerson> searchJLSSGR(PimPersonSearchContext context) ;
    Page<PimPerson> searchCurLeader(PimPersonSearchContext context) ;
    Page<PimPerson> searchSFHMD(PimPersonSearchContext context) ;
    Page<PimPerson> searchSSTRERSONINFO(PimPersonSearchContext context) ;
    Page<PimPerson> searchCurJHRY(PimPersonSearchContext context) ;
    Page<PimPerson> searchKTXYG(PimPersonSearchContext context) ;
    Page<PimPerson> searchBYLYG(PimPersonSearchContext context) ;
    Page<PimPerson> searchGBHMC(PimPersonSearchContext context) ;
    Page<PimPerson> searchGZDQGL(PimPersonSearchContext context) ;
    Page<PimPerson> searchKQJRYCX(PimPersonSearchContext context) ;
    Page<PimPerson> searchLTXSTAFF(PimPersonSearchContext context) ;
    Page<HashMap> searchREP_PERSONORGTYPE(PimPersonSearchContext context) ;
    Page<PimPerson> searchAuthPerson(PimPersonSearchContext context) ;
    Page<PimPerson> searchDefault(PimPersonSearchContext context) ;
    Page<PimPerson> searchKGZRY(PimPersonSearchContext context) ;
    Page<PimPerson> searchSELFHELPID(PimPersonSearchContext context) ;
    Page<PimPerson> searchSYQYGCX(PimPersonSearchContext context) ;
    Page<PimPerson> searchLZRYHMC(PimPersonSearchContext context) ;
    Page<PimPerson> searchTitleUse(PimPersonSearchContext context) ;
    Page<PimPerson> searchJXQYGCX(PimPersonSearchContext context) ;
    Page<PimPerson> searchYXZFPRYDS(PimPersonSearchContext context) ;
    Page<PimPerson> searchRYZT_30(PimPersonSearchContext context) ;
    Page<PimPerson> searchDTXYG(PimPersonSearchContext context) ;
    Page<PimPerson> searchXZKQRY(PimPersonSearchContext context) ;
    Page<HashMap> searchREP_PERSONAGE(PimPersonSearchContext context) ;
    Page<PimPerson> searchSYQKZZRY(PimPersonSearchContext context) ;
    Page<PimPerson> searchJXQKZZRY(PimPersonSearchContext context) ;
    Page<PimPerson> searchTXGB(PimPersonSearchContext context) ;
    Page<PimPerson> searchKZJBDRY(PimPersonSearchContext context) ;
    Page<PimPerson> searchCurOrgPimperson(PimPersonSearchContext context) ;
    Page<PimPerson> searchTXRYCX(PimPersonSearchContext context) ;
    Page<PimPerson> searchKXZSYQKZZRYDS(PimPersonSearchContext context) ;
    List<PimPerson> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PimPerson> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimPerson> selectByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) ;
    void removeByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) ;
    List<PimPerson> selectByPcmrcxlid(String pcmrcxlid) ;
    void removeByPcmrcxlid(String pcmrcxlid) ;
    List<PimPerson> selectByPimcityid(String pimcityid) ;
    void removeByPimcityid(String pimcityid) ;
    List<PimPerson> selectByPimmajorsetypeid(String pimmajorsetypeid) ;
    void removeByPimmajorsetypeid(String pimmajorsetypeid) ;
    List<PimPerson> selectByPimpersonid2(String pimpersonid) ;
    void removeByPimpersonid2(String pimpersonid) ;
    List<PimPerson> selectByPimpersonid3(String pimpersonid) ;
    void removeByPimpersonid3(String pimpersonid) ;
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

    List<PimPerson> getPimpersonByIds(List<String> ids) ;
    List<PimPerson> getPimpersonByEntities(List<PimPerson> entities) ;

}


