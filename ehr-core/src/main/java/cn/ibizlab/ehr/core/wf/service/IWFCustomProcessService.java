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

import cn.ibizlab.ehr.core.wf.domain.WFCustomProcess;
import cn.ibizlab.ehr.core.wf.filter.WFCustomProcessSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFCustomProcess] 服务对象接口
 */
public interface IWFCustomProcessService extends IService<WFCustomProcess>{

    boolean save(WFCustomProcess et) ;
    void saveBatch(List<WFCustomProcess> list) ;
    WFCustomProcess get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(WFCustomProcess et) ;
    void updateBatch(List<WFCustomProcess> list) ;
    WFCustomProcess getDraft(WFCustomProcess et) ;
    boolean checkKey(WFCustomProcess et) ;
    boolean create(WFCustomProcess et) ;
    void createBatch(List<WFCustomProcess> list) ;
    Page<WFCustomProcess> searchDefault(WFCustomProcessSearchContext context) ;
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


