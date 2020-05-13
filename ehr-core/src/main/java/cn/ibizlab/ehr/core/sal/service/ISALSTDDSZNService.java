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

import cn.ibizlab.ehr.core.sal.domain.SALSTDDSZN;
import cn.ibizlab.ehr.core.sal.filter.SALSTDDSZNSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSTDDSZN] 服务对象接口
 */
public interface ISALSTDDSZNService extends IService<SALSTDDSZN>{

    boolean save(SALSTDDSZN et) ;
    void saveBatch(List<SALSTDDSZN> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALSTDDSZN get(String key) ;
    boolean update(SALSTDDSZN et) ;
    void updateBatch(List<SALSTDDSZN> list) ;
    boolean create(SALSTDDSZN et) ;
    void createBatch(List<SALSTDDSZN> list) ;
    SALSTDDSZN getDraft(SALSTDDSZN et) ;
    boolean checkKey(SALSTDDSZN et) ;
    Page<SALSTDDSZN> searchDefault(SALSTDDSZNSearchContext context) ;
    List<SALSTDDSZN> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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


