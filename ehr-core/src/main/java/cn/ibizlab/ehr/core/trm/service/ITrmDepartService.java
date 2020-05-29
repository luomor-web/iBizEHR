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

import cn.ibizlab.ehr.core.trm.domain.TrmDepart;
import cn.ibizlab.ehr.core.trm.filter.TrmDepartSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmDepart] 服务对象接口
 */
public interface ITrmDepartService extends IService<TrmDepart>{

    TrmDepart get(String key) ;
    boolean save(TrmDepart et) ;
    void saveBatch(List<TrmDepart> list) ;
    boolean create(TrmDepart et) ;
    void createBatch(List<TrmDepart> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TrmDepart et) ;
    boolean update(TrmDepart et) ;
    void updateBatch(List<TrmDepart> list) ;
    TrmDepart getDraft(TrmDepart et) ;
    Page<TrmDepart> searchDefault(TrmDepartSearchContext context) ;
    List<TrmDepart> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TrmDepart> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmDepart> selectByPimpersonid(String pimpersonid) ;
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

    List<TrmDepart> getTrmdepartByIds(List<String> ids) ;
    List<TrmDepart> getTrmdepartByEntities(List<TrmDepart> entities) ;

}


