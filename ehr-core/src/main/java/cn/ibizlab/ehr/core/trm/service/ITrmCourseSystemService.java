package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem;
import cn.ibizlab.ehr.core.trm.filter.TrmCourseSystemSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmCourseSystem] 服务对象接口
 */
public interface ITrmCourseSystemService extends IService<TrmCourseSystem>{

    boolean update(TrmCourseSystem et) ;
    void updateBatch(List<TrmCourseSystem> list) ;
    boolean save(TrmCourseSystem et) ;
    void saveBatch(List<TrmCourseSystem> list) ;
    boolean checkKey(TrmCourseSystem et) ;
    TrmCourseSystem getDraft(TrmCourseSystem et) ;
    TrmCourseSystem get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(TrmCourseSystem et) ;
    void createBatch(List<TrmCourseSystem> list) ;
    Page<TrmCourseSystem> searchDefault(TrmCourseSystemSearchContext context) ;
    List<TrmCourseSystem> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmCourseSystem> getTrmcoursesystemByIds(List<String> ids) ;
    List<TrmCourseSystem> getTrmcoursesystemByEntities(List<TrmCourseSystem> entities) ;

}


