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

import cn.ibizlab.ehr.core.pim.domain.PimArchivesChange;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesChangeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArchivesChange] 服务对象接口
 */
public interface IPimArchivesChangeService extends IService<PimArchivesChange>{

    boolean update(PimArchivesChange et) ;
    void updateBatch(List<PimArchivesChange> list) ;
    PimArchivesChange get(String key) ;
    boolean create(PimArchivesChange et) ;
    void createBatch(List<PimArchivesChange> list) ;
    PimArchivesChange getDraft(PimArchivesChange et) ;
    boolean checkKey(PimArchivesChange et) ;
    PimArchivesChange updatePersonFile(PimArchivesChange et) ;
    boolean save(PimArchivesChange et) ;
    void saveBatch(List<PimArchivesChange> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimArchivesChange> searchDADCJL(PimArchivesChangeSearchContext context) ;
    Page<PimArchivesChange> searchDefault(PimArchivesChangeSearchContext context) ;
    List<PimArchivesChange> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimArchivesChange> selectByOrmorgid2(String orgid) ;
    void removeByOrmorgid2(String orgid) ;
    List<PimArchivesChange> selectByPimarchivesid(String pimarchivesid) ;
    void removeByPimarchivesid(String pimarchivesid) ;
    List<PimArchivesChange> selectByPimpersonid(String pimpersonid) ;
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

    List<PimArchivesChange> getPimarchiveschangeByIds(List<String> ids) ;
    List<PimArchivesChange> getPimarchiveschangeByEntities(List<PimArchivesChange> entities) ;

}


