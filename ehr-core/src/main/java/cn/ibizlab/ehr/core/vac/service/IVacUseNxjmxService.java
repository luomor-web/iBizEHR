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

import cn.ibizlab.ehr.core.vac.domain.VacUseNxjmx;
import cn.ibizlab.ehr.core.vac.filter.VacUseNxjmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacUseNxjmx] 服务对象接口
 */
public interface IVacUseNxjmxService extends IService<VacUseNxjmx>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(VacUseNxjmx et) ;
    boolean create(VacUseNxjmx et) ;
    void createBatch(List<VacUseNxjmx> list) ;
    boolean update(VacUseNxjmx et) ;
    void updateBatch(List<VacUseNxjmx> list) ;
    boolean save(VacUseNxjmx et) ;
    void saveBatch(List<VacUseNxjmx> list) ;
    VacUseNxjmx getDraft(VacUseNxjmx et) ;
    VacUseNxjmx get(String key) ;
    Page<VacUseNxjmx> searchDefault(VacUseNxjmxSearchContext context) ;
    List<VacUseNxjmx> selectByVacleavedetailid(String vacleavedetailid) ;
    void removeByVacleavedetailid(String vacleavedetailid) ;
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

    List<VacUseNxjmx> getVacusenxjmxByIds(List<String> ids) ;
    List<VacUseNxjmx> getVacusenxjmxByEntities(List<VacUseNxjmx> entities) ;

}


