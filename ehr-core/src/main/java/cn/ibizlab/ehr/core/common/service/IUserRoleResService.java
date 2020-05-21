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

import cn.ibizlab.ehr.core.common.domain.UserRoleRes;
import cn.ibizlab.ehr.core.common.filter.UserRoleResSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRoleRes] 服务对象接口
 */
public interface IUserRoleResService extends IService<UserRoleRes>{

    UserRoleRes getDraft(UserRoleRes et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(UserRoleRes et) ;
    UserRoleRes get(String key) ;
    boolean update(UserRoleRes et) ;
    void updateBatch(List<UserRoleRes> list) ;
    boolean save(UserRoleRes et) ;
    void saveBatch(List<UserRoleRes> list) ;
    boolean create(UserRoleRes et) ;
    void createBatch(List<UserRoleRes> list) ;
    Page<UserRoleRes> searchDefault(UserRoleResSearchContext context) ;
    List<UserRoleRes> selectByUniresid(String uniresid) ;
    void removeByUniresid(String uniresid) ;
    List<UserRoleRes> selectByUserroleid(String userroleid) ;
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


