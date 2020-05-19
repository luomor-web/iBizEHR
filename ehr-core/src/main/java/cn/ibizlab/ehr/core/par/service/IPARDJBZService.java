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

import cn.ibizlab.ehr.core.par.domain.PARDJBZ;
import cn.ibizlab.ehr.core.par.filter.PARDJBZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARDJBZ] 服务对象接口
 */
public interface IPARDJBZService extends IService<PARDJBZ>{

    boolean create(PARDJBZ et) ;
    void createBatch(List<PARDJBZ> list) ;
    PARDJBZ get(String key) ;
    boolean save(PARDJBZ et) ;
    void saveBatch(List<PARDJBZ> list) ;
    PARDJBZ getDraft(PARDJBZ et) ;
    boolean update(PARDJBZ et) ;
    void updateBatch(List<PARDJBZ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PARDJBZ et) ;
    Page<PARDJBZ> searchDefault(PARDJBZSearchContext context) ;
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


