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

import cn.ibizlab.ehr.core.pim.domain.PimContractSignOrg;
import cn.ibizlab.ehr.core.pim.filter.PimContractSignOrgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimContractSignOrg] 服务对象接口
 */
public interface IPimContractSignOrgService extends IService<PimContractSignOrg>{

    PimContractSignOrg get(String key) ;
    boolean checkKey(PimContractSignOrg et) ;
    boolean update(PimContractSignOrg et) ;
    void updateBatch(List<PimContractSignOrg> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimContractSignOrg et) ;
    void createBatch(List<PimContractSignOrg> list) ;
    PimContractSignOrg getDraft(PimContractSignOrg et) ;
    boolean save(PimContractSignOrg et) ;
    void saveBatch(List<PimContractSignOrg> list) ;
    Page<PimContractSignOrg> searchDefault(PimContractSignOrgSearchContext context) ;
    Page<PimContractSignOrg> searchDefault2(PimContractSignOrgSearchContext context) ;
    List<PimContractSignOrg> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimContractSignOrg> selectByOrmsignorgid(String ormsignorgid) ;
    void removeByOrmsignorgid(String ormsignorgid) ;
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

    List<PimContractSignOrg> getPimcontractsignorgByIds(List<String> ids) ;
    List<PimContractSignOrg> getPimcontractsignorgByEntities(List<PimContractSignOrg> entities) ;

}


