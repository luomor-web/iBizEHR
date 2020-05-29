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

import cn.ibizlab.ehr.core.orm.domain.OrmRelation;
import cn.ibizlab.ehr.core.orm.filter.OrmRelationSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmRelation] 服务对象接口
 */
public interface IOrmRelationService extends IService<OrmRelation>{

    boolean create(OrmRelation et) ;
    void createBatch(List<OrmRelation> list) ;
    boolean update(OrmRelation et) ;
    void updateBatch(List<OrmRelation> list) ;
    OrmRelation get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmRelation getDraft(OrmRelation et) ;
    boolean checkKey(OrmRelation et) ;
    boolean save(OrmRelation et) ;
    void saveBatch(List<OrmRelation> list) ;
    Page<OrmRelation> searchDefault(OrmRelationSearchContext context) ;
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

    List<OrmRelation> getOrmrelationByIds(List<String> ids) ;
    List<OrmRelation> getOrmrelationByEntities(List<OrmRelation> entities) ;

}


