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

import cn.ibizlab.ehr.core.common.domain.UserDictItem;
import cn.ibizlab.ehr.core.common.filter.UserDictItemSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UserDictItem] 服务对象接口
 */
public interface IUserDictItemService extends IService<UserDictItem>{

    boolean update(UserDictItem et) ;
    void updateBatch(List<UserDictItem> list) ;
    UserDictItem getDraft(UserDictItem et) ;
    boolean checkKey(UserDictItem et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    UserDictItem get(String key) ;
    boolean save(UserDictItem et) ;
    void saveBatch(List<UserDictItem> list) ;
    boolean create(UserDictItem et) ;
    void createBatch(List<UserDictItem> list) ;
    Page<UserDictItem> searchDefault(UserDictItemSearchContext context) ;
    List<UserDictItem> selectByUserdictcatid(String userdictcatid) ;
    void removeByUserdictcatid(String userdictcatid) ;
    List<UserDictItem> selectByUserdictid(String userdictid) ;
    void removeByUserdictid(String userdictid) ;
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


