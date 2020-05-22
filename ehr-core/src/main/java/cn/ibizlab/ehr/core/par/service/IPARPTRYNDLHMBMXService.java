package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARPTRYNDLHMBMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARPTRYNDLHMBMX] 服务对象接口
 */
public interface IPARPTRYNDLHMBMXService extends IService<PARPTRYNDLHMBMX>{

    PARPTRYNDLHMBMX getDraft(PARPTRYNDLHMBMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PARPTRYNDLHMBMX et) ;
    PARPTRYNDLHMBMX get(String key) ;
    boolean save(PARPTRYNDLHMBMX et) ;
    void saveBatch(List<PARPTRYNDLHMBMX> list) ;
    boolean update(PARPTRYNDLHMBMX et) ;
    void updateBatch(List<PARPTRYNDLHMBMX> list) ;
    boolean create(PARPTRYNDLHMBMX et) ;
    void createBatch(List<PARPTRYNDLHMBMX> list) ;
    Page<PARPTRYNDLHMBMX> searchDefault(PARPTRYNDLHMBMXSearchContext context) ;
    List<PARPTRYNDLHMBMX> selectByParptryndlhmbid(String parptryndlhmbid) ;
    void removeByParptryndlhmbid(String parptryndlhmbid) ;
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


