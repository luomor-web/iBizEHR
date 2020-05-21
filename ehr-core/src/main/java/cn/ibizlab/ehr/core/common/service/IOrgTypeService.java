package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.OrgType;
import cn.ibizlab.ehr.core.common.filter.OrgTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrgType] 服务对象接口
 */
public interface IOrgTypeService extends IService<OrgType>{

    boolean save(OrgType et) ;
    void saveBatch(List<OrgType> list) ;
    OrgType getDraft(OrgType et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrgType get(String key) ;
    boolean update(OrgType et) ;
    void updateBatch(List<OrgType> list) ;
    boolean create(OrgType et) ;
    void createBatch(List<OrgType> list) ;
    boolean checkKey(OrgType et) ;
    Page<OrgType> searchDefault(OrgTypeSearchContext context) ;
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


