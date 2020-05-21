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

import cn.ibizlab.ehr.core.common.domain.UserDGTheme;
import cn.ibizlab.ehr.core.common.filter.UserDGThemeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserDGTheme] 服务对象接口
 */
public interface IUserDGThemeService extends IService<UserDGTheme>{

    UserDGTheme getDraft(UserDGTheme et) ;
    UserDGTheme get(String key) ;
    boolean checkKey(UserDGTheme et) ;
    boolean save(UserDGTheme et) ;
    void saveBatch(List<UserDGTheme> list) ;
    boolean create(UserDGTheme et) ;
    void createBatch(List<UserDGTheme> list) ;
    boolean update(UserDGTheme et) ;
    void updateBatch(List<UserDGTheme> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<UserDGTheme> searchDefault(UserDGThemeSearchContext context) ;
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


