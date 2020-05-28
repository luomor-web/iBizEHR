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

import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESCHANGE;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESCHANGESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMARCHIVESCHANGE] 服务对象接口
 */
public interface IPIMARCHIVESCHANGEService extends IService<PIMARCHIVESCHANGE>{

    boolean update(PIMARCHIVESCHANGE et) ;
    void updateBatch(List<PIMARCHIVESCHANGE> list) ;
    PIMARCHIVESCHANGE get(String key) ;
    boolean create(PIMARCHIVESCHANGE et) ;
    void createBatch(List<PIMARCHIVESCHANGE> list) ;
    PIMARCHIVESCHANGE getDraft(PIMARCHIVESCHANGE et) ;
    boolean checkKey(PIMARCHIVESCHANGE et) ;
    PIMARCHIVESCHANGE updatePersonFile(PIMARCHIVESCHANGE et) ;
    boolean save(PIMARCHIVESCHANGE et) ;
    void saveBatch(List<PIMARCHIVESCHANGE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PIMARCHIVESCHANGE> searchDADCJL(PIMARCHIVESCHANGESearchContext context) ;
    Page<PIMARCHIVESCHANGE> searchDefault(PIMARCHIVESCHANGESearchContext context) ;
    List<PIMARCHIVESCHANGE> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PIMARCHIVESCHANGE> selectByOrmorgid2(String orgid) ;
    void removeByOrmorgid2(String orgid) ;
    List<PIMARCHIVESCHANGE> selectByPimarchivesid(String pimarchivesid) ;
    void removeByPimarchivesid(String pimarchivesid) ;
    List<PIMARCHIVESCHANGE> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMARCHIVESCHANGE> getPimarchiveschangeByIds(List<String> ids) ;
    List<PIMARCHIVESCHANGE> getPimarchiveschangeByEntities(List<PIMARCHIVESCHANGE> entities) ;

}


