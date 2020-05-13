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

import cn.ibizlab.ehr.core.sal.domain.SALSTDZC;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZCSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSTDZC] 服务对象接口
 */
public interface ISALSTDZCService extends IService<SALSTDZC>{

    boolean create(SALSTDZC et) ;
    void createBatch(List<SALSTDZC> list) ;
    SALSTDZC get(String key) ;
    boolean save(SALSTDZC et) ;
    void saveBatch(List<SALSTDZC> list) ;
    SALSTDZC getDraft(SALSTDZC et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(SALSTDZC et) ;
    void updateBatch(List<SALSTDZC> list) ;
    boolean checkKey(SALSTDZC et) ;
    Page<SALSTDZC> searchDefault(SALSTDZCSearchContext context) ;
    List<SALSTDZC> selectByOrmorgid(String orgid) ;
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


