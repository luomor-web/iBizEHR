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

import cn.ibizlab.ehr.core.common.domain.UserRoleDataAction;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataActionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRoleDataAction] 服务对象接口
 */
public interface IUserRoleDataActionService extends IService<UserRoleDataAction>{

    boolean checkKey(UserRoleDataAction et) ;
    UserRoleDataAction getDraft(UserRoleDataAction et) ;
    UserRoleDataAction get(String key) ;
    boolean update(UserRoleDataAction et) ;
    void updateBatch(List<UserRoleDataAction> list) ;
    boolean create(UserRoleDataAction et) ;
    void createBatch(List<UserRoleDataAction> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(UserRoleDataAction et) ;
    void saveBatch(List<UserRoleDataAction> list) ;
    Page<UserRoleDataAction> searchDefault(UserRoleDataActionSearchContext context) ;
    List<UserRoleDataAction> selectByUserroledataid(String userroledataid) ;
    void removeByUserroledataid(String userroledataid) ;
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


