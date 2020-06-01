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

import cn.ibizlab.ehr.core.trm.domain.TrmTeacherTrain;
import cn.ibizlab.ehr.core.trm.filter.TrmTeacherTrainSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTeacherTrain] 服务对象接口
 */
public interface ITrmTeacherTrainService extends IService<TrmTeacherTrain>{

    boolean save(TrmTeacherTrain et) ;
    void saveBatch(List<TrmTeacherTrain> list) ;
    TrmTeacherTrain getDraft(TrmTeacherTrain et) ;
    boolean create(TrmTeacherTrain et) ;
    void createBatch(List<TrmTeacherTrain> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmTeacherTrain get(String key) ;
    boolean update(TrmTeacherTrain et) ;
    void updateBatch(List<TrmTeacherTrain> list) ;
    boolean checkKey(TrmTeacherTrain et) ;
    Page<TrmTeacherTrain> searchDefault(TrmTeacherTrainSearchContext context) ;
    List<TrmTeacherTrain> selectByTrmtrainaddressid(String trmtrainaddressid) ;
    void removeByTrmtrainaddressid(String trmtrainaddressid) ;
    List<TrmTeacherTrain> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TrmTeacherTrain> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
    List<TrmTeacherTrain> selectByTrmtrainteacherid(String trmtrainteacherid) ;
    void removeByTrmtrainteacherid(String trmtrainteacherid) ;
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

    List<TrmTeacherTrain> getTrmteachertrainByIds(List<String> ids) ;
    List<TrmTeacherTrain> getTrmteachertrainByEntities(List<TrmTeacherTrain> entities) ;

}


