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

import cn.ibizlab.ehr.core.par.domain.PARKHFA;
import cn.ibizlab.ehr.core.par.filter.PARKHFASearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARKHFA] 服务对象接口
 */
public interface IPARKHFAService extends IService<PARKHFA>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARKHFA et) ;
    void saveBatch(List<PARKHFA> list) ;
    boolean create(PARKHFA et) ;
    void createBatch(List<PARKHFA> list) ;
    boolean checkKey(PARKHFA et) ;
    PARKHFA getDraft(PARKHFA et) ;
    PARKHFA get(String key) ;
    boolean update(PARKHFA et) ;
    void updateBatch(List<PARKHFA> list) ;
    Page<PARKHFA> searchDefault(PARKHFASearchContext context) ;
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


