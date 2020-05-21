package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SALTYPE;
import cn.ibizlab.ehr.core.sal.filter.SALTYPESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALTYPE] 服务对象接口
 */
public interface ISALTYPEService extends IService<SALTYPE>{

    boolean checkKey(SALTYPE et) ;
    SALTYPE get(String key) ;
    SALTYPE getDraft(SALTYPE et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SALTYPE et) ;
    void saveBatch(List<SALTYPE> list) ;
    boolean create(SALTYPE et) ;
    void createBatch(List<SALTYPE> list) ;
    boolean update(SALTYPE et) ;
    void updateBatch(List<SALTYPE> list) ;
    Page<SALTYPE> searchDefault(SALTYPESearchContext context) ;
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


