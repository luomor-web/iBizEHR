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

import cn.ibizlab.ehr.core.sal.domain.SalItem;
import cn.ibizlab.ehr.core.sal.filter.SalItemSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalItem] 服务对象接口
 */
public interface ISalItemService extends IService<SalItem>{

    SalItem get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SalItem et) ;
    void saveBatch(List<SalItem> list) ;
    SalItem getDraft(SalItem et) ;
    boolean checkKey(SalItem et) ;
    boolean update(SalItem et) ;
    void updateBatch(List<SalItem> list) ;
    boolean create(SalItem et) ;
    void createBatch(List<SalItem> list) ;
    Page<SalItem> searchDefault(SalItemSearchContext context) ;
    List<SalItem> selectBySalsubjectid(String salsubjectid) ;
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

    List<SalItem> getSalitemByIds(List<String> ids) ;
    List<SalItem> getSalitemByEntities(List<SalItem> entities) ;

}


