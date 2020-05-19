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

import cn.ibizlab.ehr.core.wf.domain.WFWorkList;
import cn.ibizlab.ehr.core.wf.filter.WFWorkListSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFWorkList] 服务对象接口
 */
public interface IWFWorkListService extends IService<WFWorkList>{

    WFWorkList getDraft(WFWorkList et) ;
    boolean checkKey(WFWorkList et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(WFWorkList et) ;
    void saveBatch(List<WFWorkList> list) ;
    boolean create(WFWorkList et) ;
    void createBatch(List<WFWorkList> list) ;
    WFWorkList get(String key) ;
    boolean update(WFWorkList et) ;
    void updateBatch(List<WFWorkList> list) ;
    Page<WFWorkList> searchDefault(WFWorkListSearchContext context) ;
    List<WFWorkList> selectByWfinstanceid(String wfinstanceid) ;
    void removeByWfinstanceid(String wfinstanceid) ;
    List<WFWorkList> selectByOriginalwfuserid(String wfuserid) ;
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


