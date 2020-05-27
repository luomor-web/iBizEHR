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

import cn.ibizlab.ehr.core.par.domain.PARLHMBKHMX;
import cn.ibizlab.ehr.core.par.filter.PARLHMBKHMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARLHMBKHMX] 服务对象接口
 */
public interface IPARLHMBKHMXService extends IService<PARLHMBKHMX>{

    boolean update(PARLHMBKHMX et) ;
    void updateBatch(List<PARLHMBKHMX> list) ;
    PARLHMBKHMX getDraft(PARLHMBKHMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARLHMBKHMX et) ;
    void saveBatch(List<PARLHMBKHMX> list) ;
    boolean checkKey(PARLHMBKHMX et) ;
    PARLHMBKHMX get(String key) ;
    boolean create(PARLHMBKHMX et) ;
    void createBatch(List<PARLHMBKHMX> list) ;
    Page<PARLHMBKHMX> searchDefault(PARLHMBKHMXSearchContext context) ;
    List<PARLHMBKHMX> selectByParndlhmbkhid(String parndlhmbkhid) ;
    void removeByParndlhmbkhid(String parndlhmbkhid) ;
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

    List<PARLHMBKHMX> getParlhmbkhmxByIds(List<String> ids) ;
    List<PARLHMBKHMX> getParlhmbkhmxByEntities(List<PARLHMBKHMX> entities) ;

}


