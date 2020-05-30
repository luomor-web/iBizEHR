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

import cn.ibizlab.ehr.core.pim.domain.PimGwType;
import cn.ibizlab.ehr.core.pim.filter.PimGwTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimGwType] 服务对象接口
 */
public interface IPimGwTypeService extends IService<PimGwType>{

    boolean save(PimGwType et) ;
    void saveBatch(List<PimGwType> list) ;
    PimGwType getDraft(PimGwType et) ;
    PimGwType get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PimGwType et) ;
    boolean update(PimGwType et) ;
    void updateBatch(List<PimGwType> list) ;
    boolean create(PimGwType et) ;
    void createBatch(List<PimGwType> list) ;
    Page<PimGwType> searchDefault(PimGwTypeSearchContext context) ;
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

    List<PimGwType> getPimgwtypeByIds(List<String> ids) ;
    List<PimGwType> getPimgwtypeByEntities(List<PimGwType> entities) ;

}


