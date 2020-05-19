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

import cn.ibizlab.ehr.core.orm.domain.UnitedPerson;
import cn.ibizlab.ehr.core.orm.filter.UnitedPersonSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UnitedPerson] 服务对象接口
 */
public interface IUnitedPersonService extends IService<UnitedPerson>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(UnitedPerson et) ;
    void saveBatch(List<UnitedPerson> list) ;
    UnitedPerson getUnitedUser(UnitedPerson et) ;
    UnitedPerson getDraft(UnitedPerson et) ;
    boolean create(UnitedPerson et) ;
    void createBatch(List<UnitedPerson> list) ;
    boolean checkKey(UnitedPerson et) ;
    UnitedPerson get(String key) ;
    boolean update(UnitedPerson et) ;
    void updateBatch(List<UnitedPerson> list) ;
    Page<UnitedPerson> searchDefault(UnitedPersonSearchContext context) ;
    Page<UnitedPerson> searchCXYH(UnitedPersonSearchContext context) ;
    Page<UnitedPerson> searchCurFQXJYH(UnitedPersonSearchContext context) ;
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


