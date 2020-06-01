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

import cn.ibizlab.ehr.core.pcm.domain.PcmWorkResume;
import cn.ibizlab.ehr.core.pcm.filter.PcmWorkResumeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmWorkResume] 服务对象接口
 */
public interface IPcmWorkResumeService extends IService<PcmWorkResume>{

    boolean create(PcmWorkResume et) ;
    void createBatch(List<PcmWorkResume> list) ;
    PcmWorkResume getDraft(PcmWorkResume et) ;
    boolean save(PcmWorkResume et) ;
    void saveBatch(List<PcmWorkResume> list) ;
    PcmWorkResume get(String key) ;
    boolean update(PcmWorkResume et) ;
    void updateBatch(List<PcmWorkResume> list) ;
    boolean checkKey(PcmWorkResume et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmWorkResume> searchDefault(PcmWorkResumeSearchContext context) ;
    List<PcmWorkResume> selectByPcmprofileid(String pcmprofileid) ;
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

    List<PcmWorkResume> getPcmworkresumeByIds(List<String> ids) ;
    List<PcmWorkResume> getPcmworkresumeByEntities(List<PcmWorkResume> entities) ;

}


