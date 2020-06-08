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

import cn.ibizlab.ehr.core.pim.domain.PimQuestions;
import cn.ibizlab.ehr.core.pim.filter.PimQuestionsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimQuestions] 服务对象接口
 */
public interface IPimQuestionsService extends IService<PimQuestions>{

    PimQuestions removeTemp(PimQuestions et) ;
    PimQuestions getTemp(PimQuestions et) ;
    PimQuestions getDraftTempMajor(PimQuestions et) ;
    PimQuestions updateTemp(PimQuestions et) ;
    boolean save(PimQuestions et) ;
    void saveBatch(List<PimQuestions> list) ;
    PimQuestions createTempMajor(PimQuestions et) ;
    boolean update(PimQuestions et) ;
    void updateBatch(List<PimQuestions> list) ;
    PimQuestions get(String key) ;
    PimQuestions updateTempMajor(PimQuestions et) ;
    boolean checkKey(PimQuestions et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimQuestions et) ;
    void createBatch(List<PimQuestions> list) ;
    PimQuestions getTempMajor(PimQuestions et) ;
    PimQuestions getDraft(PimQuestions et) ;
    PimQuestions createTemp(PimQuestions et) ;
    PimQuestions removeTempMajor(PimQuestions et) ;
    PimQuestions getDraftTemp(PimQuestions et) ;
    Page<PimQuestions> searchQUERYcurrentQUESTION(PimQuestionsSearchContext context) ;
    Page<PimQuestions> searchDefault(PimQuestionsSearchContext context) ;
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

    List<PimQuestions> getPimquestionsByIds(List<String> ids) ;
    List<PimQuestions> getPimquestionsByEntities(List<PimQuestions> entities) ;

}


