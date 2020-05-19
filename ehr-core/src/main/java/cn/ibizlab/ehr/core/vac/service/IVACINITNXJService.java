package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACINITNXJ;
import cn.ibizlab.ehr.core.vac.filter.VACINITNXJSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACINITNXJ] 服务对象接口
 */
public interface IVACINITNXJService extends IService<VACINITNXJ>{

    boolean checkKey(VACINITNXJ et) ;
    boolean create(VACINITNXJ et) ;
    void createBatch(List<VACINITNXJ> list) ;
    VACINITNXJ getDraft(VACINITNXJ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    VACINITNXJ get(String key) ;
    boolean save(VACINITNXJ et) ;
    void saveBatch(List<VACINITNXJ> list) ;
    boolean update(VACINITNXJ et) ;
    void updateBatch(List<VACINITNXJ> list) ;
    Page<VACINITNXJ> searchDefault(VACINITNXJSearchContext context) ;
    List<VACINITNXJ> selectByOrmorgid(String orgid) ;
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

}


