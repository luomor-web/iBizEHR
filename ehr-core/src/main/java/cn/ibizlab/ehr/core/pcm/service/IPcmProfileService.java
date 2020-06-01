package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmProfile] 服务对象接口
 */
public interface IPcmProfileService extends IService<PcmProfile>{

    PcmProfile jZBTG(PcmProfile et) ;
    PcmProfile sBJZB(PcmProfile et) ;
    PcmProfile jSPBTG(PcmProfile et) ;
    PcmProfile printSPB(PcmProfile et) ;
    PcmProfile getYPZNL(PcmProfile et) ;
    PcmProfile clearPersonUpdateInfo(PcmProfile et) ;
    boolean save(PcmProfile et) ;
    void saveBatch(List<PcmProfile> list) ;
    PcmProfile invalid2(PcmProfile et) ;
    PcmProfile bD(PcmProfile et) ;
    PcmProfile jLDTG(PcmProfile et) ;
    PcmProfile checkYJSNF(PcmProfile et) ;
    PcmProfile gSSP(PcmProfile et) ;
    PcmProfile checkEmail(PcmProfile et) ;
    PcmProfile getPcmprofileInfo(PcmProfile et) ;
    boolean create(PcmProfile et) ;
    void createBatch(List<PcmProfile> list) ;
    boolean update(PcmProfile et) ;
    void updateBatch(List<PcmProfile> list) ;
    PcmProfile returnYPZ(PcmProfile et) ;
    PcmProfile get(String key) ;
    PcmProfile checkYglxIsChanged(PcmProfile et) ;
    PcmProfile sX(PcmProfile et) ;
    boolean checkKey(PcmProfile et) ;
    PcmProfile invalid(PcmProfile et) ;
    PcmProfile jZBBTG(PcmProfile et) ;
    PcmProfile clearYPZ(PcmProfile et) ;
    PcmProfile checkFP(PcmProfile et) ;
    PcmProfile sCBH(PcmProfile et) ;
    PcmProfile getDraft(PcmProfile et) ;
    PcmProfile clearYYDJMC(PcmProfile et) ;
    PcmProfile submit(PcmProfile et) ;
    PcmProfile personUpdateInfo(PcmProfile et) ;
    PcmProfile gSCS(PcmProfile et) ;
    PcmProfile fillingYPZ(PcmProfile et) ;
    PcmProfile yQWBD(PcmProfile et) ;
    PcmProfile uSEYBH(PcmProfile et) ;
    PcmProfile checkMobieNumber(PcmProfile et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmProfile jLDBTG(PcmProfile et) ;
    PcmProfile jSPTG(PcmProfile et) ;
    PcmProfile setNQDLDHTQX(PcmProfile et) ;
    Page<PcmProfile> searchYRDWSH_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchJLDSP(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchBD_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchYPZSPB_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchZPDWSH(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchBD(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchBHSP(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchLR(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchRLSB(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchFormType(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchHTRY_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchDefault(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchJZBSP(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchRZSP_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchJLDSP_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchBHSP_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchLR_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchYPZBB_READ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchHTRY(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchRZSP(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchYRDWCS_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchJZBSP_CSRCYJ(PcmProfileSearchContext context) ;
    Page<PcmProfile> searchRLSB_CSRCYJ(PcmProfileSearchContext context) ;
    List<PcmProfile> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PcmProfile> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmProfile> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PcmProfile> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PcmProfile> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmProfile> getPcmprofileByIds(List<String> ids) ;
    List<PcmProfile> getPcmprofileByEntities(List<PcmProfile> entities) ;

}


