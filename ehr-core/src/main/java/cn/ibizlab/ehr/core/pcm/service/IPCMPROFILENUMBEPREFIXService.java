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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILENUMBEPREFIX;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILENUMBEPREFIXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILENUMBEPREFIX] 服务对象接口
 */
public interface IPCMPROFILENUMBEPREFIXService extends IService<PCMPROFILENUMBEPREFIX>{

    PCMPROFILENUMBEPREFIX get(String key) ;
    boolean save(PCMPROFILENUMBEPREFIX et) ;
    void saveBatch(List<PCMPROFILENUMBEPREFIX> list) ;
    boolean update(PCMPROFILENUMBEPREFIX et) ;
    void updateBatch(List<PCMPROFILENUMBEPREFIX> list) ;
    boolean create(PCMPROFILENUMBEPREFIX et) ;
    void createBatch(List<PCMPROFILENUMBEPREFIX> list) ;
    boolean checkKey(PCMPROFILENUMBEPREFIX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMPROFILENUMBEPREFIX getDraft(PCMPROFILENUMBEPREFIX et) ;
    Page<PCMPROFILENUMBEPREFIX> searchDefault(PCMPROFILENUMBEPREFIXSearchContext context) ;
    List<PCMPROFILENUMBEPREFIX> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<PCMPROFILENUMBEPREFIX> getPcmprofilenumbeprefixByIds(List<String> ids) ;
    List<PCMPROFILENUMBEPREFIX> getPcmprofilenumbeprefixByEntities(List<PCMPROFILENUMBEPREFIX> entities) ;

}


