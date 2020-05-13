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

import cn.ibizlab.ehr.core.orm.domain.ORMPOST;
import cn.ibizlab.ehr.core.orm.filter.ORMPOSTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMPOST] 服务对象接口
 */
public interface IORMPOSTService extends IService<ORMPOST>{

    boolean save(ORMPOST et) ;
    void saveBatch(List<ORMPOST> list) ;
    boolean checkKey(ORMPOST et) ;
    boolean create(ORMPOST et) ;
    void createBatch(List<ORMPOST> list) ;
    ORMPOST get(String key) ;
    ORMPOST setGwJb(ORMPOST et) ;
    boolean update(ORMPOST et) ;
    void updateBatch(List<ORMPOST> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMPOST getDraft(ORMPOST et) ;
    Page<ORMPOST> searchEJZZGW(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchAuthPost(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchCurOrg(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchDQGW(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchDQORGGW(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchGWXH(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchDefault(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchJZBGWCX(ORMPOSTSearchContext context) ;
    Page<ORMPOST> searchCXGW(ORMPOSTSearchContext context) ;
    List<ORMPOST> selectByOrmorgid(String orgid) ;
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


