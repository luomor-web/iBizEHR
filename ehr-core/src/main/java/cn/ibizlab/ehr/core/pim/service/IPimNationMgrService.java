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

import cn.ibizlab.ehr.core.pim.domain.PimNationMgr;
import cn.ibizlab.ehr.core.pim.filter.PimNationMgrSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimNationMgr] 服务对象接口
 */
public interface IPimNationMgrService extends IService<PimNationMgr>{

    boolean save(PimNationMgr et) ;
    void saveBatch(List<PimNationMgr> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimNationMgr getDraft(PimNationMgr et) ;
    boolean checkKey(PimNationMgr et) ;
    boolean create(PimNationMgr et) ;
    void createBatch(List<PimNationMgr> list) ;
    PimNationMgr get(String key) ;
    boolean update(PimNationMgr et) ;
    void updateBatch(List<PimNationMgr> list) ;
    Page<PimNationMgr> searchDefault(PimNationMgrSearchContext context) ;
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

    List<PimNationMgr> getPimnationmgrByIds(List<String> ids) ;
    List<PimNationMgr> getPimnationmgrByEntities(List<PimNationMgr> entities) ;

}


