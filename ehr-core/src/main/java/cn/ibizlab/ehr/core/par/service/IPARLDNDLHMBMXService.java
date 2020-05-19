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

import cn.ibizlab.ehr.core.par.domain.PARLDNDLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARLDNDLHMBMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARLDNDLHMBMX] 服务对象接口
 */
public interface IPARLDNDLHMBMXService extends IService<PARLDNDLHMBMX>{

    PARLDNDLHMBMX get(String key) ;
    PARLDNDLHMBMX getDraft(PARLDNDLHMBMX et) ;
    boolean create(PARLDNDLHMBMX et) ;
    void createBatch(List<PARLDNDLHMBMX> list) ;
    boolean save(PARLDNDLHMBMX et) ;
    void saveBatch(List<PARLDNDLHMBMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PARLDNDLHMBMX et) ;
    boolean update(PARLDNDLHMBMX et) ;
    void updateBatch(List<PARLDNDLHMBMX> list) ;
    Page<PARLDNDLHMBMX> searchDefault(PARLDNDLHMBMXSearchContext context) ;
    List<PARLDNDLHMBMX> selectByParldndlhmbid(String parldndlhmbid) ;
    void removeByParldndlhmbid(String parldndlhmbid) ;
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


