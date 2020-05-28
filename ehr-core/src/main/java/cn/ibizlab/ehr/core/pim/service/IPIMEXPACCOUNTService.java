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

import cn.ibizlab.ehr.core.pim.domain.PIMEXPACCOUNT;
import cn.ibizlab.ehr.core.pim.filter.PIMEXPACCOUNTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMEXPACCOUNT] 服务对象接口
 */
public interface IPIMEXPACCOUNTService extends IService<PIMEXPACCOUNT>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMEXPACCOUNT get(String key) ;
    boolean save(PIMEXPACCOUNT et) ;
    void saveBatch(List<PIMEXPACCOUNT> list) ;
    boolean update(PIMEXPACCOUNT et) ;
    void updateBatch(List<PIMEXPACCOUNT> list) ;
    PIMEXPACCOUNT getDraft(PIMEXPACCOUNT et) ;
    boolean checkKey(PIMEXPACCOUNT et) ;
    boolean create(PIMEXPACCOUNT et) ;
    void createBatch(List<PIMEXPACCOUNT> list) ;
    Page<PIMEXPACCOUNT> searchDefault(PIMEXPACCOUNTSearchContext context) ;
    List<PIMEXPACCOUNT> selectByOrmorgid(String orgid) ;
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

    List<PIMEXPACCOUNT> getPimexpaccountByIds(List<String> ids) ;
    List<PIMEXPACCOUNT> getPimexpaccountByEntities(List<PIMEXPACCOUNT> entities) ;

}


