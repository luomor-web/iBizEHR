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

import cn.ibizlab.ehr.core.orm.domain.OrmPost;
import cn.ibizlab.ehr.core.orm.filter.OrmPostSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmPost] 服务对象接口
 */
public interface IOrmPostService extends IService<OrmPost>{

    boolean save(OrmPost et) ;
    void saveBatch(List<OrmPost> list) ;
    boolean checkKey(OrmPost et) ;
    boolean create(OrmPost et) ;
    void createBatch(List<OrmPost> list) ;
    OrmPost get(String key) ;
    OrmPost setGwJb(OrmPost et) ;
    boolean update(OrmPost et) ;
    void updateBatch(List<OrmPost> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrmPost getDraft(OrmPost et) ;
    Page<OrmPost> searchEJZZGW(OrmPostSearchContext context) ;
    Page<OrmPost> searchAuthPost(OrmPostSearchContext context) ;
    Page<OrmPost> searchCurOrg(OrmPostSearchContext context) ;
    Page<OrmPost> searchDQGW(OrmPostSearchContext context) ;
    Page<OrmPost> searchDQORGGW(OrmPostSearchContext context) ;
    Page<OrmPost> searchGWXH(OrmPostSearchContext context) ;
    Page<OrmPost> searchDefault(OrmPostSearchContext context) ;
    Page<OrmPost> searchJZBGWCX(OrmPostSearchContext context) ;
    Page<OrmPost> searchCXGW(OrmPostSearchContext context) ;
    List<OrmPost> selectByOrmorgid(String orgid) ;
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

    List<OrmPost> getOrmpostByIds(List<String> ids) ;
    List<OrmPost> getOrmpostByEntities(List<OrmPost> entities) ;

}


