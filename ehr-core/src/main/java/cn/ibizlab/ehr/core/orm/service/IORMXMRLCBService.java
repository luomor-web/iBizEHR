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

import cn.ibizlab.ehr.core.orm.domain.ORMXMRLCB;
import cn.ibizlab.ehr.core.orm.filter.ORMXMRLCBSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMRLCB] 服务对象接口
 */
public interface IORMXMRLCBService extends IService<ORMXMRLCB>{

    boolean create(ORMXMRLCB et) ;
    void createBatch(List<ORMXMRLCB> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ORMXMRLCB et) ;
    void updateBatch(List<ORMXMRLCB> list) ;
    boolean checkKey(ORMXMRLCB et) ;
    boolean save(ORMXMRLCB et) ;
    void saveBatch(List<ORMXMRLCB> list) ;
    ORMXMRLCB getDraft(ORMXMRLCB et) ;
    ORMXMRLCB get(String key) ;
    Page<ORMXMRLCB> searchCBCX(ORMXMRLCBSearchContext context) ;
    Page<ORMXMRLCB> searchDefault(ORMXMRLCBSearchContext context) ;
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


