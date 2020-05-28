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

import cn.ibizlab.ehr.core.orm.domain.ORMBMGWBZ;
import cn.ibizlab.ehr.core.orm.filter.ORMBMGWBZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMBMGWBZ] 服务对象接口
 */
public interface IORMBMGWBZService extends IService<ORMBMGWBZ>{

    boolean create(ORMBMGWBZ et) ;
    void createBatch(List<ORMBMGWBZ> list) ;
    boolean checkKey(ORMBMGWBZ et) ;
    ORMBMGWBZ get(String key) ;
    boolean save(ORMBMGWBZ et) ;
    void saveBatch(List<ORMBMGWBZ> list) ;
    boolean update(ORMBMGWBZ et) ;
    void updateBatch(List<ORMBMGWBZ> list) ;
    ORMBMGWBZ getDraft(ORMBMGWBZ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ORMBMGWBZ> searchDefault(ORMBMGWBZSearchContext context) ;
    List<ORMBMGWBZ> selectByOrmgwbzid(String orgsectorid) ;
    void removeByOrmgwbzid(String orgsectorid) ;
    List<ORMBMGWBZ> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
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

    List<ORMBMGWBZ> getOrmbmgwbzByIds(List<String> ids) ;
    List<ORMBMGWBZ> getOrmbmgwbzByEntities(List<ORMBMGWBZ> entities) ;

}


