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

import cn.ibizlab.ehr.core.common.domain.UserRoleDatas;
import cn.ibizlab.ehr.core.common.filter.UserRoleDatasSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserRoleDatas] 服务对象接口
 */
public interface IUserRoleDatasService extends IService<UserRoleDatas>{

    UserRoleDatas get(String key) ;
    boolean create(UserRoleDatas et) ;
    void createBatch(List<UserRoleDatas> list) ;
    boolean update(UserRoleDatas et) ;
    void updateBatch(List<UserRoleDatas> list) ;
    boolean save(UserRoleDatas et) ;
    void saveBatch(List<UserRoleDatas> list) ;
    boolean checkKey(UserRoleDatas et) ;
    UserRoleDatas getDraft(UserRoleDatas et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<UserRoleDatas> searchDefault(UserRoleDatasSearchContext context) ;
    List<UserRoleDatas> selectByUserroledataid(String userroledataid) ;
    void removeByUserroledataid(String userroledataid) ;
    List<UserRoleDatas> selectByUserroleid(String userroleid) ;
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


