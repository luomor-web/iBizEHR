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

import cn.ibizlab.ehr.core.pcm.domain.PCMBDSQDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMBDSQDMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMBDSQDMX] 服务对象接口
 */
public interface IPCMBDSQDMXService extends IService<PCMBDSQDMX>{

    PCMBDSQDMX zJJSDMB(PCMBDSQDMX et) ;
    PCMBDSQDMX cQBXCZ(PCMBDSQDMX et) ;
    PCMBDSQDMX sXJSDMB(PCMBDSQDMX et) ;
    PCMBDSQDMX pDZJ(PCMBDSQDMX et) ;
    PCMBDSQDMX sXJSDMB2(PCMBDSQDMX et) ;
    boolean create(PCMBDSQDMX et) ;
    void createBatch(List<PCMBDSQDMX> list) ;
    PCMBDSQDMX zZSQ(PCMBDSQDMX et) ;
    PCMBDSQDMX sXDMB(PCMBDSQDMX et) ;
    PCMBDSQDMX dGCZ(PCMBDSQDMX et) ;
    PCMBDSQDMX setPersonInfo(PCMBDSQDMX et) ;
    PCMBDSQDMX gZCZ(PCMBDSQDMX et) ;
    PCMBDSQDMX jPCZ(PCMBDSQDMX et) ;
    boolean save(PCMBDSQDMX et) ;
    void saveBatch(List<PCMBDSQDMX> list) ;
    PCMBDSQDMX lZCZ(PCMBDSQDMX et) ;
    PCMBDSQDMX nTCZ(PCMBDSQDMX et) ;
    boolean update(PCMBDSQDMX et) ;
    void updateBatch(List<PCMBDSQDMX> list) ;
    PCMBDSQDMX get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMBDSQDMX getDraft(PCMBDSQDMX et) ;
    PCMBDSQDMX sHBTG(PCMBDSQDMX et) ;
    PCMBDSQDMX zJBDCZ(PCMBDSQDMX et) ;
    boolean checkKey(PCMBDSQDMX et) ;
    PCMBDSQDMX tXCZ(PCMBDSQDMX et) ;
    PCMBDSQDMX jZJJSDMB(PCMBDSQDMX et) ;
    PCMBDSQDMX sHTG(PCMBDSQDMX et) ;
    Page<PCMBDSQDMX> searchJPSQMX(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchNTSQMX(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchNTSQMXGR(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchTXSQMX(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchGZSQMX(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchZJBDSQMX(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchDGSQMX(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchCQBXSQMXDS(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchLZSQMX(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchLZSQMXGR(PCMBDSQDMXSearchContext context) ;
    Page<PCMBDSQDMX> searchDefault(PCMBDSQDMXSearchContext context) ;
    List<PCMBDSQDMX> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PCMBDSQDMX> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMBDSQDMX> selectByOrmorgsectorid2(String orgsectorid) ;
    void removeByOrmorgsectorid2(String orgsectorid) ;
    List<PCMBDSQDMX> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PCMBDSQDMX> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PCMBDSQDMX> selectByPcmbdsqdid(String pcmbdsqdid) ;
    void removeByPcmbdsqdid(String pcmbdsqdid) ;
    List<PCMBDSQDMX> selectByLzmtrid(String pimpersonid) ;
    void removeByLzmtrid(String pimpersonid) ;
    List<PCMBDSQDMX> selectByPimpersonid(String pimpersonid) ;
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


