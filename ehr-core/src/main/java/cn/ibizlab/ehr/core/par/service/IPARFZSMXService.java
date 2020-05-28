package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.PARFZSMX;
import cn.ibizlab.ehr.core.par.filter.PARFZSMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARFZSMX] 服务对象接口
 */
public interface IPARFZSMXService extends IService<PARFZSMX>{

    PARFZSMX getDraft(PARFZSMX et) ;
    boolean update(PARFZSMX et) ;
    void updateBatch(List<PARFZSMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PARFZSMX et) ;
    void createBatch(List<PARFZSMX> list) ;
    boolean checkKey(PARFZSMX et) ;
    boolean save(PARFZSMX et) ;
    void saveBatch(List<PARFZSMX> list) ;
    PARFZSMX get(String key) ;
    Page<PARFZSMX> searchDefault(PARFZSMXSearchContext context) ;
    List<PARFZSMX> selectByPartzggid(String partzggid) ;
    void removeByPartzggid(String partzggid) ;
    List<PARFZSMX> selectByPimpersonid(String pimpersonid) ;
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

    List<PARFZSMX> getParfzsmxByIds(List<String> ids) ;
    List<PARFZSMX> getParfzsmxByEntities(List<PARFZSMX> entities) ;

}


