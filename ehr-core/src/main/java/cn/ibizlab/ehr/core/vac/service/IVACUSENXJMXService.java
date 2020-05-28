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

import cn.ibizlab.ehr.core.vac.domain.VACUSENXJMX;
import cn.ibizlab.ehr.core.vac.filter.VACUSENXJMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACUSENXJMX] 服务对象接口
 */
public interface IVACUSENXJMXService extends IService<VACUSENXJMX>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(VACUSENXJMX et) ;
    boolean create(VACUSENXJMX et) ;
    void createBatch(List<VACUSENXJMX> list) ;
    boolean update(VACUSENXJMX et) ;
    void updateBatch(List<VACUSENXJMX> list) ;
    boolean save(VACUSENXJMX et) ;
    void saveBatch(List<VACUSENXJMX> list) ;
    VACUSENXJMX getDraft(VACUSENXJMX et) ;
    VACUSENXJMX get(String key) ;
    Page<VACUSENXJMX> searchDefault(VACUSENXJMXSearchContext context) ;
    List<VACUSENXJMX> selectByVacleavedetailid(String vacleavedetailid) ;
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

    List<VACUSENXJMX> getVacusenxjmxByIds(List<String> ids) ;
    List<VACUSENXJMX> getVacusenxjmxByEntities(List<VACUSENXJMX> entities) ;

}


