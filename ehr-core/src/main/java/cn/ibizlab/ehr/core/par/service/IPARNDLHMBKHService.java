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

import cn.ibizlab.ehr.core.par.domain.PARNDLHMBKH;
import cn.ibizlab.ehr.core.par.filter.PARNDLHMBKHSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARNDLHMBKH] 服务对象接口
 */
public interface IPARNDLHMBKHService extends IService<PARNDLHMBKH>{

    boolean update(PARNDLHMBKH et) ;
    void updateBatch(List<PARNDLHMBKH> list) ;
    PARNDLHMBKH getDraft(PARNDLHMBKH et) ;
    boolean checkKey(PARNDLHMBKH et) ;
    boolean create(PARNDLHMBKH et) ;
    void createBatch(List<PARNDLHMBKH> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARNDLHMBKH et) ;
    void saveBatch(List<PARNDLHMBKH> list) ;
    PARNDLHMBKH get(String key) ;
    Page<PARNDLHMBKH> searchDefault(PARNDLHMBKHSearchContext context) ;
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


