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

import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMARCHIVES] 服务对象接口
 */
public interface IPIMARCHIVESService extends IService<PIMARCHIVES>{

    PIMARCHIVES getPersonOrg(PIMARCHIVES et) ;
    PIMARCHIVES getDraft(PIMARCHIVES et) ;
    boolean save(PIMARCHIVES et) ;
    void saveBatch(List<PIMARCHIVES> list) ;
    PIMARCHIVES get(String key) ;
    boolean update(PIMARCHIVES et) ;
    void updateBatch(List<PIMARCHIVES> list) ;
    boolean checkKey(PIMARCHIVES et) ;
    boolean create(PIMARCHIVES et) ;
    void createBatch(List<PIMARCHIVES> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PIMARCHIVES> searchEMLOYEENOFILE(PIMARCHIVESSearchContext context) ;
    Page<PIMARCHIVES> searchSysOrgIsSrfOrg(PIMARCHIVESSearchContext context) ;
    Page<PIMARCHIVES> searchDefault(PIMARCHIVESSearchContext context) ;
    Page<PIMARCHIVES> searchJLSS(PIMARCHIVESSearchContext context) ;
    Page<PIMARCHIVES> searchZIZHU(PIMARCHIVESSearchContext context) ;
    Page<PIMARCHIVES> searchNOEMLOYEENOFILE(PIMARCHIVESSearchContext context) ;
    Page<PIMARCHIVES> searchPIMREADGJD(PIMARCHIVESSearchContext context) ;
    List<PIMARCHIVES> selectByArchivescenterid(String archivescenterid) ;
    void removeByArchivescenterid(String archivescenterid) ;
    List<PIMARCHIVES> selectByOrmorgid2(String orgid) ;
    void removeByOrmorgid2(String orgid) ;
    List<PIMARCHIVES> selectByOrmorgid3(String orgid) ;
    void removeByOrmorgid3(String orgid) ;
    List<PIMARCHIVES> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMARCHIVES> getPimarchivesByIds(List<String> ids) ;
    List<PIMARCHIVES> getPimarchivesByEntities(List<PIMARCHIVES> entities) ;

}


