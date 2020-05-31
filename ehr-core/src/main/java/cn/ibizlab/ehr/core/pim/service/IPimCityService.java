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

import cn.ibizlab.ehr.core.pim.domain.PimCity;
import cn.ibizlab.ehr.core.pim.filter.PimCitySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimCity] 服务对象接口
 */
public interface IPimCityService extends IService<PimCity>{

    boolean checkKey(PimCity et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimCity getDraft(PimCity et) ;
    boolean update(PimCity et) ;
    void updateBatch(List<PimCity> list) ;
    boolean save(PimCity et) ;
    void saveBatch(List<PimCity> list) ;
    PimCity get(String key) ;
    boolean create(PimCity et) ;
    void createBatch(List<PimCity> list) ;
    Page<PimCity> searchDefault(PimCitySearchContext context) ;
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

    List<PimCity> getPimcityByIds(List<String> ids) ;
    List<PimCity> getPimcityByEntities(List<PimCity> entities) ;

}


