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

import cn.ibizlab.ehr.core.pim.domain.PimContractType;
import cn.ibizlab.ehr.core.pim.filter.PimContractTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimContractType] 服务对象接口
 */
public interface IPimContractTypeService extends IService<PimContractType>{

    boolean update(PimContractType et) ;
    void updateBatch(List<PimContractType> list) ;
    boolean save(PimContractType et) ;
    void saveBatch(List<PimContractType> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimContractType et) ;
    void createBatch(List<PimContractType> list) ;
    PimContractType get(String key) ;
    PimContractType getDraft(PimContractType et) ;
    boolean checkKey(PimContractType et) ;
    Page<PimContractType> searchDefault(PimContractTypeSearchContext context) ;
    List<PimContractType> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<PimContractType> getPimcontracttypeByIds(List<String> ids) ;
    List<PimContractType> getPimcontracttypeByEntities(List<PimContractType> entities) ;

}


