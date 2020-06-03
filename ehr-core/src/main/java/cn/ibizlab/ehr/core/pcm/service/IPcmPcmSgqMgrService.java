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

import cn.ibizlab.ehr.core.pcm.domain.PcmPcmSgqMgr;
import cn.ibizlab.ehr.core.pcm.filter.PcmPcmSgqMgrSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmPcmSgqMgr] 服务对象接口
 */
public interface IPcmPcmSgqMgrService extends IService<PcmPcmSgqMgr>{

    PcmPcmSgqMgr get(String key) ;
    PcmPcmSgqMgr getDraft(PcmPcmSgqMgr et) ;
    boolean create(PcmPcmSgqMgr et) ;
    void createBatch(List<PcmPcmSgqMgr> list) ;
    boolean update(PcmPcmSgqMgr et) ;
    void updateBatch(List<PcmPcmSgqMgr> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PcmPcmSgqMgr et) ;
    boolean save(PcmPcmSgqMgr et) ;
    void saveBatch(List<PcmPcmSgqMgr> list) ;
    Page<PcmPcmSgqMgr> searchDefault(PcmPcmSgqMgrSearchContext context) ;
    List<PcmPcmSgqMgr> selectByPcmbdsqdmxid(String pcmbdsqdmxid) ;
    void removeByPcmbdsqdmxid(String pcmbdsqdmxid) ;
    List<PcmPcmSgqMgr> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmPcmSgqMgr> getPcmpcmsgqmgrByIds(List<String> ids) ;
    List<PcmPcmSgqMgr> getPcmpcmsgqmgrByEntities(List<PcmPcmSgqMgr> entities) ;

}


