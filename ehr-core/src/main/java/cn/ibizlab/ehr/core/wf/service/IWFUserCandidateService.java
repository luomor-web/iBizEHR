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

import cn.ibizlab.ehr.core.wf.domain.WFUserCandidate;
import cn.ibizlab.ehr.core.wf.filter.WFUserCandidateSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFUserCandidate] 服务对象接口
 */
public interface IWFUserCandidateService extends IService<WFUserCandidate>{

    WFUserCandidate get(String key) ;
    boolean create(WFUserCandidate et) ;
    void createBatch(List<WFUserCandidate> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(WFUserCandidate et) ;
    void updateBatch(List<WFUserCandidate> list) ;
    boolean save(WFUserCandidate et) ;
    void saveBatch(List<WFUserCandidate> list) ;
    WFUserCandidate getDraft(WFUserCandidate et) ;
    boolean checkKey(WFUserCandidate et) ;
    Page<WFUserCandidate> searchDefault(WFUserCandidateSearchContext context) ;
    List<WFUserCandidate> selectByWfmajoruserid(String wfuserid) ;
    void removeByWfmajoruserid(String wfuserid) ;
    List<WFUserCandidate> selectByWfminoruserid(String wfuserid) ;
    void removeByWfminoruserid(String wfuserid) ;
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


