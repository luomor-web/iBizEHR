package cn.ibizlab.ehr.core.att.service;

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

import cn.ibizlab.ehr.core.att.domain.AttEndenceType;
import cn.ibizlab.ehr.core.att.filter.AttEndenceTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndenceType] 服务对象接口
 */
public interface IAttEndenceTypeService extends IService<AttEndenceType>{

    boolean save(AttEndenceType et) ;
    void saveBatch(List<AttEndenceType> list) ;
    boolean create(AttEndenceType et) ;
    void createBatch(List<AttEndenceType> list) ;
    boolean checkKey(AttEndenceType et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    AttEndenceType get(String key) ;
    AttEndenceType getDraft(AttEndenceType et) ;
    boolean update(AttEndenceType et) ;
    void updateBatch(List<AttEndenceType> list) ;
    Page<AttEndenceType> searchDefault(AttEndenceTypeSearchContext context) ;
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

    List<AttEndenceType> getAttendencetypeByIds(List<String> ids) ;
    List<AttEndenceType> getAttendencetypeByEntities(List<AttEndenceType> entities) ;

}


