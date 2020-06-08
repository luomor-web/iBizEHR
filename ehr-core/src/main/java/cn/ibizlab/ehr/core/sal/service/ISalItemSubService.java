package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SalItemSub;
import cn.ibizlab.ehr.core.sal.filter.SalItemSubSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalItemSub] 服务对象接口
 */
public interface ISalItemSubService extends IService<SalItemSub>{

    SalItemSub get(String key) ;
    boolean update(SalItemSub et) ;
    void updateBatch(List<SalItemSub> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SalItemSub et) ;
    boolean save(SalItemSub et) ;
    void saveBatch(List<SalItemSub> list) ;
    SalItemSub getDraft(SalItemSub et) ;
    boolean create(SalItemSub et) ;
    void createBatch(List<SalItemSub> list) ;
    Page<SalItemSub> searchDefault(SalItemSubSearchContext context) ;
    List<SalItemSub> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SalItemSub> selectBySalitemid(String salitemid) ;
    void removeBySalitemid(String salitemid) ;
    List<SalItemSub> selectBySalsubjectid(String salsubjectid) ;
    void removeBySalsubjectid(String salsubjectid) ;
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

    List<SalItemSub> getSalitemsubByIds(List<String> ids) ;
    List<SalItemSub> getSalitemsubByEntities(List<SalItemSub> entities) ;

}


