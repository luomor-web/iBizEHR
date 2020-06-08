package cn.ibizlab.ehr.core.orm.service;

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

import cn.ibizlab.ehr.core.orm.domain.OrmXmrypzxq;
import cn.ibizlab.ehr.core.orm.filter.OrmXmrypzxqSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmXmrypzxq] 服务对象接口
 */
public interface IOrmXmrypzxqService extends IService<OrmXmrypzxq>{

    OrmXmrypzxq getDraft(OrmXmrypzxq et) ;
    OrmXmrypzxq synTJ(OrmXmrypzxq et) ;
    OrmXmrypzxq mODSPTG(OrmXmrypzxq et) ;
    boolean checkKey(OrmXmrypzxq et) ;
    OrmXmrypzxq sFBH(OrmXmrypzxq et) ;
    OrmXmrypzxq ensure(OrmXmrypzxq et) ;
    OrmXmrypzxq get(String key) ;
    OrmXmrypzxq synDeployInfo(OrmXmrypzxq et) ;
    OrmXmrypzxq mODBH(OrmXmrypzxq et) ;
    OrmXmrypzxq sFQR(OrmXmrypzxq et) ;
    OrmXmrypzxq synPersonInfo(OrmXmrypzxq et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmXmrypzxq synRelease(OrmXmrypzxq et) ;
    OrmXmrypzxq sHTG(OrmXmrypzxq et) ;
    OrmXmrypzxq tPSPTG(OrmXmrypzxq et) ;
    OrmXmrypzxq bH(OrmXmrypzxq et) ;
    boolean save(OrmXmrypzxq et) ;
    void saveBatch(List<OrmXmrypzxq> list) ;
    OrmXmrypzxq sFSPTG(OrmXmrypzxq et) ;
    OrmXmrypzxq tPBH(OrmXmrypzxq et) ;
    OrmXmrypzxq tPQR(OrmXmrypzxq et) ;
    boolean create(OrmXmrypzxq et) ;
    void createBatch(List<OrmXmrypzxq> list) ;
    boolean update(OrmXmrypzxq et) ;
    void updateBatch(List<OrmXmrypzxq> list) ;
    Page<OrmXmrypzxq> searchRSSH(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchCURFQTP(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchCXSJ(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchKZXMQX(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchSFSH(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchCURFQSF(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchTPSH(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchSFCXSJ(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchMODSPSH(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchDefault(OrmXmrypzxqSearchContext context) ;
    Page<OrmXmrypzxq> searchXMCBMX(OrmXmrypzxqSearchContext context) ;
    List<OrmXmrypzxq> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<OrmXmrypzxq> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<OrmXmrypzxq> selectByOrmxmxqjhid(String ormxmxqjhid) ;
    void removeByOrmxmxqjhid(String ormxmxqjhid) ;
    List<OrmXmrypzxq> selectByModpimpersonid(String pimpersonid) ;
    void removeByModpimpersonid(String pimpersonid) ;
    List<OrmXmrypzxq> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<OrmXmrypzxq> selectByRealpersonid(String pimpersonid) ;
    void removeByRealpersonid(String pimpersonid) ;
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

    List<OrmXmrypzxq> getOrmxmrypzxqByIds(List<String> ids) ;
    List<OrmXmrypzxq> getOrmxmrypzxqByEntities(List<OrmXmrypzxq> entities) ;

}


