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

import cn.ibizlab.ehr.core.orm.domain.ORMRelation;
import cn.ibizlab.ehr.core.orm.filter.ORMRelationSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMRelation] 服务对象接口
 */
public interface IORMRelationService extends IService<ORMRelation>{

    boolean create(ORMRelation et) ;
    void createBatch(List<ORMRelation> list) ;
    boolean update(ORMRelation et) ;
    void updateBatch(List<ORMRelation> list) ;
    ORMRelation get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMRelation getDraft(ORMRelation et) ;
    boolean checkKey(ORMRelation et) ;
    boolean save(ORMRelation et) ;
    void saveBatch(List<ORMRelation> list) ;
    Page<ORMRelation> searchDefault(ORMRelationSearchContext context) ;
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

    List<ORMRelation> getOrmrelationByIds(List<String> ids) ;
    List<ORMRelation> getOrmrelationByEntities(List<ORMRelation> entities) ;

}


