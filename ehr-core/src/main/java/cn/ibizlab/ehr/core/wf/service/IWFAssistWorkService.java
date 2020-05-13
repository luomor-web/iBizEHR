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

import cn.ibizlab.ehr.core.wf.domain.WFAssistWork;
import cn.ibizlab.ehr.core.wf.filter.WFAssistWorkSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFAssistWork] 服务对象接口
 */
public interface IWFAssistWorkService extends IService<WFAssistWork>{

    boolean update(WFAssistWork et) ;
    void updateBatch(List<WFAssistWork> list) ;
    boolean create(WFAssistWork et) ;
    void createBatch(List<WFAssistWork> list) ;
    WFAssistWork get(String key) ;
    WFAssistWork getDraft(WFAssistWork et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFAssistWork et) ;
    boolean save(WFAssistWork et) ;
    void saveBatch(List<WFAssistWork> list) ;
    Page<WFAssistWork> searchCurUserAssistWork(WFAssistWorkSearchContext context) ;
    Page<WFAssistWork> searchDefault(WFAssistWorkSearchContext context) ;
    List<WFAssistWork> selectByWfinstanceid(String wfinstanceid) ;
    void removeByWfinstanceid(String wfinstanceid) ;
    List<WFAssistWork> selectByWfstepactorid(String wfstepactorid) ;
    void removeByWfstepactorid(String wfstepactorid) ;
    List<WFAssistWork> selectByWfworkflowid(String wfworkflowid) ;
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


