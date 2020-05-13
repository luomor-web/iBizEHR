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

import cn.ibizlab.ehr.core.par.domain.PARZNBMMX;
import cn.ibizlab.ehr.core.par.filter.PARZNBMMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARZNBMMX] 服务对象接口
 */
public interface IPARZNBMMXService extends IService<PARZNBMMX>{

    boolean checkKey(PARZNBMMX et) ;
    boolean update(PARZNBMMX et) ;
    void updateBatch(List<PARZNBMMX> list) ;
    PARZNBMMX getDraft(PARZNBMMX et) ;
    boolean create(PARZNBMMX et) ;
    void createBatch(List<PARZNBMMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARZNBMMX et) ;
    void saveBatch(List<PARZNBMMX> list) ;
    PARZNBMMX get(String key) ;
    Page<PARZNBMMX> searchDefault(PARZNBMMXSearchContext context) ;
    List<PARZNBMMX> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PARZNBMMX> selectByPartzggid(String partzggid) ;
    void removeByPartzggid(String partzggid) ;
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


