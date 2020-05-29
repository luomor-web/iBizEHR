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

import cn.ibizlab.ehr.core.pim.domain.PersonStateMgr;
import cn.ibizlab.ehr.core.pim.filter.PersonStateMgrSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PersonStateMgr] 服务对象接口
 */
public interface IPersonStateMgrService extends IService<PersonStateMgr>{

    boolean save(PersonStateMgr et) ;
    void saveBatch(List<PersonStateMgr> list) ;
    boolean checkKey(PersonStateMgr et) ;
    PersonStateMgr getDraft(PersonStateMgr et) ;
    PersonStateMgr get(String key) ;
    boolean create(PersonStateMgr et) ;
    void createBatch(List<PersonStateMgr> list) ;
    boolean update(PersonStateMgr et) ;
    void updateBatch(List<PersonStateMgr> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PersonStateMgr> searchDefault(PersonStateMgrSearchContext context) ;
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

    List<PersonStateMgr> getPersonstatemgrByIds(List<String> ids) ;
    List<PersonStateMgr> getPersonstatemgrByEntities(List<PersonStateMgr> entities) ;

}


