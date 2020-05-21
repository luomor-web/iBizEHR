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

import cn.ibizlab.ehr.core.par.domain.PARJXZGPCMX;
import cn.ibizlab.ehr.core.par.filter.PARJXZGPCMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXZGPCMX] 服务对象接口
 */
public interface IPARJXZGPCMXService extends IService<PARJXZGPCMX>{

    PARJXZGPCMX getDraft(PARJXZGPCMX et) ;
    boolean update(PARJXZGPCMX et) ;
    void updateBatch(List<PARJXZGPCMX> list) ;
    boolean save(PARJXZGPCMX et) ;
    void saveBatch(List<PARJXZGPCMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PARJXZGPCMX et) ;
    void createBatch(List<PARJXZGPCMX> list) ;
    PARJXZGPCMX get(String key) ;
    boolean checkKey(PARJXZGPCMX et) ;
    Page<PARJXZGPCMX> searchDefault(PARJXZGPCMXSearchContext context) ;
    List<PARJXZGPCMX> selectByParjxzgpcid(String parjxzgpcid) ;
    void removeByParjxzgpcid(String parjxzgpcid) ;
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


