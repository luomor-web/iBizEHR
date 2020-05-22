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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEINITNUMBER;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEINITNUMBERSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILEINITNUMBER] 服务对象接口
 */
public interface IPCMPROFILEINITNUMBERService extends IService<PCMPROFILEINITNUMBER>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PCMPROFILEINITNUMBER et) ;
    void saveBatch(List<PCMPROFILEINITNUMBER> list) ;
    boolean update(PCMPROFILEINITNUMBER et) ;
    void updateBatch(List<PCMPROFILEINITNUMBER> list) ;
    boolean create(PCMPROFILEINITNUMBER et) ;
    void createBatch(List<PCMPROFILEINITNUMBER> list) ;
    PCMPROFILEINITNUMBER get(String key) ;
    PCMPROFILEINITNUMBER getDraft(PCMPROFILEINITNUMBER et) ;
    boolean checkKey(PCMPROFILEINITNUMBER et) ;
    Page<PCMPROFILEINITNUMBER> searchDefault(PCMPROFILEINITNUMBERSearchContext context) ;
    List<PCMPROFILEINITNUMBER> selectByOrmorgid(String orgid) ;
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

}


