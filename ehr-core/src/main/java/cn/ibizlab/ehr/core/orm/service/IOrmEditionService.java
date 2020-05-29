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

import cn.ibizlab.ehr.core.orm.domain.OrmEdition;
import cn.ibizlab.ehr.core.orm.filter.OrmEditionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmEdition] 服务对象接口
 */
public interface IOrmEditionService extends IService<OrmEdition>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(OrmEdition et) ;
    void createBatch(List<OrmEdition> list) ;
    boolean save(OrmEdition et) ;
    void saveBatch(List<OrmEdition> list) ;
    OrmEdition getDraft(OrmEdition et) ;
    boolean update(OrmEdition et) ;
    void updateBatch(List<OrmEdition> list) ;
    boolean checkKey(OrmEdition et) ;
    OrmEdition get(String key) ;
    Page<OrmEdition> searchDefault(OrmEditionSearchContext context) ;
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

    List<OrmEdition> getOrmeditionByIds(List<String> ids) ;
    List<OrmEdition> getOrmeditionByEntities(List<OrmEdition> entities) ;

}


