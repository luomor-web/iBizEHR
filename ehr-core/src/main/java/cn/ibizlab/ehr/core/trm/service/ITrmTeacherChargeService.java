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

import cn.ibizlab.ehr.core.trm.domain.TrmTeacherCharge;
import cn.ibizlab.ehr.core.trm.filter.TrmTeacherChargeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmTeacherCharge] 服务对象接口
 */
public interface ITrmTeacherChargeService extends IService<TrmTeacherCharge>{

    boolean save(TrmTeacherCharge et) ;
    void saveBatch(List<TrmTeacherCharge> list) ;
    TrmTeacherCharge get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(TrmTeacherCharge et) ;
    void updateBatch(List<TrmTeacherCharge> list) ;
    boolean create(TrmTeacherCharge et) ;
    void createBatch(List<TrmTeacherCharge> list) ;
    TrmTeacherCharge getDraft(TrmTeacherCharge et) ;
    boolean checkKey(TrmTeacherCharge et) ;
    Page<TrmTeacherCharge> searchDefault(TrmTeacherChargeSearchContext context) ;
    List<TrmTeacherCharge> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
    List<TrmTeacherCharge> selectByTrmtrainteacherid(String trmtrainteacherid) ;
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

    List<TrmTeacherCharge> getTrmteacherchargeByIds(List<String> ids) ;
    List<TrmTeacherCharge> getTrmteacherchargeByEntities(List<TrmTeacherCharge> entities) ;

}


