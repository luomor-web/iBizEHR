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

import cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFO;
import cn.ibizlab.ehr.core.soc.filter.SOCWELFAREINFOSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SOCWELFAREINFO] 服务对象接口
 */
public interface ISOCWELFAREINFOService extends IService<SOCWELFAREINFO>{

    boolean checkKey(SOCWELFAREINFO et) ;
    SOCWELFAREINFO getFJSJofPerson(SOCWELFAREINFO et) ;
    boolean save(SOCWELFAREINFO et) ;
    void saveBatch(List<SOCWELFAREINFO> list) ;
    SOCWELFAREINFO getDraft(SOCWELFAREINFO et) ;
    SOCWELFAREINFO get(String key) ;
    SOCWELFAREINFO getCBDofSOCCOMPANYWEL(SOCWELFAREINFO et) ;
    boolean update(SOCWELFAREINFO et) ;
    void updateBatch(List<SOCWELFAREINFO> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SOCWELFAREINFO et) ;
    void createBatch(List<SOCWELFAREINFO> list) ;
    Page<SOCWELFAREINFO> searchDefault(SOCWELFAREINFOSearchContext context) ;
    List<SOCWELFAREINFO> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<SOCWELFAREINFO> selectBySoccompanywelid(String soccompanywelid) ;
    void removeBySoccompanywelid(String soccompanywelid) ;
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


