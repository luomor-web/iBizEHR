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

import cn.ibizlab.ehr.core.trm.domain.TrmDutyCadres;
import cn.ibizlab.ehr.core.trm.filter.TrmDutyCadresSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmDutyCadres] 服务对象接口
 */
public interface ITrmDutyCadresService extends IService<TrmDutyCadres>{

    boolean save(TrmDutyCadres et) ;
    void saveBatch(List<TrmDutyCadres> list) ;
    TrmDutyCadres setNQGBXX(TrmDutyCadres et) ;
    TrmDutyCadres sX(TrmDutyCadres et) ;
    boolean create(TrmDutyCadres et) ;
    void createBatch(List<TrmDutyCadres> list) ;
    TrmDutyCadres getDraft(TrmDutyCadres et) ;
    boolean checkKey(TrmDutyCadres et) ;
    TrmDutyCadres xX(TrmDutyCadres et) ;
    TrmDutyCadres get(String key) ;
    boolean update(TrmDutyCadres et) ;
    void updateBatch(List<TrmDutyCadres> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TrmDutyCadres> searchCurCXFW(TrmDutyCadresSearchContext context) ;
    Page<TrmDutyCadres> searchDefault(TrmDutyCadresSearchContext context) ;
    List<TrmDutyCadres> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<TrmDutyCadres> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TrmDutyCadres> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmDutyCadres> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<TrmDutyCadres> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
    List<TrmDutyCadres> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmDutyCadres> selectByPimpersonid2(String pimpersonid) ;
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

    List<TrmDutyCadres> getTrmdutycadresByIds(List<String> ids) ;
    List<TrmDutyCadres> getTrmdutycadresByEntities(List<TrmDutyCadres> entities) ;

}


