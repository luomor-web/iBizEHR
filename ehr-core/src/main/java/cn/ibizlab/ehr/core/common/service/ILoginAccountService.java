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

import cn.ibizlab.ehr.core.common.domain.LoginAccount;
import cn.ibizlab.ehr.core.common.filter.LoginAccountSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[LoginAccount] 服务对象接口
 */
public interface ILoginAccountService extends IService<LoginAccount>{

    boolean save(LoginAccount et) ;
    void saveBatch(List<LoginAccount> list) ;
    boolean checkKey(LoginAccount et) ;
    LoginAccount saveHashMode(LoginAccount et) ;
    boolean update(LoginAccount et) ;
    void updateBatch(List<LoginAccount> list) ;
    LoginAccount get(String key) ;
    LoginAccount getHashMode(LoginAccount et) ;
    boolean create(LoginAccount et) ;
    void createBatch(List<LoginAccount> list) ;
    LoginAccount getDraft(LoginAccount et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<LoginAccount> searchDefault(LoginAccountSearchContext context) ;
    List<LoginAccount> selectByUserid(String userid) ;
    void removeByUserid(String userid) ;
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


