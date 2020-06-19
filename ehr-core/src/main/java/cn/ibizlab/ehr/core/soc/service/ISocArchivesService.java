package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SocArchives;
import cn.ibizlab.ehr.core.soc.filter.SocArchivesSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocArchives] 服务对象接口
 */
public interface ISocArchivesService extends IService<SocArchives>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SocArchives getDraft(SocArchives et) ;
    boolean update(SocArchives et) ;
    void updateBatch(List<SocArchives> list) ;
    SocArchives get(String key) ;
    SocArchives stopArchives(SocArchives et) ;
    boolean save(SocArchives et) ;
    void saveBatch(List<SocArchives> list) ;
    boolean create(SocArchives et) ;
    void createBatch(List<SocArchives> list) ;
    boolean checkKey(SocArchives et) ;
    Page<SocArchives> searchOrgArchives(SocArchivesSearchContext context) ;
    Page<SocArchives> searchDefault(SocArchivesSearchContext context) ;
    Page<SocArchives> searchStopArchives(SocArchivesSearchContext context) ;
    List<SocArchives> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<SocArchives> selectBySocaccountid(String socaccountid) ;
    void removeBySocaccountid(String socaccountid) ;
    List<SocArchives> selectBySocruleid(String socruleid) ;
    void removeBySocruleid(String socruleid) ;
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

    List<SocArchives> getSocarchivesByIds(List<String> ids) ;
    List<SocArchives> getSocarchivesByEntities(List<SocArchives> entities) ;

}


