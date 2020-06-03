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

import cn.ibizlab.ehr.core.pcm.domain.PcmProfileApproval;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileApprovalSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmProfileApproval] 服务对象接口
 */
public interface IPcmProfileApprovalService extends IService<PcmProfileApproval>{

    boolean update(PcmProfileApproval et) ;
    void updateBatch(List<PcmProfileApproval> list) ;
    PcmProfileApproval getDraft(PcmProfileApproval et) ;
    boolean create(PcmProfileApproval et) ;
    void createBatch(List<PcmProfileApproval> list) ;
    boolean save(PcmProfileApproval et) ;
    void saveBatch(List<PcmProfileApproval> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmProfileApproval get(String key) ;
    boolean checkKey(PcmProfileApproval et) ;
    Page<PcmProfileApproval> searchDefault(PcmProfileApprovalSearchContext context) ;
    Page<PcmProfileApproval> searchDisagree(PcmProfileApprovalSearchContext context) ;
    List<PcmProfileApproval> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
    List<PcmProfileApproval> selectByPimbyzzjlmxid(String pimbyzzjlmxid) ;
    void removeByPimbyzzjlmxid(String pimbyzzjlmxid) ;
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

    List<PcmProfileApproval> getPcmprofileapprovalByIds(List<String> ids) ;
    List<PcmProfileApproval> getPcmprofileapprovalByEntities(List<PcmProfileApproval> entities) ;

}


