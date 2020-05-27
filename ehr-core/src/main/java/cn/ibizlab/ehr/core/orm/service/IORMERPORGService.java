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

import cn.ibizlab.ehr.core.orm.domain.ORMERPORG;
import cn.ibizlab.ehr.core.orm.filter.ORMERPORGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMERPORG] 服务对象接口
 */
public interface IORMERPORGService extends IService<ORMERPORG>{

    ORMERPORG get(String key) ;
    boolean update(ORMERPORG et) ;
    void updateBatch(List<ORMERPORG> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMERPORG synOrg(ORMERPORG et) ;
    ORMERPORG getDraft(ORMERPORG et) ;
    boolean save(ORMERPORG et) ;
    void saveBatch(List<ORMERPORG> list) ;
    boolean create(ORMERPORG et) ;
    void createBatch(List<ORMERPORG> list) ;
    boolean checkKey(ORMERPORG et) ;
    Page<ORMERPORG> searchCXBM(ORMERPORGSearchContext context) ;
    Page<ORMERPORG> searchLegalChoice(ORMERPORGSearchContext context) ;
    Page<ORMERPORG> searchDefault(ORMERPORGSearchContext context) ;
    Page<ORMERPORG> searchCX(ORMERPORGSearchContext context) ;
    Page<ORMERPORG> searchCXZBM(ORMERPORGSearchContext context) ;
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

    List<ORMERPORG> getOrmerporgByIds(List<String> ids) ;
    List<ORMERPORG> getOrmerporgByEntities(List<ORMERPORG> entities) ;

}


