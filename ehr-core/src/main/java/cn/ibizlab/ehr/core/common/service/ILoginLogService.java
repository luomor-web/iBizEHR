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

import cn.ibizlab.ehr.core.common.domain.LoginLog;
import cn.ibizlab.ehr.core.common.filter.LoginLogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[LoginLog] 服务对象接口
 */
public interface ILoginLogService extends IService<LoginLog>{

    boolean create(LoginLog et) ;
    void createBatch(List<LoginLog> list) ;
    boolean save(LoginLog et) ;
    void saveBatch(List<LoginLog> list) ;
    boolean checkKey(LoginLog et) ;
    LoginLog getDraft(LoginLog et) ;
    LoginLog get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(LoginLog et) ;
    void updateBatch(List<LoginLog> list) ;
    Page<LoginLog> searchDefault(LoginLogSearchContext context) ;
    List<LoginLog> selectByLoginaccountid(String loginaccountid) ;
    void removeByLoginaccountid(String loginaccountid) ;
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


