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

import cn.ibizlab.ehr.core.pim.domain.PIMCONTRACTTYPE;
import cn.ibizlab.ehr.core.pim.filter.PIMCONTRACTTYPESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMCONTRACTTYPE] 服务对象接口
 */
public interface IPIMCONTRACTTYPEService extends IService<PIMCONTRACTTYPE>{

    boolean update(PIMCONTRACTTYPE et) ;
    void updateBatch(List<PIMCONTRACTTYPE> list) ;
    boolean save(PIMCONTRACTTYPE et) ;
    void saveBatch(List<PIMCONTRACTTYPE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PIMCONTRACTTYPE et) ;
    void createBatch(List<PIMCONTRACTTYPE> list) ;
    PIMCONTRACTTYPE get(String key) ;
    PIMCONTRACTTYPE getDraft(PIMCONTRACTTYPE et) ;
    boolean checkKey(PIMCONTRACTTYPE et) ;
    Page<PIMCONTRACTTYPE> searchDefault(PIMCONTRACTTYPESearchContext context) ;
    List<PIMCONTRACTTYPE> selectByOrmorgid(String orgid) ;
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

    List<PIMCONTRACTTYPE> getPimcontracttypeByIds(List<String> ids) ;
    List<PIMCONTRACTTYPE> getPimcontracttypeByEntities(List<PIMCONTRACTTYPE> entities) ;

}


