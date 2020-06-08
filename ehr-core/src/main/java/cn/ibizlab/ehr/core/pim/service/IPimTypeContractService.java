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

import cn.ibizlab.ehr.core.pim.domain.PimTypeContract;
import cn.ibizlab.ehr.core.pim.filter.PimTypeContractSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimTypeContract] 服务对象接口
 */
public interface IPimTypeContractService extends IService<PimTypeContract>{

    boolean update(PimTypeContract et) ;
    void updateBatch(List<PimTypeContract> list) ;
    boolean checkKey(PimTypeContract et) ;
    PimTypeContract get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimTypeContract et) ;
    void createBatch(List<PimTypeContract> list) ;
    boolean save(PimTypeContract et) ;
    void saveBatch(List<PimTypeContract> list) ;
    PimTypeContract getDraft(PimTypeContract et) ;
    Page<PimTypeContract> searchDefault(PimTypeContractSearchContext context) ;
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

    List<PimTypeContract> getPimtypecontractByIds(List<String> ids) ;
    List<PimTypeContract> getPimtypecontractByEntities(List<PimTypeContract> entities) ;

}


