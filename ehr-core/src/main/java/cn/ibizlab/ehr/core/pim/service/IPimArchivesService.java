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

import cn.ibizlab.ehr.core.pim.domain.PimArchives;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArchives] 服务对象接口
 */
public interface IPimArchivesService extends IService<PimArchives>{

    PimArchives getPersonOrg(PimArchives et) ;
    PimArchives getDraft(PimArchives et) ;
    boolean save(PimArchives et) ;
    void saveBatch(List<PimArchives> list) ;
    PimArchives get(String key) ;
    boolean update(PimArchives et) ;
    void updateBatch(List<PimArchives> list) ;
    boolean checkKey(PimArchives et) ;
    boolean create(PimArchives et) ;
    void createBatch(List<PimArchives> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimArchives> searchEMLOYEENOFILE(PimArchivesSearchContext context) ;
    Page<PimArchives> searchSysOrgIsSrfOrg(PimArchivesSearchContext context) ;
    Page<PimArchives> searchDefault(PimArchivesSearchContext context) ;
    Page<PimArchives> searchJLSS(PimArchivesSearchContext context) ;
    Page<PimArchives> searchZIZHU(PimArchivesSearchContext context) ;
    Page<PimArchives> searchNOEMLOYEENOFILE(PimArchivesSearchContext context) ;
    Page<PimArchives> searchPIMREADGJD(PimArchivesSearchContext context) ;
    List<PimArchives> selectByArchivescenterid(String archivescenterid) ;
    void removeByArchivescenterid(String archivescenterid) ;
    List<PimArchives> selectByOrmorgid2(String orgid) ;
    void removeByOrmorgid2(String orgid) ;
    List<PimArchives> selectByOrmorgid3(String orgid) ;
    void removeByOrmorgid3(String orgid) ;
    List<PimArchives> selectByPimpersonid(String pimpersonid) ;
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

    List<PimArchives> getPimarchivesByIds(List<String> ids) ;
    List<PimArchives> getPimarchivesByEntities(List<PimArchives> entities) ;

}


