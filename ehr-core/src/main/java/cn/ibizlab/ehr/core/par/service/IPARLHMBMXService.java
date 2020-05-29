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

import cn.ibizlab.ehr.core.par.domain.PARLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARLHMBMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARLHMBMX] 服务对象接口
 */
public interface IPARLHMBMXService extends IService<PARLHMBMX>{

    boolean checkKey(PARLHMBMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARLHMBMX et) ;
    void saveBatch(List<PARLHMBMX> list) ;
    PARLHMBMX getDraft(PARLHMBMX et) ;
    PARLHMBMX get(String key) ;
    boolean update(PARLHMBMX et) ;
    void updateBatch(List<PARLHMBMX> list) ;
    boolean create(PARLHMBMX et) ;
    void createBatch(List<PARLHMBMX> list) ;
    Page<PARLHMBMX> searchDefault(PARLHMBMXSearchContext context) ;
    List<PARLHMBMX> selectByParjxlhmbid(String parjxlhmbid) ;
    void removeByParjxlhmbid(String parjxlhmbid) ;
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

    List<PARLHMBMX> getParlhmbmxByIds(List<String> ids) ;
    List<PARLHMBMX> getParlhmbmxByEntities(List<PARLHMBMX> entities) ;

}


