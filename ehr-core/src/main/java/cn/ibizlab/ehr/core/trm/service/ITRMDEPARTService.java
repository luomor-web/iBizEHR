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

import cn.ibizlab.ehr.core.trm.domain.TRMDEPART;
import cn.ibizlab.ehr.core.trm.filter.TRMDEPARTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMDEPART] 服务对象接口
 */
public interface ITRMDEPARTService extends IService<TRMDEPART>{

    TRMDEPART get(String key) ;
    boolean save(TRMDEPART et) ;
    void saveBatch(List<TRMDEPART> list) ;
    boolean create(TRMDEPART et) ;
    void createBatch(List<TRMDEPART> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TRMDEPART et) ;
    boolean update(TRMDEPART et) ;
    void updateBatch(List<TRMDEPART> list) ;
    TRMDEPART getDraft(TRMDEPART et) ;
    Page<TRMDEPART> searchDefault(TRMDEPARTSearchContext context) ;
    List<TRMDEPART> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TRMDEPART> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMDEPART> selectByPimpersonid(String pimpersonid) ;
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

}


