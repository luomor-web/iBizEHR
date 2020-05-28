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

import cn.ibizlab.ehr.core.pim.domain.PIMDISTIRBUTION;
import cn.ibizlab.ehr.core.pim.filter.PIMDISTIRBUTIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMDISTIRBUTION] 服务对象接口
 */
public interface IPIMDISTIRBUTIONService extends IService<PIMDISTIRBUTION>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PIMDISTIRBUTION et) ;
    boolean update(PIMDISTIRBUTION et) ;
    void updateBatch(List<PIMDISTIRBUTION> list) ;
    PIMDISTIRBUTION getDraft(PIMDISTIRBUTION et) ;
    PIMDISTIRBUTION dDCZC(PIMDISTIRBUTION et) ;
    boolean save(PIMDISTIRBUTION et) ;
    void saveBatch(List<PIMDISTIRBUTION> list) ;
    boolean create(PIMDISTIRBUTION et) ;
    void createBatch(List<PIMDISTIRBUTION> list) ;
    PIMDISTIRBUTION get(String key) ;
    Page<PIMDISTIRBUTION> searchGBYXZFP(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchLGTX(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchISOUTRECORD(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchYDCFP(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchYXFP(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchZPCJFP(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchYDWQX(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchDQYXFP(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchJDRYHMC(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchJDDQ(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchEXPEREENCE(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchJLSS(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchZIZHU(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchDefault(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchDQFP(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchMobDefault(PIMDISTIRBUTIONSearchContext context) ;
    Page<PIMDISTIRBUTION> searchKDDYXZFP(PIMDISTIRBUTIONSearchContext context) ;
    List<PIMDISTIRBUTION> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PIMDISTIRBUTION> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PIMDISTIRBUTION> selectByYbmid(String orgsectorid) ;
    void removeByYbmid(String orgsectorid) ;
    List<PIMDISTIRBUTION> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PIMDISTIRBUTION> selectByYzzid(String orgid) ;
    void removeByYzzid(String orgid) ;
    List<PIMDISTIRBUTION> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PIMDISTIRBUTION> selectByOrmpostid1(String ormpostid) ;
    void removeByOrmpostid1(String ormpostid) ;
    List<PIMDISTIRBUTION> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMDISTIRBUTION> getPimdistirbutionByIds(List<String> ids) ;
    List<PIMDISTIRBUTION> getPimdistirbutionByEntities(List<PIMDISTIRBUTION> entities) ;

}


