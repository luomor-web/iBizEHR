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

import cn.ibizlab.ehr.core.orm.domain.ORMBMKQDZ;
import cn.ibizlab.ehr.core.orm.filter.ORMBMKQDZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMBMKQDZ] 服务对象接口
 */
public interface IORMBMKQDZService extends IService<ORMBMKQDZ>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMBMKQDZ getDraft(ORMBMKQDZ et) ;
    boolean checkKey(ORMBMKQDZ et) ;
    boolean save(ORMBMKQDZ et) ;
    void saveBatch(List<ORMBMKQDZ> list) ;
    boolean update(ORMBMKQDZ et) ;
    void updateBatch(List<ORMBMKQDZ> list) ;
    boolean create(ORMBMKQDZ et) ;
    void createBatch(List<ORMBMKQDZ> list) ;
    ORMBMKQDZ get(String key) ;
    Page<ORMBMKQDZ> searchDefault(ORMBMKQDZSearchContext context) ;
    List<ORMBMKQDZ> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<ORMBMKQDZ> getOrmbmkqdzByIds(List<String> ids) ;
    List<ORMBMKQDZ> getOrmbmkqdzByEntities(List<ORMBMKQDZ> entities) ;

}


