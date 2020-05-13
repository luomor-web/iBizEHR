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

import cn.ibizlab.ehr.core.wf.domain.WFStepActor;
import cn.ibizlab.ehr.core.wf.filter.WFStepActorSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFStepActor] 服务对象接口
 */
public interface IWFStepActorService extends IService<WFStepActor>{

    boolean save(WFStepActor et) ;
    void saveBatch(List<WFStepActor> list) ;
    WFStepActor remindSave(WFStepActor et) ;
    WFStepActor get(String key) ;
    boolean update(WFStepActor et) ;
    void updateBatch(List<WFStepActor> list) ;
    boolean create(WFStepActor et) ;
    void createBatch(List<WFStepActor> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFStepActor getDraft(WFStepActor et) ;
    boolean checkKey(WFStepActor et) ;
    Page<WFStepActor> searchDefault(WFStepActorSearchContext context) ;
    List<WFStepActor> selectByWfstepid(String wfstepid) ;
    void removeByWfstepid(String wfstepid) ;
    List<WFStepActor> selectByOriginalwfuserid(String wfuserid) ;
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


