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

import cn.ibizlab.ehr.core.pim.domain.PIMACHIEVEMENTS;
import cn.ibizlab.ehr.core.pim.filter.PIMACHIEVEMENTSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMACHIEVEMENTS] 服务对象接口
 */
public interface IPIMACHIEVEMENTSService extends IService<PIMACHIEVEMENTS>{

    boolean update(PIMACHIEVEMENTS et) ;
    void updateBatch(List<PIMACHIEVEMENTS> list) ;
    boolean save(PIMACHIEVEMENTS et) ;
    void saveBatch(List<PIMACHIEVEMENTS> list) ;
    PIMACHIEVEMENTS getDraft(PIMACHIEVEMENTS et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMACHIEVEMENTS get(String key) ;
    boolean checkKey(PIMACHIEVEMENTS et) ;
    boolean create(PIMACHIEVEMENTS et) ;
    void createBatch(List<PIMACHIEVEMENTS> list) ;
    Page<PIMACHIEVEMENTS> searchJLSS(PIMACHIEVEMENTSSearchContext context) ;
    Page<PIMACHIEVEMENTS> searchDefault(PIMACHIEVEMENTSSearchContext context) ;
    Page<PIMACHIEVEMENTS> searchZIZHU(PIMACHIEVEMENTSSearchContext context) ;
    List<PIMACHIEVEMENTS> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMACHIEVEMENTS> getPimachievementsByIds(List<String> ids) ;
    List<PIMACHIEVEMENTS> getPimachievementsByEntities(List<PIMACHIEVEMENTS> entities) ;

}


