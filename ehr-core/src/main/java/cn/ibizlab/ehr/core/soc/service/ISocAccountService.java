package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SocAccount;
import cn.ibizlab.ehr.core.soc.filter.SocAccountSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocAccount] 服务对象接口
 */
public interface ISocAccountService extends IService<SocAccount>{

    boolean checkKey(SocAccount et) ;
    boolean save(SocAccount et) ;
    void saveBatch(List<SocAccount> list) ;
    boolean update(SocAccount et) ;
    void updateBatch(List<SocAccount> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SocAccount get(String key) ;
    boolean create(SocAccount et) ;
    void createBatch(List<SocAccount> list) ;
    SocAccount getDraft(SocAccount et) ;
    Page<SocAccount> searchDefault(SocAccountSearchContext context) ;
    List<SocAccount> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<SocAccount> getSocaccountByIds(List<String> ids) ;
    List<SocAccount> getSocaccountByEntities(List<SocAccount> entities) ;

}


