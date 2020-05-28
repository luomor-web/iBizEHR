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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILESPYY;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESPYYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILESPYY] 服务对象接口
 */
public interface IPCMPROFILESPYYService extends IService<PCMPROFILESPYY>{

    PCMPROFILESPYY getDraft(PCMPROFILESPYY et) ;
    boolean checkKey(PCMPROFILESPYY et) ;
    PCMPROFILESPYY get(String key) ;
    boolean save(PCMPROFILESPYY et) ;
    void saveBatch(List<PCMPROFILESPYY> list) ;
    boolean create(PCMPROFILESPYY et) ;
    void createBatch(List<PCMPROFILESPYY> list) ;
    boolean update(PCMPROFILESPYY et) ;
    void updateBatch(List<PCMPROFILESPYY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMPROFILESPYY> searchDefault(PCMPROFILESPYYSearchContext context) ;
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

    List<PCMPROFILESPYY> getPcmprofilespyyByIds(List<String> ids) ;
    List<PCMPROFILESPYY> getPcmprofilespyyByEntities(List<PCMPROFILESPYY> entities) ;

}


