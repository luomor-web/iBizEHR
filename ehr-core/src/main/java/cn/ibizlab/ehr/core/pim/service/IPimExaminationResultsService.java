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

import cn.ibizlab.ehr.core.pim.domain.PimExaminationResults;
import cn.ibizlab.ehr.core.pim.filter.PimExaminationResultsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimExaminationResults] 服务对象接口
 */
public interface IPimExaminationResultsService extends IService<PimExaminationResults>{

    boolean update(PimExaminationResults et) ;
    void updateBatch(List<PimExaminationResults> list) ;
    boolean save(PimExaminationResults et) ;
    void saveBatch(List<PimExaminationResults> list) ;
    boolean checkKey(PimExaminationResults et) ;
    boolean create(PimExaminationResults et) ;
    void createBatch(List<PimExaminationResults> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimExaminationResults getDraft(PimExaminationResults et) ;
    PimExaminationResults get(String key) ;
    Page<PimExaminationResults> searchDefault(PimExaminationResultsSearchContext context) ;
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

    List<PimExaminationResults> getPimexaminationresultsByIds(List<String> ids) ;
    List<PimExaminationResults> getPimexaminationresultsByEntities(List<PimExaminationResults> entities) ;

}


