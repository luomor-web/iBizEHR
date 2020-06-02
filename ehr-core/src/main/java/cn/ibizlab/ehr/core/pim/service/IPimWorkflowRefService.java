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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.pim.domain.PimWorkflowRef;
import cn.ibizlab.ehr.core.pim.filter.PimWorkflowRefSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimWorkflowRef] 服务对象接口
 */
public interface IPimWorkflowRefService extends IService<PimWorkflowRef>{

    PimWorkflowRef getDraft(PimWorkflowRef et) ;
    boolean update(PimWorkflowRef et) ;
    void updateBatch(List<PimWorkflowRef> list) ;
    PimWorkflowRef get(String key) ;
    boolean save(PimWorkflowRef et) ;
    void saveBatch(List<PimWorkflowRef> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimWorkflowRef et) ;
    void createBatch(List<PimWorkflowRef> list) ;
    boolean checkKey(PimWorkflowRef et) ;
    Page<PimWorkflowRef> searchDefault(PimWorkflowRefSearchContext context) ;
    List<PimWorkflowRef> selectByPimworkflowid(String pimworkflowid) ;
    void removeByPimworkflowid(String pimworkflowid) ;
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

    List<PimWorkflowRef> getPimworkflowrefByIds(List<String> ids) ;
    List<PimWorkflowRef> getPimworkflowrefByEntities(List<PimWorkflowRef> entities) ;

}


