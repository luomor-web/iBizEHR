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

import cn.ibizlab.ehr.core.pim.domain.PIMWORKHISTORY;
import cn.ibizlab.ehr.core.pim.filter.PIMWORKHISTORYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMWORKHISTORY] 服务对象接口
 */
public interface IPIMWORKHISTORYService extends IService<PIMWORKHISTORY>{

    PIMWORKHISTORY get(String key) ;
    boolean create(PIMWORKHISTORY et) ;
    void createBatch(List<PIMWORKHISTORY> list) ;
    boolean save(PIMWORKHISTORY et) ;
    void saveBatch(List<PIMWORKHISTORY> list) ;
    boolean update(PIMWORKHISTORY et) ;
    void updateBatch(List<PIMWORKHISTORY> list) ;
    boolean checkKey(PIMWORKHISTORY et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMWORKHISTORY getDraft(PIMWORKHISTORY et) ;
    Page<PIMWORKHISTORY> searchDefault(PIMWORKHISTORYSearchContext context) ;
    Page<PIMWORKHISTORY> searchIsMain(PIMWORKHISTORYSearchContext context) ;
    Page<PIMWORKHISTORY> searchJLSSGLY(PIMWORKHISTORYSearchContext context) ;
    Page<PIMWORKHISTORY> searchZIZHU(PIMWORKHISTORYSearchContext context) ;
    Page<PIMWORKHISTORY> searchJLSS(PIMWORKHISTORYSearchContext context) ;
    Page<PIMWORKHISTORY> searchFAZZSY(PIMWORKHISTORYSearchContext context) ;
    Page<PIMWORKHISTORY> searchJLSSGR(PIMWORKHISTORYSearchContext context) ;
    List<PIMWORKHISTORY> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
    List<PIMWORKHISTORY> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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


