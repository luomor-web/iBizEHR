package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PimExpaccount;
import cn.ibizlab.ehr.core.pim.filter.PimExpaccountSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimExpaccount] 服务对象接口
 */
public interface IPimExpaccountService extends IService<PimExpaccount>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimExpaccount get(String key) ;
    boolean save(PimExpaccount et) ;
    void saveBatch(List<PimExpaccount> list) ;
    boolean update(PimExpaccount et) ;
    void updateBatch(List<PimExpaccount> list) ;
    PimExpaccount getDraft(PimExpaccount et) ;
    boolean checkKey(PimExpaccount et) ;
    boolean create(PimExpaccount et) ;
    void createBatch(List<PimExpaccount> list) ;
    Page<PimExpaccount> searchDefault(PimExpaccountSearchContext context) ;
    List<PimExpaccount> selectByOrmorgid(String orgid) ;
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

    List<PimExpaccount> getPimexpaccountByIds(List<String> ids) ;
    List<PimExpaccount> getPimexpaccountByEntities(List<PimExpaccount> entities) ;

}


