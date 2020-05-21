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

import cn.ibizlab.ehr.core.common.domain.UserDictCat;
import cn.ibizlab.ehr.core.common.filter.UserDictCatSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserDictCat] 服务对象接口
 */
public interface IUserDictCatService extends IService<UserDictCat>{

    boolean save(UserDictCat et) ;
    void saveBatch(List<UserDictCat> list) ;
    UserDictCat get(String key) ;
    boolean checkKey(UserDictCat et) ;
    boolean update(UserDictCat et) ;
    void updateBatch(List<UserDictCat> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    UserDictCat getDraft(UserDictCat et) ;
    boolean create(UserDictCat et) ;
    void createBatch(List<UserDictCat> list) ;
    Page<UserDictCat> searchDefault(UserDictCatSearchContext context) ;
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


