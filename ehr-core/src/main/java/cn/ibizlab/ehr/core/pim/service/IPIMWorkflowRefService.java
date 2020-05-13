package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PIMWorkflowRef;
import cn.ibizlab.ehr.core.pim.filter.PIMWorkflowRefSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMWorkflowRef] 服务对象接口
 */
public interface IPIMWorkflowRefService extends IService<PIMWorkflowRef>{

    PIMWorkflowRef getDraft(PIMWorkflowRef et) ;
    boolean update(PIMWorkflowRef et) ;
    void updateBatch(List<PIMWorkflowRef> list) ;
    PIMWorkflowRef get(String key) ;
    boolean save(PIMWorkflowRef et) ;
    void saveBatch(List<PIMWorkflowRef> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PIMWorkflowRef et) ;
    void createBatch(List<PIMWorkflowRef> list) ;
    boolean checkKey(PIMWorkflowRef et) ;
    Page<PIMWorkflowRef> searchDefault(PIMWorkflowRefSearchContext context) ;
    List<PIMWorkflowRef> selectByPimworkflowid(String pimworkflowid) ;
    void removeByPimworkflowid(String pimworkflowid) ;
    List<PIMWorkflowRef> selectByWfworkflowid(String wfworkflowid) ;
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


