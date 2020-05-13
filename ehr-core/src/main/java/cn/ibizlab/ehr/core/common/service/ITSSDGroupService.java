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

import cn.ibizlab.ehr.core.common.domain.TSSDGroup;
import cn.ibizlab.ehr.core.common.filter.TSSDGroupSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TSSDGroup] 服务对象接口
 */
public interface ITSSDGroupService extends IService<TSSDGroup>{

    boolean checkKey(TSSDGroup et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TSSDGroup getDraft(TSSDGroup et) ;
    boolean update(TSSDGroup et) ;
    void updateBatch(List<TSSDGroup> list) ;
    TSSDGroup get(String key) ;
    boolean save(TSSDGroup et) ;
    void saveBatch(List<TSSDGroup> list) ;
    boolean create(TSSDGroup et) ;
    void createBatch(List<TSSDGroup> list) ;
    Page<TSSDGroup> searchDefault(TSSDGroupSearchContext context) ;
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


