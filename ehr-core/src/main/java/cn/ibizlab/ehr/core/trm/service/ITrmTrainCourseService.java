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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainCourseSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainCourse] 服务对象接口
 */
public interface ITrmTrainCourseService extends IService<TrmTrainCourse>{

    TrmTrainCourse get(String key) ;
    boolean checkKey(TrmTrainCourse et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmTrainCourse getDraft(TrmTrainCourse et) ;
    boolean create(TrmTrainCourse et) ;
    void createBatch(List<TrmTrainCourse> list) ;
    boolean update(TrmTrainCourse et) ;
    void updateBatch(List<TrmTrainCourse> list) ;
    boolean save(TrmTrainCourse et) ;
    void saveBatch(List<TrmTrainCourse> list) ;
    Page<TrmTrainCourse> searchDefault(TrmTrainCourseSearchContext context) ;
    List<TrmTrainCourse> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainCourse> selectByTrmcoursesystemid(String trmcoursesystemid) ;
    void removeByTrmcoursesystemid(String trmcoursesystemid) ;
    List<TrmTrainCourse> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmTrainCourse> getTrmtraincourseByIds(List<String> ids) ;
    List<TrmTrainCourse> getTrmtraincourseByEntities(List<TrmTrainCourse> entities) ;

}


