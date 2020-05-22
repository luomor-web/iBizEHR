package cn.ibizlab.ehr.core.orm.service;

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

import cn.ibizlab.ehr.core.orm.domain.ORMRANK;
import cn.ibizlab.ehr.core.orm.filter.ORMRANKSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMRANK] 服务对象接口
 */
public interface IORMRANKService extends IService<ORMRANK>{

    boolean update(ORMRANK et) ;
    void updateBatch(List<ORMRANK> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ORMRANK et) ;
    void saveBatch(List<ORMRANK> list) ;
    ORMRANK get(String key) ;
    boolean checkKey(ORMRANK et) ;
    ORMRANK getDraft(ORMRANK et) ;
    boolean create(ORMRANK et) ;
    void createBatch(List<ORMRANK> list) ;
    Page<ORMRANK> searchJZRANK(ORMRANKSearchContext context) ;
    Page<ORMRANK> searchJSRANK(ORMRANKSearchContext context) ;
    Page<ORMRANK> searchDJYX(ORMRANKSearchContext context) ;
    Page<ORMRANK> searchJSNRANK(ORMRANKSearchContext context) ;
    Page<ORMRANK> searchDefault(ORMRANKSearchContext context) ;
    Page<ORMRANK> searchCurRank(ORMRANKSearchContext context) ;
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


