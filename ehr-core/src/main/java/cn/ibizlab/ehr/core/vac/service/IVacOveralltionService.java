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

import cn.ibizlab.ehr.core.vac.domain.VacOveralltion;
import cn.ibizlab.ehr.core.vac.filter.VacOveralltionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacOveralltion] 服务对象接口
 */
public interface IVacOveralltionService extends IService<VacOveralltion>{

    VacOveralltion getDraft(VacOveralltion et) ;
    boolean save(VacOveralltion et) ;
    void saveBatch(List<VacOveralltion> list) ;
    boolean checkKey(VacOveralltion et) ;
    boolean update(VacOveralltion et) ;
    void updateBatch(List<VacOveralltion> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(VacOveralltion et) ;
    void createBatch(List<VacOveralltion> list) ;
    VacOveralltion get(String key) ;
    Page<VacOveralltion> searchDefault(VacOveralltionSearchContext context) ;
    List<VacOveralltion> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<VacOveralltion> selectByPimpersonid(String pimpersonid) ;
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

    List<VacOveralltion> getVacoveralltionByIds(List<String> ids) ;
    List<VacOveralltion> getVacoveralltionByEntities(List<VacOveralltion> entities) ;

}


