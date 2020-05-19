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

import cn.ibizlab.ehr.core.orm.domain.ORMUSER;
import cn.ibizlab.ehr.core.orm.filter.ORMUSERSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMUSER] 服务对象接口
 */
public interface IORMUSERService extends IService<ORMUSER>{

    ORMUSER get(String key) ;
    boolean create(ORMUSER et) ;
    void createBatch(List<ORMUSER> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ORMUSER et) ;
    void updateBatch(List<ORMUSER> list) ;
    boolean checkKey(ORMUSER et) ;
    boolean save(ORMUSER et) ;
    void saveBatch(List<ORMUSER> list) ;
    ORMUSER getDraft(ORMUSER et) ;
    Page<ORMUSER> searchDQZZJXJZZ(ORMUSERSearchContext context) ;
    Page<ORMUSER> searchDefault(ORMUSERSearchContext context) ;
    List<ORMUSER> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<ORMUSER> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
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


