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

import cn.ibizlab.ehr.core.common.domain.UserRoleDEField;
import cn.ibizlab.ehr.core.common.filter.UserRoleDEFieldSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRoleDEField] 服务对象接口
 */
public interface IUserRoleDEFieldService extends IService<UserRoleDEField>{

    boolean checkKey(UserRoleDEField et) ;
    boolean update(UserRoleDEField et) ;
    void updateBatch(List<UserRoleDEField> list) ;
    boolean create(UserRoleDEField et) ;
    void createBatch(List<UserRoleDEField> list) ;
    boolean save(UserRoleDEField et) ;
    void saveBatch(List<UserRoleDEField> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    UserRoleDEField get(String key) ;
    UserRoleDEField getDraft(UserRoleDEField et) ;
    Page<UserRoleDEField> searchDefault(UserRoleDEFieldSearchContext context) ;
    List<UserRoleDEField> selectByDeid(String deid) ;
    void removeByDeid(String deid) ;
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


