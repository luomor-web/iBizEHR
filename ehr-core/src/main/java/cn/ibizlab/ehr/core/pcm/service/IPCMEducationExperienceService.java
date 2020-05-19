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

import cn.ibizlab.ehr.core.pcm.domain.PCMEducationExperience;
import cn.ibizlab.ehr.core.pcm.filter.PCMEducationExperienceSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMEducationExperience] 服务对象接口
 */
public interface IPCMEducationExperienceService extends IService<PCMEducationExperience>{

    boolean checkKey(PCMEducationExperience et) ;
    PCMEducationExperience get(String key) ;
    PCMEducationExperience checkHighestEdu(PCMEducationExperience et) ;
    boolean create(PCMEducationExperience et) ;
    void createBatch(List<PCMEducationExperience> list) ;
    PCMEducationExperience checkRepeatXL(PCMEducationExperience et) ;
    boolean save(PCMEducationExperience et) ;
    void saveBatch(List<PCMEducationExperience> list) ;
    PCMEducationExperience getDraft(PCMEducationExperience et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMEducationExperience et) ;
    void updateBatch(List<PCMEducationExperience> list) ;
    PCMEducationExperience checkTime(PCMEducationExperience et) ;
    Page<PCMEducationExperience> searchDefault(PCMEducationExperienceSearchContext context) ;
    List<PCMEducationExperience> selectByPcmprofileid(String pcmprofileid) ;
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

}


