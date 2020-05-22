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

import cn.ibizlab.ehr.core.pcm.domain.PCMAWARDSWONS;
import cn.ibizlab.ehr.core.pcm.filter.PCMAWARDSWONSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMAWARDSWONS] 服务对象接口
 */
public interface IPCMAWARDSWONSService extends IService<PCMAWARDSWONS>{

    PCMAWARDSWONS getDraft(PCMAWARDSWONS et) ;
    PCMAWARDSWONS get(String key) ;
    boolean update(PCMAWARDSWONS et) ;
    void updateBatch(List<PCMAWARDSWONS> list) ;
    boolean create(PCMAWARDSWONS et) ;
    void createBatch(List<PCMAWARDSWONS> list) ;
    boolean checkKey(PCMAWARDSWONS et) ;
    boolean save(PCMAWARDSWONS et) ;
    void saveBatch(List<PCMAWARDSWONS> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMAWARDSWONS> searchDefault(PCMAWARDSWONSSearchContext context) ;
    List<PCMAWARDSWONS> selectByPcmprofileid(String pcmprofileid) ;
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


