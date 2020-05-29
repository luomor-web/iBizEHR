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

import cn.ibizlab.ehr.core.vac.domain.VACOVERALLTION;
import cn.ibizlab.ehr.core.vac.filter.VACOVERALLTIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACOVERALLTION] 服务对象接口
 */
public interface IVACOVERALLTIONService extends IService<VACOVERALLTION>{

    VACOVERALLTION getDraft(VACOVERALLTION et) ;
    boolean save(VACOVERALLTION et) ;
    void saveBatch(List<VACOVERALLTION> list) ;
    boolean checkKey(VACOVERALLTION et) ;
    boolean update(VACOVERALLTION et) ;
    void updateBatch(List<VACOVERALLTION> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(VACOVERALLTION et) ;
    void createBatch(List<VACOVERALLTION> list) ;
    VACOVERALLTION get(String key) ;
    Page<VACOVERALLTION> searchDefault(VACOVERALLTIONSearchContext context) ;
    List<VACOVERALLTION> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<VACOVERALLTION> selectByPimpersonid(String pimpersonid) ;
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

    List<VACOVERALLTION> getVacoveralltionByIds(List<String> ids) ;
    List<VACOVERALLTION> getVacoveralltionByEntities(List<VACOVERALLTION> entities) ;

}


