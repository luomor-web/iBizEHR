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

import cn.ibizlab.ehr.core.wf.domain.WFUserGroupDetail;
import cn.ibizlab.ehr.core.wf.filter.WFUserGroupDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFUserGroupDetail] 服务对象接口
 */
public interface IWFUserGroupDetailService extends IService<WFUserGroupDetail>{

    boolean create(WFUserGroupDetail et) ;
    void createBatch(List<WFUserGroupDetail> list) ;
    WFUserGroupDetail getDraft(WFUserGroupDetail et) ;
    WFUserGroupDetail get(String key) ;
    boolean save(WFUserGroupDetail et) ;
    void saveBatch(List<WFUserGroupDetail> list) ;
    boolean update(WFUserGroupDetail et) ;
    void updateBatch(List<WFUserGroupDetail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFUserGroupDetail et) ;
    Page<WFUserGroupDetail> searchDefault(WFUserGroupDetailSearchContext context) ;
    List<WFUserGroupDetail> selectByWfusergroupid(String wfusergroupid) ;
    void removeByWfusergroupid(String wfusergroupid) ;
    List<WFUserGroupDetail> selectByWfuserid(String wfuserid) ;
    void removeByWfuserid(String wfuserid) ;
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


