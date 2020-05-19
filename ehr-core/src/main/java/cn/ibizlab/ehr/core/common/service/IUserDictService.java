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

import cn.ibizlab.ehr.core.common.domain.UserDict;
import cn.ibizlab.ehr.core.common.filter.UserDictSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserDict] 服务对象接口
 */
public interface IUserDictService extends IService<UserDict>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(UserDict et) ;
    boolean create(UserDict et) ;
    void createBatch(List<UserDict> list) ;
    UserDict getDraft(UserDict et) ;
    UserDict reloadCurUser(UserDict et) ;
    UserDict get(String key) ;
    boolean save(UserDict et) ;
    void saveBatch(List<UserDict> list) ;
    boolean update(UserDict et) ;
    void updateBatch(List<UserDict> list) ;
    Page<UserDict> searchDefault(UserDictSearchContext context) ;
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


