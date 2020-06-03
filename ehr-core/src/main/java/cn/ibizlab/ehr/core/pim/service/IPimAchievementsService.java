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

import cn.ibizlab.ehr.core.pim.domain.PimAchievements;
import cn.ibizlab.ehr.core.pim.filter.PimAchievementsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimAchievements] 服务对象接口
 */
public interface IPimAchievementsService extends IService<PimAchievements>{

    boolean update(PimAchievements et) ;
    void updateBatch(List<PimAchievements> list) ;
    boolean save(PimAchievements et) ;
    void saveBatch(List<PimAchievements> list) ;
    PimAchievements getDraft(PimAchievements et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimAchievements get(String key) ;
    boolean checkKey(PimAchievements et) ;
    boolean create(PimAchievements et) ;
    void createBatch(List<PimAchievements> list) ;
    Page<PimAchievements> searchJLSS(PimAchievementsSearchContext context) ;
    Page<PimAchievements> searchDefault(PimAchievementsSearchContext context) ;
    Page<PimAchievements> searchZIZHU(PimAchievementsSearchContext context) ;
    List<PimAchievements> selectByPimpersonid(String pimpersonid) ;
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

    List<PimAchievements> getPimachievementsByIds(List<String> ids) ;
    List<PimAchievements> getPimachievementsByEntities(List<PimAchievements> entities) ;

}


