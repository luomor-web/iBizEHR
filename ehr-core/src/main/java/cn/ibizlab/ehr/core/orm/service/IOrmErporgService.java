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

import cn.ibizlab.ehr.core.orm.domain.OrmErporg;
import cn.ibizlab.ehr.core.orm.filter.OrmErporgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmErporg] 服务对象接口
 */
public interface IOrmErporgService extends IService<OrmErporg>{

    OrmErporg get(String key) ;
    boolean update(OrmErporg et) ;
    void updateBatch(List<OrmErporg> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmErporg synOrg(OrmErporg et) ;
    OrmErporg getDraft(OrmErporg et) ;
    boolean save(OrmErporg et) ;
    void saveBatch(List<OrmErporg> list) ;
    boolean create(OrmErporg et) ;
    void createBatch(List<OrmErporg> list) ;
    boolean checkKey(OrmErporg et) ;
    Page<OrmErporg> searchCXBM(OrmErporgSearchContext context) ;
    Page<OrmErporg> searchLegalChoice(OrmErporgSearchContext context) ;
    Page<OrmErporg> searchDefault(OrmErporgSearchContext context) ;
    Page<OrmErporg> searchCX(OrmErporgSearchContext context) ;
    Page<OrmErporg> searchCXZBM(OrmErporgSearchContext context) ;
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

    List<OrmErporg> getOrmerporgByIds(List<String> ids) ;
    List<OrmErporg> getOrmerporgByEntities(List<OrmErporg> entities) ;

}


