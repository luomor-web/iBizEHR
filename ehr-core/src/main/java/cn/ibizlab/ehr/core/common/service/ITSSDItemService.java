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

import cn.ibizlab.ehr.core.common.domain.TSSDItem;
import cn.ibizlab.ehr.core.common.filter.TSSDItemSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TSSDItem] 服务对象接口
 */
public interface ITSSDItemService extends IService<TSSDItem>{

    boolean create(TSSDItem et) ;
    void createBatch(List<TSSDItem> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TSSDItem et) ;
    TSSDItem getDraft(TSSDItem et) ;
    TSSDItem get(String key) ;
    boolean update(TSSDItem et) ;
    void updateBatch(List<TSSDItem> list) ;
    boolean save(TSSDItem et) ;
    void saveBatch(List<TSSDItem> list) ;
    Page<TSSDItem> searchDefault(TSSDItemSearchContext context) ;
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


