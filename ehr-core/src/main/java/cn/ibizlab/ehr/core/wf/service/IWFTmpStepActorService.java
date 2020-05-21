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

import cn.ibizlab.ehr.core.wf.domain.WFTmpStepActor;
import cn.ibizlab.ehr.core.wf.filter.WFTmpStepActorSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFTmpStepActor] 服务对象接口
 */
public interface IWFTmpStepActorService extends IService<WFTmpStepActor>{

    boolean update(WFTmpStepActor et) ;
    void updateBatch(List<WFTmpStepActor> list) ;
    boolean checkKey(WFTmpStepActor et) ;
    boolean create(WFTmpStepActor et) ;
    void createBatch(List<WFTmpStepActor> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFTmpStepActor getDraft(WFTmpStepActor et) ;
    WFTmpStepActor get(String key) ;
    boolean save(WFTmpStepActor et) ;
    void saveBatch(List<WFTmpStepActor> list) ;
    Page<WFTmpStepActor> searchDefault(WFTmpStepActorSearchContext context) ;
    List<WFTmpStepActor> selectByWfactorid(String wfactorid) ;
    void removeByWfactorid(String wfactorid) ;
    List<WFTmpStepActor> selectByPrevwfstepid(String wfstepid) ;
    void removeByPrevwfstepid(String wfstepid) ;
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


