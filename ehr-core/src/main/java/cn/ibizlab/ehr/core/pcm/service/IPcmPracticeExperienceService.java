package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.PcmPracticeExperience;
import cn.ibizlab.ehr.core.pcm.filter.PcmPracticeExperienceSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmPracticeExperience] 服务对象接口
 */
public interface IPcmPracticeExperienceService extends IService<PcmPracticeExperience>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PcmPracticeExperience et) ;
    void createBatch(List<PcmPracticeExperience> list) ;
    boolean update(PcmPracticeExperience et) ;
    void updateBatch(List<PcmPracticeExperience> list) ;
    PcmPracticeExperience getDraft(PcmPracticeExperience et) ;
    PcmPracticeExperience get(String key) ;
    boolean checkKey(PcmPracticeExperience et) ;
    boolean save(PcmPracticeExperience et) ;
    void saveBatch(List<PcmPracticeExperience> list) ;
    Page<PcmPracticeExperience> searchDefault(PcmPracticeExperienceSearchContext context) ;
    List<PcmPracticeExperience> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
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

    List<PcmPracticeExperience> getPcmpracticeexperienceByIds(List<String> ids) ;
    List<PcmPracticeExperience> getPcmpracticeexperienceByEntities(List<PcmPracticeExperience> entities) ;

}


