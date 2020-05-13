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

import cn.ibizlab.ehr.core.common.domain.UserGroup;
import cn.ibizlab.ehr.core.common.filter.UserGroupSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserGroup] 服务对象接口
 */
public interface IUserGroupService extends IService<UserGroup>{

    boolean update(UserGroup et) ;
    void updateBatch(List<UserGroup> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(UserGroup et) ;
    boolean create(UserGroup et) ;
    void createBatch(List<UserGroup> list) ;
    boolean save(UserGroup et) ;
    void saveBatch(List<UserGroup> list) ;
    UserGroup get(String key) ;
    UserGroup getDraft(UserGroup et) ;
    Page<UserGroup> searchDefault(UserGroupSearchContext context) ;
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

