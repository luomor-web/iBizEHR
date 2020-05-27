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

import cn.ibizlab.ehr.core.vac.domain.VACSYNJCX;
import cn.ibizlab.ehr.core.vac.filter.VACSYNJCXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACSYNJCX] 服务对象接口
 */
public interface IVACSYNJCXService extends IService<VACSYNJCX>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(VACSYNJCX et) ;
    void updateBatch(List<VACSYNJCX> list) ;
    boolean checkKey(VACSYNJCX et) ;
    VACSYNJCX get(String key) ;
    boolean save(VACSYNJCX et) ;
    void saveBatch(List<VACSYNJCX> list) ;
    VACSYNJCX jSTS(VACSYNJCX et) ;
    boolean create(VACSYNJCX et) ;
    void createBatch(List<VACSYNJCX> list) ;
    VACSYNJCX getDraft(VACSYNJCX et) ;
    Page<VACSYNJCX> searchDefault(VACSYNJCXSearchContext context) ;
    List<VACSYNJCX> selectByPimpersonid(String pimpersonid) ;
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

    List<VACSYNJCX> getVacsynjcxByIds(List<String> ids) ;
    List<VACSYNJCX> getVacsynjcxByEntities(List<VACSYNJCX> entities) ;

}


