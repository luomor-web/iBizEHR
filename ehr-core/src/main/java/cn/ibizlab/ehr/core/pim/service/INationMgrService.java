package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.NationMgr;
import cn.ibizlab.ehr.core.pim.filter.NationMgrSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[NationMgr] 服务对象接口
 */
public interface INationMgrService extends IService<NationMgr>{

    boolean save(NationMgr et) ;
    void saveBatch(List<NationMgr> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    NationMgr getDraft(NationMgr et) ;
    boolean checkKey(NationMgr et) ;
    boolean create(NationMgr et) ;
    void createBatch(List<NationMgr> list) ;
    NationMgr get(String key) ;
    boolean update(NationMgr et) ;
    void updateBatch(List<NationMgr> list) ;
    Page<NationMgr> searchDefault(NationMgrSearchContext context) ;
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

    List<NationMgr> getNationmgrByIds(List<String> ids) ;
    List<NationMgr> getNationmgrByEntities(List<NationMgr> entities) ;

}


