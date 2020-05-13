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

import cn.ibizlab.ehr.core.pim.domain.PIMWorkflow;
import cn.ibizlab.ehr.core.pim.filter.PIMWorkflowSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMWorkflow] 服务对象接口
 */
public interface IPIMWorkflowService extends IService<PIMWorkflow>{

    boolean checkKey(PIMWorkflow et) ;
    PIMWorkflow getDraft(PIMWorkflow et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PIMWorkflow et) ;
    void saveBatch(List<PIMWorkflow> list) ;
    PIMWorkflow sync(PIMWorkflow et) ;
    PIMWorkflow get(String key) ;
    boolean update(PIMWorkflow et) ;
    void updateBatch(List<PIMWorkflow> list) ;
    boolean create(PIMWorkflow et) ;
    void createBatch(List<PIMWorkflow> list) ;
    Page<PIMWorkflow> searchDefault(PIMWorkflowSearchContext context) ;
    List<PIMWorkflow> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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


