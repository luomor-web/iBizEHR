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

import cn.ibizlab.ehr.core.trm.domain.TrmTrainPerson;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPersonSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTrainPerson] 服务对象接口
 */
public interface ITrmTrainPersonService extends IService<TrmTrainPerson>{

    TrmTrainPerson getDraft(TrmTrainPerson et) ;
    boolean save(TrmTrainPerson et) ;
    void saveBatch(List<TrmTrainPerson> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TrmTrainPerson et) ;
    boolean create(TrmTrainPerson et) ;
    void createBatch(List<TrmTrainPerson> list) ;
    TrmTrainPerson get(String key) ;
    boolean update(TrmTrainPerson et) ;
    void updateBatch(List<TrmTrainPerson> list) ;
    Page<TrmTrainPerson> searchDefault(TrmTrainPersonSearchContext context) ;
    List<TrmTrainPerson> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmTrainPerson> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
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

    List<TrmTrainPerson> getTrmtrainpersonByIds(List<String> ids) ;
    List<TrmTrainPerson> getTrmtrainpersonByEntities(List<TrmTrainPerson> entities) ;

}


