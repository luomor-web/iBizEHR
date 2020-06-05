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

import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmBdsqdmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmBdsqdmx] 服务对象接口
 */
public interface IPcmBdsqdmxService extends IService<PcmBdsqdmx>{

    PcmBdsqdmx zJJSDMB(PcmBdsqdmx et) ;
    PcmBdsqdmx cQBXCZ(PcmBdsqdmx et) ;
    PcmBdsqdmx sXJSDMB(PcmBdsqdmx et) ;
    PcmBdsqdmx pDZJ(PcmBdsqdmx et) ;
    PcmBdsqdmx sXJSDMB2(PcmBdsqdmx et) ;
    boolean create(PcmBdsqdmx et) ;
    void createBatch(List<PcmBdsqdmx> list) ;
    PcmBdsqdmx zZSQ(PcmBdsqdmx et) ;
    PcmBdsqdmx sXDMB(PcmBdsqdmx et) ;
    PcmBdsqdmx dGCZ(PcmBdsqdmx et) ;
    PcmBdsqdmx setPersonInfo(PcmBdsqdmx et) ;
    PcmBdsqdmx gZCZ(PcmBdsqdmx et) ;
    PcmBdsqdmx jPCZ(PcmBdsqdmx et) ;
    boolean save(PcmBdsqdmx et) ;
    void saveBatch(List<PcmBdsqdmx> list) ;
    PcmBdsqdmx lZCZ(PcmBdsqdmx et) ;
    PcmBdsqdmx nTCZ(PcmBdsqdmx et) ;
    boolean update(PcmBdsqdmx et) ;
    void updateBatch(List<PcmBdsqdmx> list) ;
    PcmBdsqdmx get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmBdsqdmx getDraft(PcmBdsqdmx et) ;
    PcmBdsqdmx sHBTG(PcmBdsqdmx et) ;
    PcmBdsqdmx zJBDCZ(PcmBdsqdmx et) ;
    boolean checkKey(PcmBdsqdmx et) ;
    PcmBdsqdmx tXCZ(PcmBdsqdmx et) ;
    PcmBdsqdmx jZJJSDMB(PcmBdsqdmx et) ;
    PcmBdsqdmx sHTG(PcmBdsqdmx et) ;
    Page<PcmBdsqdmx> searchJPSQMX(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchNTSQMX(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchNTSQMXGR(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchTXSQMX(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchGZSQMX(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchZJBDSQMX(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchDGSQMX(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchCQBXSQMXDS(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchLZSQMX(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchLZSQMXGR(PcmBdsqdmxSearchContext context) ;
    Page<PcmBdsqdmx> searchDefault(PcmBdsqdmxSearchContext context) ;
    List<PcmBdsqdmx> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PcmBdsqdmx> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmBdsqdmx> selectByOrmorgsectorid2(String orgsectorid) ;
    void removeByOrmorgsectorid2(String orgsectorid) ;
    List<PcmBdsqdmx> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PcmBdsqdmx> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PcmBdsqdmx> selectByPcmbdsqdid(String pcmbdsqdid) ;
    void removeByPcmbdsqdid(String pcmbdsqdid) ;
    List<PcmBdsqdmx> selectByLzmtrid(String pimpersonid) ;
    void removeByLzmtrid(String pimpersonid) ;
    List<PcmBdsqdmx> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmBdsqdmx> getPcmbdsqdmxByIds(List<String> ids) ;
    List<PcmBdsqdmx> getPcmbdsqdmxByEntities(List<PcmBdsqdmx> entities) ;

}


