package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEM;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVESYSTEMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACLEAVESYSTEM] 服务对象接口
 */
public interface IVACLEAVESYSTEMService extends IService<VACLEAVESYSTEM>{

    VACLEAVESYSTEM get(String key) ;
    boolean create(VACLEAVESYSTEM et) ;
    void createBatch(List<VACLEAVESYSTEM> list) ;
    VACLEAVESYSTEM getDraft(VACLEAVESYSTEM et) ;
    boolean update(VACLEAVESYSTEM et) ;
    void updateBatch(List<VACLEAVESYSTEM> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(VACLEAVESYSTEM et) ;
    void saveBatch(List<VACLEAVESYSTEM> list) ;
    boolean checkKey(VACLEAVESYSTEM et) ;
    Page<VACLEAVESYSTEM> searchDefault(VACLEAVESYSTEMSearchContext context) ;
    List<VACLEAVESYSTEM> selectByOrmorgid(String orgid) ;
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

}


