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

import cn.ibizlab.ehr.core.pcm.domain.PcmEducationExperience;
import cn.ibizlab.ehr.core.pcm.filter.PcmEducationExperienceSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmEducationExperience] 服务对象接口
 */
public interface IPcmEducationExperienceService extends IService<PcmEducationExperience>{

    boolean checkKey(PcmEducationExperience et) ;
    PcmEducationExperience get(String key) ;
    PcmEducationExperience checkHighestEdu(PcmEducationExperience et) ;
    boolean create(PcmEducationExperience et) ;
    void createBatch(List<PcmEducationExperience> list) ;
    PcmEducationExperience checkRepeatXL(PcmEducationExperience et) ;
    boolean save(PcmEducationExperience et) ;
    void saveBatch(List<PcmEducationExperience> list) ;
    PcmEducationExperience getDraft(PcmEducationExperience et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PcmEducationExperience et) ;
    void updateBatch(List<PcmEducationExperience> list) ;
    PcmEducationExperience checkTime(PcmEducationExperience et) ;
    Page<PcmEducationExperience> searchDefault(PcmEducationExperienceSearchContext context) ;
    List<PcmEducationExperience> selectByPcmprofileid(String pcmprofileid) ;
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

    List<PcmEducationExperience> getPcmeducationexperienceByIds(List<String> ids) ;
    List<PcmEducationExperience> getPcmeducationexperienceByEntities(List<PcmEducationExperience> entities) ;

}


