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

import cn.ibizlab.ehr.core.common.domain.UserRoleDetail;
import cn.ibizlab.ehr.core.common.filter.UserRoleDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRoleDetail] 服务对象接口
 */
public interface IUserRoleDetailService extends IService<UserRoleDetail>{

    boolean update(UserRoleDetail et) ;
    void updateBatch(List<UserRoleDetail> list) ;
    boolean checkKey(UserRoleDetail et) ;
    boolean create(UserRoleDetail et) ;
    void createBatch(List<UserRoleDetail> list) ;
    boolean save(UserRoleDetail et) ;
    void saveBatch(List<UserRoleDetail> list) ;
    UserRoleDetail getDraft(UserRoleDetail et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    UserRoleDetail get(String key) ;
    Page<UserRoleDetail> searchCurrentCompany(UserRoleDetailSearchContext context) ;
    Page<UserRoleDetail> searchOrderByUserCX(UserRoleDetailSearchContext context) ;
    Page<UserRoleDetail> searchDefault(UserRoleDetailSearchContext context) ;
    Page<UserRoleDetail> searchSysManager(UserRoleDetailSearchContext context) ;
    List<UserRoleDetail> selectByUserobjectid(String userobjectid) ;
    void removeByUserobjectid(String userobjectid) ;
    List<UserRoleDetail> selectByUserroleid(String userroleid) ;
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


