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

import cn.ibizlab.ehr.core.wf.domain.WFStepData;
import cn.ibizlab.ehr.core.wf.filter.WFStepDataSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFStepData] 服务对象接口
 */
public interface IWFStepDataService extends IService<WFStepData>{

    WFStepData getDraft(WFStepData et) ;
    boolean checkKey(WFStepData et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFStepData rollback(WFStepData et) ;
    WFStepData get(String key) ;
    boolean create(WFStepData et) ;
    void createBatch(List<WFStepData> list) ;
    boolean save(WFStepData et) ;
    void saveBatch(List<WFStepData> list) ;
    boolean update(WFStepData et) ;
    void updateBatch(List<WFStepData> list) ;
    Page<WFStepData> searchMyHist(WFStepDataSearchContext context) ;
    Page<WFStepData> searchDefault(WFStepDataSearchContext context) ;
    List<WFStepData> selectByWfinstanceid(String wfinstanceid) ;
    void removeByWfinstanceid(String wfinstanceid) ;
    List<WFStepData> selectByWfstepid(String wfstepid) ;
    void removeByWfstepid(String wfstepid) ;
    List<WFStepData> selectByOriginalwfuserid(String wfuserid) ;
    void removeByOriginalwfuserid(String wfuserid) ;
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


