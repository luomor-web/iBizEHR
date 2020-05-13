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

import cn.ibizlab.ehr.core.pim.domain.PIMPERSON;
import cn.ibizlab.ehr.core.pim.filter.PIMPERSONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMPERSON] 服务对象接口
 */
public interface IPIMPERSONService extends IService<PIMPERSON>{

    boolean update(PIMPERSON et) ;
    void updateBatch(List<PIMPERSON> list) ;
    PIMPERSON yZSFYZFP(PIMPERSON et) ;
    PIMPERSON toggleLeader(PIMPERSON et) ;
    PIMPERSON get(String key) ;
    PIMPERSON personUpdateInfo(PIMPERSON et) ;
    PIMPERSON fillPersonType(PIMPERSON et) ;
    boolean create(PIMPERSON et) ;
    void createBatch(List<PIMPERSON> list) ;
    boolean save(PIMPERSON et) ;
    void saveBatch(List<PIMPERSON> list) ;
    PIMPERSON getJTLXRDH(PIMPERSON et) ;
    PIMPERSON synPerson(PIMPERSON et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PIMPERSON et) ;
    PIMPERSON qRTX(PIMPERSON et) ;
    PIMPERSON getDraft(PIMPERSON et) ;
    PIMPERSON generatePersonFile(PIMPERSON et) ;
    Page<PIMPERSON> searchKFPRY(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchYGXXGLY(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchXMBRYCX(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchCurOrgPerson(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchJLSSGR(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchCurLeader(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchSFHMD(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchSSTRERSONINFO(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchCurJHRY(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchKTXYG(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchBYLYG(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchGBHMC(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchGZDQGL(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchKQJRYCX(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchLTXSTAFF(PIMPERSONSearchContext context) ;
    Page<HashMap> searchREP_PERSONORGTYPE(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchAuthPerson(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchDefault(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchKGZRY(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchSELFHELPID(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchSYQYGCX(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchLZRYHMC(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchTitleUse(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchJXQYGCX(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchYXZFPRYDS(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchRYZT_30(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchDTXYG(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchXZKQRY(PIMPERSONSearchContext context) ;
    Page<HashMap> searchREP_PERSONAGE(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchSYQKZZRY(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchJXQKZZRY(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchTXGB(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchKZJBDRY(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchCurOrgPimperson(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchTXRYCX(PIMPERSONSearchContext context) ;
    Page<PIMPERSON> searchKXZSYQKZZRYDS(PIMPERSONSearchContext context) ;
    List<PIMPERSON> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PIMPERSON> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PIMPERSON> selectByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) ;
    void removeByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) ;
    List<PIMPERSON> selectByPcmrcxlid(String pcmrcxlid) ;
    void removeByPcmrcxlid(String pcmrcxlid) ;
    List<PIMPERSON> selectByPimcityid(String pimcityid) ;
    void removeByPimcityid(String pimcityid) ;
    List<PIMPERSON> selectByPimmajorsetypeid(String pimmajorsetypeid) ;
    void removeByPimmajorsetypeid(String pimmajorsetypeid) ;
    List<PIMPERSON> selectByPimpersonid2(String pimpersonid) ;
    void removeByPimpersonid2(String pimpersonid) ;
    List<PIMPERSON> selectByPimpersonid3(String pimpersonid) ;
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

}


