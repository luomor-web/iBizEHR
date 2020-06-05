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

import cn.ibizlab.ehr.core.pim.domain.PimDistirbution;
import cn.ibizlab.ehr.core.pim.filter.PimDistirbutionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimDistirbution] 服务对象接口
 */
public interface IPimDistirbutionService extends IService<PimDistirbution>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PimDistirbution et) ;
    boolean update(PimDistirbution et) ;
    void updateBatch(List<PimDistirbution> list) ;
    PimDistirbution getDraft(PimDistirbution et) ;
    PimDistirbution dDCZC(PimDistirbution et) ;
    boolean save(PimDistirbution et) ;
    void saveBatch(List<PimDistirbution> list) ;
    boolean create(PimDistirbution et) ;
    void createBatch(List<PimDistirbution> list) ;
    PimDistirbution get(String key) ;
    Page<PimDistirbution> searchGBYXZFP(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchLGTX(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchISOUTRECORD(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchYDCFP(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchYXFP(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchZPCJFP(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchYDWQX(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchDQYXFP(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchJDRYHMC(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchJDDQ(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchEXPEREENCE(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchJLSS(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchZIZHU(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchDefault(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchDQFP(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchMobDefault(PimDistirbutionSearchContext context) ;
    Page<PimDistirbution> searchKDDYXZFP(PimDistirbutionSearchContext context) ;
    List<PimDistirbution> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PimDistirbution> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PimDistirbution> selectByYbmid(String orgsectorid) ;
    void removeByYbmid(String orgsectorid) ;
    List<PimDistirbution> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimDistirbution> selectByYzzid(String orgid) ;
    void removeByYzzid(String orgid) ;
    List<PimDistirbution> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PimDistirbution> selectByOrmpostid1(String ormpostid) ;
    void removeByOrmpostid1(String ormpostid) ;
    List<PimDistirbution> selectByPimpersonid(String pimpersonid) ;
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

    List<PimDistirbution> getPimdistirbutionByIds(List<String> ids) ;
    List<PimDistirbution> getPimdistirbutionByEntities(List<PimDistirbution> entities) ;

}


