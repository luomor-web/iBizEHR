package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TrmGradecadres;
import cn.ibizlab.ehr.core.trm.filter.TrmGradecadresSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmGradecadres] 服务对象接口
 */
public interface ITrmGradecadresService extends IService<TrmGradecadres>{

    boolean update(TrmGradecadres et) ;
    void updateBatch(List<TrmGradecadres> list) ;
    boolean checkKey(TrmGradecadres et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(TrmGradecadres et) ;
    void createBatch(List<TrmGradecadres> list) ;
    TrmGradecadres getDraft(TrmGradecadres et) ;
    boolean save(TrmGradecadres et) ;
    void saveBatch(List<TrmGradecadres> list) ;
    TrmGradecadres get(String key) ;
    Page<TrmGradecadres> searchDefault(TrmGradecadresSearchContext context) ;
    List<TrmGradecadres> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<TrmGradecadres> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TrmGradecadres> selectByOrmorgsectorid2(String orgsectorid) ;
    void removeByOrmorgsectorid2(String orgsectorid) ;
    List<TrmGradecadres> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmGradecadres> selectByOrmorgid2(String orgid) ;
    void removeByOrmorgid2(String orgid) ;
    List<TrmGradecadres> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
    List<TrmGradecadres> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmGradecadres> selectByPimpersonid2(String pimpersonid) ;
    void removeByPimpersonid2(String pimpersonid) ;
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

    List<TrmGradecadres> getTrmgradecadresByIds(List<String> ids) ;
    List<TrmGradecadres> getTrmgradecadresByEntities(List<TrmGradecadres> entities) ;

}


