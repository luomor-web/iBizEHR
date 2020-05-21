package cn.ibizlab.ehr.core.wf.service;

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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.wf.domain.WFAction;
import cn.ibizlab.ehr.core.wf.filter.WFActionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFAction] 服务对象接口
 */
public interface IWFActionService extends IService<WFAction>{

    boolean checkKey(WFAction et) ;
    WFAction getDraft(WFAction et) ;
    boolean update(WFAction et) ;
    void updateBatch(List<WFAction> list) ;
    boolean save(WFAction et) ;
    void saveBatch(List<WFAction> list) ;
    boolean create(WFAction et) ;
    void createBatch(List<WFAction> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFAction get(String key) ;
    Page<WFAction> searchDefault(WFActionSearchContext context) ;
    List<WFAction> selectByWfworkflowid(String wfworkflowid) ;
    void removeByWfworkflowid(String wfworkflowid) ;
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


