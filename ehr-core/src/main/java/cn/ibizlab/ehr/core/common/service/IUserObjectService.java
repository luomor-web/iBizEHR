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

import cn.ibizlab.ehr.core.common.domain.UserObject;
import cn.ibizlab.ehr.core.common.filter.UserObjectSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserObject] 服务对象接口
 */
public interface IUserObjectService extends IService<UserObject>{

    boolean update(UserObject et) ;
    void updateBatch(List<UserObject> list) ;
    UserObject getDraft(UserObject et) ;
    UserObject get(String key) ;
    boolean save(UserObject et) ;
    void saveBatch(List<UserObject> list) ;
    boolean create(UserObject et) ;
    void createBatch(List<UserObject> list) ;
    boolean checkKey(UserObject et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<UserObject> searchIndexDER(UserObjectSearchContext context) ;
    Page<UserObject> searchDefault(UserObjectSearchContext context) ;
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


