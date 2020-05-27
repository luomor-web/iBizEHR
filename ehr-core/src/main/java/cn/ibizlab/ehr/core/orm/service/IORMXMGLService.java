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

import cn.ibizlab.ehr.core.orm.domain.ORMXMGL;
import cn.ibizlab.ehr.core.orm.filter.ORMXMGLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMGL] 服务对象接口
 */
public interface IORMXMGLService extends IService<ORMXMGL>{

    ORMXMGL get(String key) ;
    boolean checkKey(ORMXMGL et) ;
    ORMXMGL getDraft(ORMXMGL et) ;
    boolean update(ORMXMGL et) ;
    void updateBatch(List<ORMXMGL> list) ;
    boolean create(ORMXMGL et) ;
    void createBatch(List<ORMXMGL> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMXMGL synchro(ORMXMGL et) ;
    boolean save(ORMXMGL et) ;
    void saveBatch(List<ORMXMGL> list) ;
    Page<ORMXMGL> searchDefault(ORMXMGLSearchContext context) ;
    Page<ORMXMGL> searchValidPro(ORMXMGLSearchContext context) ;
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

    List<ORMXMGL> getOrmxmglByIds(List<String> ids) ;
    List<ORMXMGL> getOrmxmglByEntities(List<ORMXMGL> entities) ;

}


