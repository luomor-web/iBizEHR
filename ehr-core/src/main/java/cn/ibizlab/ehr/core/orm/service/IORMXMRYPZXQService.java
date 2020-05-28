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

import cn.ibizlab.ehr.core.orm.domain.ORMXMRYPZXQ;
import cn.ibizlab.ehr.core.orm.filter.ORMXMRYPZXQSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMRYPZXQ] 服务对象接口
 */
public interface IORMXMRYPZXQService extends IService<ORMXMRYPZXQ>{

    ORMXMRYPZXQ getDraft(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ synTJ(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ mODSPTG(ORMXMRYPZXQ et) ;
    boolean checkKey(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ sFBH(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ ensure(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ get(String key) ;
    ORMXMRYPZXQ synDeployInfo(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ mODBH(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ sFQR(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ synPersonInfo(ORMXMRYPZXQ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMXMRYPZXQ synRelease(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ sHTG(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ tPSPTG(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ bH(ORMXMRYPZXQ et) ;
    boolean save(ORMXMRYPZXQ et) ;
    void saveBatch(List<ORMXMRYPZXQ> list) ;
    ORMXMRYPZXQ sFSPTG(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ tPBH(ORMXMRYPZXQ et) ;
    ORMXMRYPZXQ tPQR(ORMXMRYPZXQ et) ;
    boolean create(ORMXMRYPZXQ et) ;
    void createBatch(List<ORMXMRYPZXQ> list) ;
    boolean update(ORMXMRYPZXQ et) ;
    void updateBatch(List<ORMXMRYPZXQ> list) ;
    Page<ORMXMRYPZXQ> searchRSSH(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchCURFQTP(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchCXSJ(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchKZXMQX(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchSFSH(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchCURFQSF(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchTPSH(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchSFCXSJ(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchMODSPSH(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchDefault(ORMXMRYPZXQSearchContext context) ;
    Page<ORMXMRYPZXQ> searchXMCBMX(ORMXMRYPZXQSearchContext context) ;
    List<ORMXMRYPZXQ> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<ORMXMRYPZXQ> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<ORMXMRYPZXQ> selectByOrmxmxqjhid(String ormxmxqjhid) ;
    void removeByOrmxmxqjhid(String ormxmxqjhid) ;
    List<ORMXMRYPZXQ> selectByModpimpersonid(String pimpersonid) ;
    void removeByModpimpersonid(String pimpersonid) ;
    List<ORMXMRYPZXQ> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<ORMXMRYPZXQ> selectByRealpersonid(String pimpersonid) ;
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

    List<ORMXMRYPZXQ> getOrmxmrypzxqByIds(List<String> ids) ;
    List<ORMXMRYPZXQ> getOrmxmrypzxqByEntities(List<ORMXMRYPZXQ> entities) ;

}


