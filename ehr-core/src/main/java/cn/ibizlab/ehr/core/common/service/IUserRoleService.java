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

import cn.ibizlab.ehr.core.common.domain.UserRole;
import cn.ibizlab.ehr.core.common.filter.UserRoleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRole] 服务对象接口
 */
public interface IUserRoleService extends IService<UserRole>{

    boolean create(UserRole et) ;
    void createBatch(List<UserRole> list) ;
    boolean checkKey(UserRole et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(UserRole et) ;
    void updateBatch(List<UserRole> list) ;
    UserRole getDraft(UserRole et) ;
    boolean save(UserRole et) ;
    void saveBatch(List<UserRole> list) ;
    UserRole get(String key) ;
    Page<UserRole> searchLevelC(UserRoleSearchContext context) ;
    Page<UserRole> searchDefault(UserRoleSearchContext context) ;
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


