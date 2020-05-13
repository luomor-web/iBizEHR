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

import cn.ibizlab.ehr.core.common.domain.UserRoleData;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRoleData] 服务对象接口
 */
public interface IUserRoleDataService extends IService<UserRoleData>{

    boolean checkKey(UserRoleData et) ;
    boolean create(UserRoleData et) ;
    void createBatch(List<UserRoleData> list) ;
    boolean update(UserRoleData et) ;
    void updateBatch(List<UserRoleData> list) ;
    UserRoleData get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(UserRoleData et) ;
    void saveBatch(List<UserRoleData> list) ;
    UserRoleData getDraft(UserRoleData et) ;
    Page<UserRoleData> searchDefault(UserRoleDataSearchContext context) ;
    List<UserRoleData> selectByDeid(String deid) ;
    void removeByDeid(String deid) ;
    List<UserRoleData> selectByDstorgsectorid(String orgsectorid) ;
    void removeByDstorgsectorid(String orgsectorid) ;
    List<UserRoleData> selectByDstorgid(String orgid) ;
    void removeByDstorgid(String orgid) ;
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


