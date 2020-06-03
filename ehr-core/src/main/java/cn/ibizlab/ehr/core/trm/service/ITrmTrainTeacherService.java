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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainTeacherSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainTeacher] 服务对象接口
 */
public interface ITrmTrainTeacherService extends IService<TrmTrainTeacher>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(TrmTrainTeacher et) ;
    void updateBatch(List<TrmTrainTeacher> list) ;
    TrmTrainTeacher getDraft(TrmTrainTeacher et) ;
    TrmTrainTeacher get(String key) ;
    boolean checkKey(TrmTrainTeacher et) ;
    boolean save(TrmTrainTeacher et) ;
    void saveBatch(List<TrmTrainTeacher> list) ;
    boolean create(TrmTrainTeacher et) ;
    void createBatch(List<TrmTrainTeacher> list) ;
    Page<TrmTrainTeacher> searchNBJS(TrmTrainTeacherSearchContext context) ;
    Page<TrmTrainTeacher> searchWBJS(TrmTrainTeacherSearchContext context) ;
    Page<TrmTrainTeacher> searchDefault(TrmTrainTeacherSearchContext context) ;
    List<TrmTrainTeacher> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmTrainTeacher> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmTrainTeacher> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmTrainTeacher> getTrmtrainteacherByIds(List<String> ids) ;
    List<TrmTrainTeacher> getTrmtrainteacherByEntities(List<TrmTrainTeacher> entities) ;

}


