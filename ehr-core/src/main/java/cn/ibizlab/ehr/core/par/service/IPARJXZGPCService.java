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

import cn.ibizlab.ehr.core.par.domain.PARJXZGPC;
import cn.ibizlab.ehr.core.par.filter.PARJXZGPCSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXZGPC] 服务对象接口
 */
public interface IPARJXZGPCService extends IService<PARJXZGPC>{

    boolean create(PARJXZGPC et) ;
    void createBatch(List<PARJXZGPC> list) ;
    boolean save(PARJXZGPC et) ;
    void saveBatch(List<PARJXZGPC> list) ;
    PARJXZGPC getDraft(PARJXZGPC et) ;
    PARJXZGPC get(String key) ;
    boolean checkKey(PARJXZGPC et) ;
    boolean update(PARJXZGPC et) ;
    void updateBatch(List<PARJXZGPC> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PARJXZGPC> searchDefault(PARJXZGPCSearchContext context) ;
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


