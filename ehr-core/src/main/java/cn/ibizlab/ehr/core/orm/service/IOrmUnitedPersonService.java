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

import cn.ibizlab.ehr.core.orm.domain.OrmUnitedPerson;
import cn.ibizlab.ehr.core.orm.filter.OrmUnitedPersonSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmUnitedPerson] 服务对象接口
 */
public interface IOrmUnitedPersonService extends IService<OrmUnitedPerson>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(OrmUnitedPerson et) ;
    void saveBatch(List<OrmUnitedPerson> list) ;
    OrmUnitedPerson getUnitedUser(OrmUnitedPerson et) ;
    OrmUnitedPerson getDraft(OrmUnitedPerson et) ;
    boolean create(OrmUnitedPerson et) ;
    void createBatch(List<OrmUnitedPerson> list) ;
    boolean checkKey(OrmUnitedPerson et) ;
    OrmUnitedPerson get(String key) ;
    boolean update(OrmUnitedPerson et) ;
    void updateBatch(List<OrmUnitedPerson> list) ;
    Page<OrmUnitedPerson> searchDefault(OrmUnitedPersonSearchContext context) ;
    Page<OrmUnitedPerson> searchCXYH(OrmUnitedPersonSearchContext context) ;
    Page<OrmUnitedPerson> searchCurFQXJYH(OrmUnitedPersonSearchContext context) ;
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

    List<OrmUnitedPerson> getOrmunitedpersonByIds(List<String> ids) ;
    List<OrmUnitedPerson> getOrmunitedpersonByEntities(List<OrmUnitedPerson> entities) ;

}


