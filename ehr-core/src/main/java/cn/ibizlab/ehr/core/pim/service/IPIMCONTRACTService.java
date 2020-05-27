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

import cn.ibizlab.ehr.core.pim.domain.PIMCONTRACT;
import cn.ibizlab.ehr.core.pim.filter.PIMCONTRACTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMCONTRACT] 服务对象接口
 */
public interface IPIMCONTRACTService extends IService<PIMCONTRACT>{

    boolean checkKey(PIMCONTRACT et) ;
    PIMCONTRACT calContractTime(PIMCONTRACT et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMCONTRACT get(String key) ;
    boolean create(PIMCONTRACT et) ;
    void createBatch(List<PIMCONTRACT> list) ;
    boolean save(PIMCONTRACT et) ;
    void saveBatch(List<PIMCONTRACT> list) ;
    PIMCONTRACT stopContract(PIMCONTRACT et) ;
    boolean update(PIMCONTRACT et) ;
    void updateBatch(List<PIMCONTRACT> list) ;
    PIMCONTRACT getDraft(PIMCONTRACT et) ;
    Page<PIMCONTRACT> searchRSTXDS(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchJLSS(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchOrderByOrg(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchStopContracts(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchSignContracts(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchDefault(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchXYHT(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchZIZHU(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchLDHT(PIMCONTRACTSearchContext context) ;
    Page<PIMCONTRACT> searchLWHT(PIMCONTRACTSearchContext context) ;
    List<PIMCONTRACT> selectByContractsignorgid(String contractsignorgid) ;
    void removeByContractsignorgid(String contractsignorgid) ;
    List<PIMCONTRACT> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PIMCONTRACT> selectByOrmsignorgid(String ormsignorgid) ;
    void removeByOrmsignorgid(String ormsignorgid) ;
    List<PIMCONTRACT> selectByPimlabourcampanyid(String pimlabourcampanyid) ;
    void removeByPimlabourcampanyid(String pimlabourcampanyid) ;
    List<PIMCONTRACT> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMCONTRACT> getPimcontractByIds(List<String> ids) ;
    List<PIMCONTRACT> getPimcontractByEntities(List<PIMCONTRACT> entities) ;

}


