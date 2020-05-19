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

import cn.ibizlab.ehr.core.wf.domain.WFIAAction;
import cn.ibizlab.ehr.core.wf.filter.WFIAActionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFIAAction] 服务对象接口
 */
public interface IWFIAActionService extends IService<WFIAAction>{

    boolean create(WFIAAction et) ;
    void createBatch(List<WFIAAction> list) ;
    WFIAAction get(String key) ;
    boolean update(WFIAAction et) ;
    void updateBatch(List<WFIAAction> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFIAAction et) ;
    WFIAAction getDraft(WFIAAction et) ;
    boolean save(WFIAAction et) ;
    void saveBatch(List<WFIAAction> list) ;
    Page<WFIAAction> searchDefault(WFIAActionSearchContext context) ;
    List<WFIAAction> selectByWfstepid(String wfstepid) ;
    void removeByWfstepid(String wfstepid) ;
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


