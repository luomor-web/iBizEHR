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

import cn.ibizlab.ehr.core.orm.domain.ORMTITLE;
import cn.ibizlab.ehr.core.orm.filter.ORMTITLESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMTITLE] 服务对象接口
 */
public interface IORMTITLEService extends IService<ORMTITLE>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ORMTITLE et) ;
    void updateBatch(List<ORMTITLE> list) ;
    ORMTITLE getDraft(ORMTITLE et) ;
    boolean save(ORMTITLE et) ;
    void saveBatch(List<ORMTITLE> list) ;
    boolean checkKey(ORMTITLE et) ;
    ORMTITLE get(String key) ;
    boolean create(ORMTITLE et) ;
    void createBatch(List<ORMTITLE> list) ;
    Page<ORMTITLE> searchDefault(ORMTITLESearchContext context) ;
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

    List<ORMTITLE> getOrmtitleByIds(List<String> ids) ;
    List<ORMTITLE> getOrmtitleByEntities(List<ORMTITLE> entities) ;

}


