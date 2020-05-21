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

import cn.ibizlab.ehr.core.wf.domain.WFVersion;
import cn.ibizlab.ehr.core.wf.filter.WFVersionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFVersion] 服务对象接口
 */
public interface IWFVersionService extends IService<WFVersion>{

    WFVersion get(String key) ;
    boolean create(WFVersion et) ;
    void createBatch(List<WFVersion> list) ;
    boolean save(WFVersion et) ;
    void saveBatch(List<WFVersion> list) ;
    WFVersion getDraft(WFVersion et) ;
    boolean update(WFVersion et) ;
    void updateBatch(List<WFVersion> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFVersion et) ;
    Page<WFVersion> searchDefault(WFVersionSearchContext context) ;
    List<WFVersion> selectByWfwfid(String wfworkflowid) ;
    void removeByWfwfid(String wfworkflowid) ;
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


