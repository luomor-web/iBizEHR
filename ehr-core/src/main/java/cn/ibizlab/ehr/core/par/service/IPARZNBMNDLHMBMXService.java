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

import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARZNBMNDLHMBMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARZNBMNDLHMBMX] 服务对象接口
 */
public interface IPARZNBMNDLHMBMXService extends IService<PARZNBMNDLHMBMX>{

    boolean create(PARZNBMNDLHMBMX et) ;
    void createBatch(List<PARZNBMNDLHMBMX> list) ;
    boolean update(PARZNBMNDLHMBMX et) ;
    void updateBatch(List<PARZNBMNDLHMBMX> list) ;
    PARZNBMNDLHMBMX getDraft(PARZNBMNDLHMBMX et) ;
    PARZNBMNDLHMBMX get(String key) ;
    boolean checkKey(PARZNBMNDLHMBMX et) ;
    boolean save(PARZNBMNDLHMBMX et) ;
    void saveBatch(List<PARZNBMNDLHMBMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PARZNBMNDLHMBMX> searchDefault(PARZNBMNDLHMBMXSearchContext context) ;
    List<PARZNBMNDLHMBMX> selectByParznbmndlhmbid(String parznbmndlhmbid) ;
    void removeByParznbmndlhmbid(String parznbmndlhmbid) ;
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


