package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParAssessTemplate;
import cn.ibizlab.ehr.core.par.filter.ParAssessTemplateSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParAssessTemplate] 服务对象接口
 */
public interface IParAssessTemplateService extends IService<ParAssessTemplate>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParAssessTemplate getDraft(ParAssessTemplate et) ;
    ParAssessTemplate get(String key) ;
    boolean checkKey(ParAssessTemplate et) ;
    boolean update(ParAssessTemplate et) ;
    void updateBatch(List<ParAssessTemplate> list) ;
    boolean save(ParAssessTemplate et) ;
    void saveBatch(List<ParAssessTemplate> list) ;
    boolean create(ParAssessTemplate et) ;
    void createBatch(List<ParAssessTemplate> list) ;
    Page<ParAssessTemplate> searchDefault(ParAssessTemplateSearchContext context) ;
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

    List<ParAssessTemplate> getParassesstemplateByIds(List<String> ids) ;
    List<ParAssessTemplate> getParassesstemplateByEntities(List<ParAssessTemplate> entities) ;

}


