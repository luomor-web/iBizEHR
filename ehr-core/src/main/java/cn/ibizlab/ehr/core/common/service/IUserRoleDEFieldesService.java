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

import cn.ibizlab.ehr.core.common.domain.UserRoleDEFieldes;
import cn.ibizlab.ehr.core.common.filter.UserRoleDEFieldesSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRoleDEFieldes] 服务对象接口
 */
public interface IUserRoleDEFieldesService extends IService<UserRoleDEFieldes>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(UserRoleDEFieldes et) ;
    void updateBatch(List<UserRoleDEFieldes> list) ;
    boolean checkKey(UserRoleDEFieldes et) ;
    boolean create(UserRoleDEFieldes et) ;
    void createBatch(List<UserRoleDEFieldes> list) ;
    UserRoleDEFieldes get(String key) ;
    boolean save(UserRoleDEFieldes et) ;
    void saveBatch(List<UserRoleDEFieldes> list) ;
    UserRoleDEFieldes getDraft(UserRoleDEFieldes et) ;
    Page<UserRoleDEFieldes> searchDefault(UserRoleDEFieldesSearchContext context) ;
    List<UserRoleDEFieldes> selectByUserroledefieldid(String userroledefieldid) ;
    void removeByUserroledefieldid(String userroledefieldid) ;
    List<UserRoleDEFieldes> selectByUserroleid(String userroleid) ;
    void removeByUserroleid(String userroleid) ;
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


