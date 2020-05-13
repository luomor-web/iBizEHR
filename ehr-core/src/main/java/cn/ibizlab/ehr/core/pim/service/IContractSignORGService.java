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

import cn.ibizlab.ehr.core.pim.domain.ContractSignORG;
import cn.ibizlab.ehr.core.pim.filter.ContractSignORGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ContractSignORG] 服务对象接口
 */
public interface IContractSignORGService extends IService<ContractSignORG>{

    ContractSignORG get(String key) ;
    boolean checkKey(ContractSignORG et) ;
    boolean update(ContractSignORG et) ;
    void updateBatch(List<ContractSignORG> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ContractSignORG et) ;
    void createBatch(List<ContractSignORG> list) ;
    ContractSignORG getDraft(ContractSignORG et) ;
    boolean save(ContractSignORG et) ;
    void saveBatch(List<ContractSignORG> list) ;
    Page<ContractSignORG> searchDefault(ContractSignORGSearchContext context) ;
    Page<ContractSignORG> searchDefault2(ContractSignORGSearchContext context) ;
    List<ContractSignORG> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<ContractSignORG> selectByOrmsignorgid(String ormsignorgid) ;
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

}


