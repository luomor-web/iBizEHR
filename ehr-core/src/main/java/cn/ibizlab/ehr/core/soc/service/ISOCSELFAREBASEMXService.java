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

import cn.ibizlab.ehr.core.soc.domain.SOCSELFAREBASEMX;
import cn.ibizlab.ehr.core.soc.filter.SOCSELFAREBASEMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SOCSELFAREBASEMX] 服务对象接口
 */
public interface ISOCSELFAREBASEMXService extends IService<SOCSELFAREBASEMX>{

    boolean checkKey(SOCSELFAREBASEMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SOCSELFAREBASEMX get(String key) ;
    SOCSELFAREBASEMX getDraft(SOCSELFAREBASEMX et) ;
    boolean create(SOCSELFAREBASEMX et) ;
    void createBatch(List<SOCSELFAREBASEMX> list) ;
    boolean save(SOCSELFAREBASEMX et) ;
    void saveBatch(List<SOCSELFAREBASEMX> list) ;
    boolean update(SOCSELFAREBASEMX et) ;
    void updateBatch(List<SOCSELFAREBASEMX> list) ;
    Page<SOCSELFAREBASEMX> searchDefault(SOCSELFAREBASEMXSearchContext context) ;
    List<SOCSELFAREBASEMX> selectBySoccompanywelid(String soccompanywelid) ;
    void removeBySoccompanywelid(String soccompanywelid) ;
    List<SOCSELFAREBASEMX> selectBySocselfarebaseid(String socselfarebaseid) ;
    void removeBySocselfarebaseid(String socselfarebaseid) ;
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

    List<SOCSELFAREBASEMX> getSocselfarebasemxByIds(List<String> ids) ;
    List<SOCSELFAREBASEMX> getSocselfarebasemxByEntities(List<SOCSELFAREBASEMX> entities) ;

}


