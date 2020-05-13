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

import cn.ibizlab.ehr.core.common.domain.UserGroupDetail;
import cn.ibizlab.ehr.core.common.filter.UserGroupDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserGroupDetail] 服务对象接口
 */
public interface IUserGroupDetailService extends IService<UserGroupDetail>{

    UserGroupDetail getDraft(UserGroupDetail et) ;
    boolean save(UserGroupDetail et) ;
    void saveBatch(List<UserGroupDetail> list) ;
    boolean update(UserGroupDetail et) ;
    void updateBatch(List<UserGroupDetail> list) ;
    UserGroupDetail get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(UserGroupDetail et) ;
    boolean create(UserGroupDetail et) ;
    void createBatch(List<UserGroupDetail> list) ;
    Page<UserGroupDetail> searchDefault(UserGroupDetailSearchContext context) ;
    List<UserGroupDetail> selectByUsergroupid(String usergroupid) ;
    void removeByUsergroupid(String usergroupid) ;
    List<UserGroupDetail> selectByUserobjectid(String userobjectid) ;
    void removeByUserobjectid(String userobjectid) ;
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

