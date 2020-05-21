package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFOMX;
import cn.ibizlab.ehr.core.soc.filter.SOCWELFAREINFOMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SOCWELFAREINFOMX] 服务对象接口
 */
public interface ISOCWELFAREINFOMXService extends IService<SOCWELFAREINFOMX>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SOCWELFAREINFOMX et) ;
    void saveBatch(List<SOCWELFAREINFOMX> list) ;
    boolean checkKey(SOCWELFAREINFOMX et) ;
    SOCWELFAREINFOMX getDraft(SOCWELFAREINFOMX et) ;
    boolean create(SOCWELFAREINFOMX et) ;
    void createBatch(List<SOCWELFAREINFOMX> list) ;
    SOCWELFAREINFOMX get(String key) ;
    boolean update(SOCWELFAREINFOMX et) ;
    void updateBatch(List<SOCWELFAREINFOMX> list) ;
    Page<SOCWELFAREINFOMX> searchDefault(SOCWELFAREINFOMXSearchContext context) ;
    List<SOCWELFAREINFOMX> selectBySocselfarebasemxid(String socselfarebasemxid) ;
    void removeBySocselfarebasemxid(String socselfarebasemxid) ;
    List<SOCWELFAREINFOMX> selectBySocwelfareinfoid(String socwelfareinfoid) ;
    void removeBySocwelfareinfoid(String socwelfareinfoid) ;
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


