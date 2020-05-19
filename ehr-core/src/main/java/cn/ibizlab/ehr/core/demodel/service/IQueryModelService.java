package cn.ibizlab.ehr.core.demodel.service;

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

import cn.ibizlab.ehr.core.demodel.domain.QueryModel;
import cn.ibizlab.ehr.core.demodel.filter.QueryModelSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[QueryModel] 服务对象接口
 */
public interface IQueryModelService extends IService<QueryModel>{

    QueryModel get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(QueryModel et) ;
    void updateBatch(List<QueryModel> list) ;
    boolean save(QueryModel et) ;
    void saveBatch(List<QueryModel> list) ;
    QueryModel getDraft(QueryModel et) ;
    boolean checkKey(QueryModel et) ;
    boolean create(QueryModel et) ;
    void createBatch(List<QueryModel> list) ;
    Page<QueryModel> searchDefault(QueryModelSearchContext context) ;
    Page<QueryModel> searchCurDE(QueryModelSearchContext context) ;
    List<QueryModel> selectByDeid(String deid) ;
    void removeByDeid(String deid) ;
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


