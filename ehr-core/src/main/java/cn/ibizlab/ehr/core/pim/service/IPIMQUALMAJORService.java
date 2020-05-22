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

import cn.ibizlab.ehr.core.pim.domain.PIMQUALMAJOR;
import cn.ibizlab.ehr.core.pim.filter.PIMQUALMAJORSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMQUALMAJOR] 服务对象接口
 */
public interface IPIMQUALMAJORService extends IService<PIMQUALMAJOR>{

    boolean create(PIMQUALMAJOR et) ;
    void createBatch(List<PIMQUALMAJOR> list) ;
    boolean checkKey(PIMQUALMAJOR et) ;
    boolean update(PIMQUALMAJOR et) ;
    void updateBatch(List<PIMQUALMAJOR> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMQUALMAJOR getDraft(PIMQUALMAJOR et) ;
    boolean save(PIMQUALMAJOR et) ;
    void saveBatch(List<PIMQUALMAJOR> list) ;
    PIMQUALMAJOR get(String key) ;
    Page<PIMQUALMAJOR> searchDefault(PIMQUALMAJORSearchContext context) ;
    Page<PIMQUALMAJOR> searchXZZGZY(PIMQUALMAJORSearchContext context) ;
    List<PIMQUALMAJOR> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PIMQUALMAJOR> selectByPimqualtypeid(String pimqualtypeid) ;
    void removeByPimqualtypeid(String pimqualtypeid) ;
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


