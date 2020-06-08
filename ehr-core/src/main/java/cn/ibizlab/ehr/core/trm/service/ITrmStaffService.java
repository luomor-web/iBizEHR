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

import cn.ibizlab.ehr.core.trm.domain.TrmStaff;
import cn.ibizlab.ehr.core.trm.filter.TrmStaffSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmStaff] 服务对象接口
 */
public interface ITrmStaffService extends IService<TrmStaff>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TrmStaff et) ;
    boolean update(TrmStaff et) ;
    void updateBatch(List<TrmStaff> list) ;
    boolean create(TrmStaff et) ;
    void createBatch(List<TrmStaff> list) ;
    TrmStaff getDraft(TrmStaff et) ;
    TrmStaff get(String key) ;
    boolean save(TrmStaff et) ;
    void saveBatch(List<TrmStaff> list) ;
    Page<TrmStaff> searchDefault(TrmStaffSearchContext context) ;
    List<TrmStaff> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmStaff> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TrmStaff> selectByPimpersonid2(String pimpersonid) ;
    void removeByPimpersonid2(String pimpersonid) ;
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

    List<TrmStaff> getTrmstaffByIds(List<String> ids) ;
    List<TrmStaff> getTrmstaffByEntities(List<TrmStaff> entities) ;

}


