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

import cn.ibizlab.ehr.core.vac.domain.VacWFQj;
import cn.ibizlab.ehr.core.vac.filter.VacWFQjSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacWFQj] 服务对象接口
 */
public interface IVacWFQjService extends IService<VacWFQj>{

    boolean update(VacWFQj et) ;
    void updateBatch(List<VacWFQj> list) ;
    boolean checkKey(VacWFQj et) ;
    boolean create(VacWFQj et) ;
    void createBatch(List<VacWFQj> list) ;
    boolean save(VacWFQj et) ;
    void saveBatch(List<VacWFQj> list) ;
    VacWFQj getDraft(VacWFQj et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    VacWFQj get(String key) ;
    Page<VacWFQj> searchDefault(VacWFQjSearchContext context) ;
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

    List<VacWFQj> getVacwfqjByIds(List<String> ids) ;
    List<VacWFQj> getVacwfqjByEntities(List<VacWFQj> entities) ;

}


