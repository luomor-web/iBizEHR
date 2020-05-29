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

import cn.ibizlab.ehr.core.pim.domain.PimProvince;
import cn.ibizlab.ehr.core.pim.filter.PimProvinceSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimProvince] 服务对象接口
 */
public interface IPimProvinceService extends IService<PimProvince>{

    boolean checkKey(PimProvince et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimProvince get(String key) ;
    boolean create(PimProvince et) ;
    void createBatch(List<PimProvince> list) ;
    PimProvince getDraft(PimProvince et) ;
    boolean update(PimProvince et) ;
    void updateBatch(List<PimProvince> list) ;
    boolean save(PimProvince et) ;
    void saveBatch(List<PimProvince> list) ;
    Page<PimProvince> searchDefault(PimProvinceSearchContext context) ;
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

    List<PimProvince> getPimprovinceByIds(List<String> ids) ;
    List<PimProvince> getPimprovinceByEntities(List<PimProvince> entities) ;

}


