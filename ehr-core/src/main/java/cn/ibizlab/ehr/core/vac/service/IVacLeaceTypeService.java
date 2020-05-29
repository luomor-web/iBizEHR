package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VacLeaceType;
import cn.ibizlab.ehr.core.vac.filter.VacLeaceTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacLeaceType] 服务对象接口
 */
public interface IVacLeaceTypeService extends IService<VacLeaceType>{

    boolean update(VacLeaceType et) ;
    void updateBatch(List<VacLeaceType> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(VacLeaceType et) ;
    void createBatch(List<VacLeaceType> list) ;
    VacLeaceType getDraft(VacLeaceType et) ;
    boolean save(VacLeaceType et) ;
    void saveBatch(List<VacLeaceType> list) ;
    boolean checkKey(VacLeaceType et) ;
    VacLeaceType get(String key) ;
    Page<VacLeaceType> searchDefault(VacLeaceTypeSearchContext context) ;
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

    List<VacLeaceType> getVacleacetypeByIds(List<String> ids) ;
    List<VacLeaceType> getVacleacetypeByEntities(List<VacLeaceType> entities) ;

}


