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

import cn.ibizlab.ehr.core.vac.domain.VacSynjcx;
import cn.ibizlab.ehr.core.vac.filter.VacSynjcxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacSynjcx] 服务对象接口
 */
public interface IVacSynjcxService extends IService<VacSynjcx>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(VacSynjcx et) ;
    void updateBatch(List<VacSynjcx> list) ;
    boolean checkKey(VacSynjcx et) ;
    VacSynjcx get(String key) ;
    boolean save(VacSynjcx et) ;
    void saveBatch(List<VacSynjcx> list) ;
    VacSynjcx jSTS(VacSynjcx et) ;
    boolean create(VacSynjcx et) ;
    void createBatch(List<VacSynjcx> list) ;
    VacSynjcx getDraft(VacSynjcx et) ;
    Page<VacSynjcx> searchDefault(VacSynjcxSearchContext context) ;
    List<VacSynjcx> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<VacSynjcx> getVacsynjcxByIds(List<String> ids) ;
    List<VacSynjcx> getVacsynjcxByEntities(List<VacSynjcx> entities) ;

}


