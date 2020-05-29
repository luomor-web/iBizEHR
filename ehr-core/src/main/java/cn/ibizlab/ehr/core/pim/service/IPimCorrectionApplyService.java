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

import cn.ibizlab.ehr.core.pim.domain.PimCorrectionApply;
import cn.ibizlab.ehr.core.pim.filter.PimCorrectionApplySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimCorrectionApply] 服务对象接口
 */
public interface IPimCorrectionApplyService extends IService<PimCorrectionApply>{

    boolean create(PimCorrectionApply et) ;
    void createBatch(List<PimCorrectionApply> list) ;
    PimCorrectionApply getDraft(PimCorrectionApply et) ;
    boolean checkKey(PimCorrectionApply et) ;
    boolean save(PimCorrectionApply et) ;
    void saveBatch(List<PimCorrectionApply> list) ;
    PimCorrectionApply get(String key) ;
    boolean update(PimCorrectionApply et) ;
    void updateBatch(List<PimCorrectionApply> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimCorrectionApply> searchDefault(PimCorrectionApplySearchContext context) ;
    List<PimCorrectionApply> selectByPimbyygzzsqid(String pimbyygzzsqid) ;
    void removeByPimbyygzzsqid(String pimbyygzzsqid) ;
    List<PimCorrectionApply> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<PimCorrectionApply> getPimcorrectionapplyByIds(List<String> ids) ;
    List<PimCorrectionApply> getPimcorrectionapplyByEntities(List<PimCorrectionApply> entities) ;

}


