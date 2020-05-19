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

import cn.ibizlab.ehr.core.par.domain.PARLDKHQZ;
import cn.ibizlab.ehr.core.par.filter.PARLDKHQZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARLDKHQZ] 服务对象接口
 */
public interface IPARLDKHQZService extends IService<PARLDKHQZ>{

    boolean checkKey(PARLDKHQZ et) ;
    boolean create(PARLDKHQZ et) ;
    void createBatch(List<PARLDKHQZ> list) ;
    PARLDKHQZ getDraft(PARLDKHQZ et) ;
    PARLDKHQZ get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARLDKHQZ et) ;
    void saveBatch(List<PARLDKHQZ> list) ;
    boolean update(PARLDKHQZ et) ;
    void updateBatch(List<PARLDKHQZ> list) ;
    Page<PARLDKHQZ> searchDefault(PARLDKHQZSearchContext context) ;
    List<PARLDKHQZ> selectByParkhzcmxid(String parkhzcmxid) ;
    void removeByParkhzcmxid(String parkhzcmxid) ;
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


