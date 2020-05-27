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

import cn.ibizlab.ehr.core.pim.domain.PIMPERSONCHANGE;
import cn.ibizlab.ehr.core.pim.filter.PIMPERSONCHANGESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMPERSONCHANGE] 服务对象接口
 */
public interface IPIMPERSONCHANGEService extends IService<PIMPERSONCHANGE>{

    boolean save(PIMPERSONCHANGE et) ;
    void saveBatch(List<PIMPERSONCHANGE> list) ;
    PIMPERSONCHANGE bH(PIMPERSONCHANGE et) ;
    PIMPERSONCHANGE ensure(PIMPERSONCHANGE et) ;
    boolean update(PIMPERSONCHANGE et) ;
    void updateBatch(List<PIMPERSONCHANGE> list) ;
    PIMPERSONCHANGE get(String key) ;
    boolean create(PIMPERSONCHANGE et) ;
    void createBatch(List<PIMPERSONCHANGE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMPERSONCHANGE qR(PIMPERSONCHANGE et) ;
    boolean checkKey(PIMPERSONCHANGE et) ;
    PIMPERSONCHANGE getDraft(PIMPERSONCHANGE et) ;
    Page<PIMPERSONCHANGE> searchHistoryRec(PIMPERSONCHANGESearchContext context) ;
    Page<PIMPERSONCHANGE> searchPIMCL_NOTAPPROVAL(PIMPERSONCHANGESearchContext context) ;
    Page<PIMPERSONCHANGE> searchHeadRed(PIMPERSONCHANGESearchContext context) ;
    Page<PIMPERSONCHANGE> searchDefault(PIMPERSONCHANGESearchContext context) ;
    List<PIMPERSONCHANGE> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMPERSONCHANGE> getPimpersonchangeByIds(List<String> ids) ;
    List<PIMPERSONCHANGE> getPimpersonchangeByEntities(List<PIMPERSONCHANGE> entities) ;

}


