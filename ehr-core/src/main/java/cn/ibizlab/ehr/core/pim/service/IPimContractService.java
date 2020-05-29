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

import cn.ibizlab.ehr.core.pim.domain.PimContract;
import cn.ibizlab.ehr.core.pim.filter.PimContractSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimContract] 服务对象接口
 */
public interface IPimContractService extends IService<PimContract>{

    boolean checkKey(PimContract et) ;
    PimContract calContractTime(PimContract et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimContract get(String key) ;
    boolean create(PimContract et) ;
    void createBatch(List<PimContract> list) ;
    boolean save(PimContract et) ;
    void saveBatch(List<PimContract> list) ;
    PimContract stopContract(PimContract et) ;
    boolean update(PimContract et) ;
    void updateBatch(List<PimContract> list) ;
    PimContract getDraft(PimContract et) ;
    Page<PimContract> searchRSTXDS(PimContractSearchContext context) ;
    Page<PimContract> searchJLSS(PimContractSearchContext context) ;
    Page<PimContract> searchOrderByOrg(PimContractSearchContext context) ;
    Page<PimContract> searchStopContracts(PimContractSearchContext context) ;
    Page<PimContract> searchSignContracts(PimContractSearchContext context) ;
    Page<PimContract> searchDefault(PimContractSearchContext context) ;
    Page<PimContract> searchXYHT(PimContractSearchContext context) ;
    Page<PimContract> searchZIZHU(PimContractSearchContext context) ;
    Page<PimContract> searchLDHT(PimContractSearchContext context) ;
    Page<PimContract> searchLWHT(PimContractSearchContext context) ;
    List<PimContract> selectByContractsignorgid(String contractsignorgid) ;
    void removeByContractsignorgid(String contractsignorgid) ;
    List<PimContract> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimContract> selectByOrmsignorgid(String ormsignorgid) ;
    void removeByOrmsignorgid(String ormsignorgid) ;
    List<PimContract> selectByPimlabourcampanyid(String pimlabourcampanyid) ;
    void removeByPimlabourcampanyid(String pimlabourcampanyid) ;
    List<PimContract> selectByPimpersonid(String pimpersonid) ;
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

    List<PimContract> getPimcontractByIds(List<String> ids) ;
    List<PimContract> getPimcontractByEntities(List<PimContract> entities) ;

}


