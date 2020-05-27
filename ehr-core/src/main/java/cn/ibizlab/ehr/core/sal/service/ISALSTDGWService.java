package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SALSTDGW;
import cn.ibizlab.ehr.core.sal.filter.SALSTDGWSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSTDGW] 服务对象接口
 */
public interface ISALSTDGWService extends IService<SALSTDGW>{

    boolean create(SALSTDGW et) ;
    void createBatch(List<SALSTDGW> list) ;
    boolean checkKey(SALSTDGW et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALSTDGW get(String key) ;
    SALSTDGW getDraft(SALSTDGW et) ;
    boolean save(SALSTDGW et) ;
    void saveBatch(List<SALSTDGW> list) ;
    boolean update(SALSTDGW et) ;
    void updateBatch(List<SALSTDGW> list) ;
    Page<SALSTDGW> searchDefault(SALSTDGWSearchContext context) ;
    List<SALSTDGW> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<SALSTDGW> getSalstdgwByIds(List<String> ids) ;
    List<SALSTDGW> getSalstdgwByEntities(List<SALSTDGW> entities) ;

}


