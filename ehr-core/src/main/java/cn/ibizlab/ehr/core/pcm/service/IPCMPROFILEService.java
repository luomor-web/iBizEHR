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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILE] 服务对象接口
 */
public interface IPCMPROFILEService extends IService<PCMPROFILE>{

    PCMPROFILE jZBTG(PCMPROFILE et) ;
    PCMPROFILE sBJZB(PCMPROFILE et) ;
    PCMPROFILE jSPBTG(PCMPROFILE et) ;
    PCMPROFILE printSPB(PCMPROFILE et) ;
    PCMPROFILE getYPZNL(PCMPROFILE et) ;
    PCMPROFILE clearPersonUpdateInfo(PCMPROFILE et) ;
    boolean save(PCMPROFILE et) ;
    void saveBatch(List<PCMPROFILE> list) ;
    PCMPROFILE invalid2(PCMPROFILE et) ;
    PCMPROFILE bD(PCMPROFILE et) ;
    PCMPROFILE jLDTG(PCMPROFILE et) ;
    PCMPROFILE checkYJSNF(PCMPROFILE et) ;
    PCMPROFILE gSSP(PCMPROFILE et) ;
    PCMPROFILE checkEmail(PCMPROFILE et) ;
    PCMPROFILE getPcmprofileInfo(PCMPROFILE et) ;
    boolean create(PCMPROFILE et) ;
    void createBatch(List<PCMPROFILE> list) ;
    boolean update(PCMPROFILE et) ;
    void updateBatch(List<PCMPROFILE> list) ;
    PCMPROFILE returnYPZ(PCMPROFILE et) ;
    PCMPROFILE get(String key) ;
    PCMPROFILE checkYglxIsChanged(PCMPROFILE et) ;
    PCMPROFILE sX(PCMPROFILE et) ;
    boolean checkKey(PCMPROFILE et) ;
    PCMPROFILE invalid(PCMPROFILE et) ;
    PCMPROFILE jZBBTG(PCMPROFILE et) ;
    PCMPROFILE clearYPZ(PCMPROFILE et) ;
    PCMPROFILE checkFP(PCMPROFILE et) ;
    PCMPROFILE sCBH(PCMPROFILE et) ;
    PCMPROFILE getDraft(PCMPROFILE et) ;
    PCMPROFILE clearYYDJMC(PCMPROFILE et) ;
    PCMPROFILE submit(PCMPROFILE et) ;
    PCMPROFILE personUpdateInfo(PCMPROFILE et) ;
    PCMPROFILE gSCS(PCMPROFILE et) ;
    PCMPROFILE fillingYPZ(PCMPROFILE et) ;
    PCMPROFILE yQWBD(PCMPROFILE et) ;
    PCMPROFILE uSEYBH(PCMPROFILE et) ;
    PCMPROFILE checkMobieNumber(PCMPROFILE et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMPROFILE jLDBTG(PCMPROFILE et) ;
    PCMPROFILE jSPTG(PCMPROFILE et) ;
    PCMPROFILE setNQDLDHTQX(PCMPROFILE et) ;
    Page<PCMPROFILE> searchYRDWSH_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchJLDSP(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchBD_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchYPZSPB_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchZPDWSH(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchBD(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchBHSP(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchLR(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchRLSB(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchFormType(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchHTRY_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchDefault(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchJZBSP(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchRZSP_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchJLDSP_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchBHSP_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchLR_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchYPZBB_READ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchHTRY(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchRZSP(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchYRDWCS_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchJZBSP_CSRCYJ(PCMPROFILESearchContext context) ;
    Page<PCMPROFILE> searchRLSB_CSRCYJ(PCMPROFILESearchContext context) ;
    List<PCMPROFILE> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PCMPROFILE> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMPROFILE> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PCMPROFILE> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PCMPROFILE> selectByPimpersonid(String pimpersonid) ;
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

    List<PCMPROFILE> getPcmprofileByIds(List<String> ids) ;
    List<PCMPROFILE> getPcmprofileByEntities(List<PCMPROFILE> entities) ;

}


