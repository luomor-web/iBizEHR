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

import cn.ibizlab.ehr.core.common.domain.Org;
import cn.ibizlab.ehr.core.common.filter.OrgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[Org] 服务对象接口
 */
public interface IOrgService extends IService<Org>{

    Org initAll(Org et) ;
    boolean checkKey(Org et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(Org et) ;
    void createBatch(List<Org> list) ;
    Org get(String key) ;
    Org getDraft(Org et) ;
    Org initUserObject(Org et) ;
    boolean save(Org et) ;
    void saveBatch(List<Org> list) ;
    boolean update(Org et) ;
    void updateBatch(List<Org> list) ;
    Page<Org> searchDefault(OrgSearchContext context) ;
    Page<Org> searchCurCat(OrgSearchContext context) ;
    Page<Org> searchAllRoot(OrgSearchContext context) ;
    Page<Org> searchCurChild(OrgSearchContext context) ;
    List<Org> selectByPorgid(String orgid) ;
    void removeByPorgid(String orgid) ;
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


