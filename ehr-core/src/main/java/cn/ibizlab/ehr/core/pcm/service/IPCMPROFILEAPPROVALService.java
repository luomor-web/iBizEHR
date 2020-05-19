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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEAPPROVAL;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEAPPROVALSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILEAPPROVAL] 服务对象接口
 */
public interface IPCMPROFILEAPPROVALService extends IService<PCMPROFILEAPPROVAL>{

    boolean update(PCMPROFILEAPPROVAL et) ;
    void updateBatch(List<PCMPROFILEAPPROVAL> list) ;
    PCMPROFILEAPPROVAL getDraft(PCMPROFILEAPPROVAL et) ;
    boolean create(PCMPROFILEAPPROVAL et) ;
    void createBatch(List<PCMPROFILEAPPROVAL> list) ;
    boolean save(PCMPROFILEAPPROVAL et) ;
    void saveBatch(List<PCMPROFILEAPPROVAL> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMPROFILEAPPROVAL get(String key) ;
    boolean checkKey(PCMPROFILEAPPROVAL et) ;
    Page<PCMPROFILEAPPROVAL> searchDefault(PCMPROFILEAPPROVALSearchContext context) ;
    Page<PCMPROFILEAPPROVAL> searchDisagree(PCMPROFILEAPPROVALSearchContext context) ;
    List<PCMPROFILEAPPROVAL> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
    List<PCMPROFILEAPPROVAL> selectByPimbyzzjlmxid(String pimbyzzjlmxid) ;
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

}


