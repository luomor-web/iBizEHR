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

import cn.ibizlab.ehr.core.orm.domain.ORMDepEstMan;
import cn.ibizlab.ehr.core.orm.filter.ORMDepEstManSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMDepEstMan] 服务对象接口
 */
public interface IORMDepEstManService extends IService<ORMDepEstMan>{

    ORMDepEstMan getDraft(ORMDepEstMan et) ;
    boolean checkKey(ORMDepEstMan et) ;
    boolean create(ORMDepEstMan et) ;
    void createBatch(List<ORMDepEstMan> list) ;
    ORMDepEstMan get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ORMDepEstMan et) ;
    void updateBatch(List<ORMDepEstMan> list) ;
    boolean save(ORMDepEstMan et) ;
    void saveBatch(List<ORMDepEstMan> list) ;
    Page<ORMDepEstMan> searchDefault(ORMDepEstManSearchContext context) ;
    List<ORMDepEstMan> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<ORMDepEstMan> selectByOrmzwbzid(String orgsectorid) ;
    void removeByOrmzwbzid(String orgsectorid) ;
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


