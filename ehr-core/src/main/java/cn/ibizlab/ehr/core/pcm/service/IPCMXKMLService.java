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

import cn.ibizlab.ehr.core.pcm.domain.PCMXKML;
import cn.ibizlab.ehr.core.pcm.filter.PCMXKMLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMXKML] 服务对象接口
 */
public interface IPCMXKMLService extends IService<PCMXKML>{

    boolean update(PCMXKML et) ;
    void updateBatch(List<PCMXKML> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMXKML get(String key) ;
    boolean create(PCMXKML et) ;
    void createBatch(List<PCMXKML> list) ;
    boolean save(PCMXKML et) ;
    void saveBatch(List<PCMXKML> list) ;
    boolean checkKey(PCMXKML et) ;
    PCMXKML getDraft(PCMXKML et) ;
    Page<PCMXKML> searchDefault(PCMXKMLSearchContext context) ;
    Page<PCMXKML> searchCurND(PCMXKMLSearchContext context) ;
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

