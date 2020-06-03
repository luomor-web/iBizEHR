package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SalSchemeItem;
import cn.ibizlab.ehr.core.sal.filter.SalSchemeItemSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalSchemeItem] 服务对象接口
 */
public interface ISalSchemeItemService extends IService<SalSchemeItem>{

    boolean update(SalSchemeItem et) ;
    void updateBatch(List<SalSchemeItem> list) ;
    boolean save(SalSchemeItem et) ;
    void saveBatch(List<SalSchemeItem> list) ;
    SalSchemeItem get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SalSchemeItem et) ;
    boolean create(SalSchemeItem et) ;
    void createBatch(List<SalSchemeItem> list) ;
    SalSchemeItem getDraft(SalSchemeItem et) ;
    Page<SalSchemeItem> searchDefault(SalSchemeItemSearchContext context) ;
    List<SalSchemeItem> selectBySalitemid(String salitemid) ;
    void removeBySalitemid(String salitemid) ;
    List<SalSchemeItem> selectBySalruleid(String salruleid) ;
    void removeBySalruleid(String salruleid) ;
    List<SalSchemeItem> selectBySalschemeid(String salschemeid) ;
    void removeBySalschemeid(String salschemeid) ;
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

    List<SalSchemeItem> getSalschemeitemByIds(List<String> ids) ;
    List<SalSchemeItem> getSalschemeitemByEntities(List<SalSchemeItem> entities) ;

}


