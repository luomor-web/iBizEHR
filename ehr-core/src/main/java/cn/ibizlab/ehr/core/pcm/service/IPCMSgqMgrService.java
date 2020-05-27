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

import cn.ibizlab.ehr.core.pcm.domain.PCMSgqMgr;
import cn.ibizlab.ehr.core.pcm.filter.PCMSgqMgrSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMSgqMgr] 服务对象接口
 */
public interface IPCMSgqMgrService extends IService<PCMSgqMgr>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMSgqMgr sGTG(PCMSgqMgr et) ;
    PCMSgqMgr get(String key) ;
    PCMSgqMgr sGBTG(PCMSgqMgr et) ;
    boolean checkKey(PCMSgqMgr et) ;
    boolean update(PCMSgqMgr et) ;
    void updateBatch(List<PCMSgqMgr> list) ;
    boolean create(PCMSgqMgr et) ;
    void createBatch(List<PCMSgqMgr> list) ;
    boolean save(PCMSgqMgr et) ;
    void saveBatch(List<PCMSgqMgr> list) ;
    PCMSgqMgr getDraft(PCMSgqMgr et) ;
    Page<PCMSgqMgr> searchDefault(PCMSgqMgrSearchContext context) ;
    List<PCMSgqMgr> selectByPcmbdsqdmxid(String pcmbdsqdmxid) ;
    void removeByPcmbdsqdmxid(String pcmbdsqdmxid) ;
    List<PCMSgqMgr> selectByPimpersonid(String pimpersonid) ;
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

    List<PCMSgqMgr> getPcmsgqmgrByIds(List<String> ids) ;
    List<PCMSgqMgr> getPcmsgqmgrByEntities(List<PCMSgqMgr> entities) ;

}


