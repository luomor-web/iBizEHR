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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINCOURSESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINCOURSE] 服务对象接口
 */
public interface ITRMTRAINCOURSEService extends IService<TRMTRAINCOURSE>{

    TRMTRAINCOURSE get(String key) ;
    boolean checkKey(TRMTRAINCOURSE et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMTRAINCOURSE getDraft(TRMTRAINCOURSE et) ;
    boolean create(TRMTRAINCOURSE et) ;
    void createBatch(List<TRMTRAINCOURSE> list) ;
    boolean update(TRMTRAINCOURSE et) ;
    void updateBatch(List<TRMTRAINCOURSE> list) ;
    boolean save(TRMTRAINCOURSE et) ;
    void saveBatch(List<TRMTRAINCOURSE> list) ;
    Page<TRMTRAINCOURSE> searchDefault(TRMTRAINCOURSESearchContext context) ;
    List<TRMTRAINCOURSE> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMTRAINCOURSE> selectByTrmcoursesystemid(String trmcoursesystemid) ;
    void removeByTrmcoursesystemid(String trmcoursesystemid) ;
    List<TRMTRAINCOURSE> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TRMTRAINCOURSE> getTrmtraincourseByIds(List<String> ids) ;
    List<TRMTRAINCOURSE> getTrmtraincourseByEntities(List<TRMTRAINCOURSE> entities) ;

}


