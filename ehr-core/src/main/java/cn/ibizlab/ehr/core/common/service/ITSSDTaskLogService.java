package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.TSSDTaskLog;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskLogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TSSDTaskLog] 服务对象接口
 */
public interface ITSSDTaskLogService extends IService<TSSDTaskLog>{

    TSSDTaskLog get(String key) ;
    boolean update(TSSDTaskLog et) ;
    void updateBatch(List<TSSDTaskLog> list) ;
    TSSDTaskLog getDraft(TSSDTaskLog et) ;
    boolean checkKey(TSSDTaskLog et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TSSDTaskLog et) ;
    void saveBatch(List<TSSDTaskLog> list) ;
    boolean create(TSSDTaskLog et) ;
    void createBatch(List<TSSDTaskLog> list) ;
    Page<TSSDTaskLog> searchDefault(TSSDTaskLogSearchContext context) ;
    List<TSSDTaskLog> selectByTssdtaskid(String tssdtaskid) ;
    void removeByTssdtaskid(String tssdtaskid) ;
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


