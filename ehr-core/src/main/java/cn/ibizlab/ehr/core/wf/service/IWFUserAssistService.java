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

import cn.ibizlab.ehr.core.wf.domain.WFUserAssist;
import cn.ibizlab.ehr.core.wf.filter.WFUserAssistSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFUserAssist] 服务对象接口
 */
public interface IWFUserAssistService extends IService<WFUserAssist>{

    boolean create(WFUserAssist et) ;
    void createBatch(List<WFUserAssist> list) ;
    boolean update(WFUserAssist et) ;
    void updateBatch(List<WFUserAssist> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFUserAssist et) ;
    WFUserAssist getDraft(WFUserAssist et) ;
    boolean save(WFUserAssist et) ;
    void saveBatch(List<WFUserAssist> list) ;
    WFUserAssist get(String key) ;
    Page<WFUserAssist> searchDefault(WFUserAssistSearchContext context) ;
    List<WFUserAssist> selectByWfmajoruserid(String wfuserid) ;
    void removeByWfmajoruserid(String wfuserid) ;
    List<WFUserAssist> selectByWfminoruserid(String wfuserid) ;
    void removeByWfminoruserid(String wfuserid) ;
    List<WFUserAssist> selectByWfworkflowid(String wfworkflowid) ;
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


