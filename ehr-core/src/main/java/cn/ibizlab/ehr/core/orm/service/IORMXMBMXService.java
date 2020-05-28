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

import cn.ibizlab.ehr.core.orm.domain.ORMXMBMX;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMBMX] 服务对象接口
 */
public interface IORMXMBMXService extends IService<ORMXMBMX>{

    boolean save(ORMXMBMX et) ;
    void saveBatch(List<ORMXMBMX> list) ;
    ORMXMBMX getDraft(ORMXMBMX et) ;
    boolean update(ORMXMBMX et) ;
    void updateBatch(List<ORMXMBMX> list) ;
    ORMXMBMX get(String key) ;
    boolean checkKey(ORMXMBMX et) ;
    boolean create(ORMXMBMX et) ;
    void createBatch(List<ORMXMBMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ORMXMBMX> searchDefault(ORMXMBMXSearchContext context) ;
    List<ORMXMBMX> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<ORMXMBMX> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<ORMXMBMX> getOrmxmbmxByIds(List<String> ids) ;
    List<ORMXMBMX> getOrmxmbmxByEntities(List<ORMXMBMX> entities) ;

}


