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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEFJ;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEFJSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILEFJ] 服务对象接口
 */
public interface IPCMPROFILEFJService extends IService<PCMPROFILEFJ>{

    PCMPROFILEFJ getDraft(PCMPROFILEFJ et) ;
    boolean checkKey(PCMPROFILEFJ et) ;
    boolean update(PCMPROFILEFJ et) ;
    void updateBatch(List<PCMPROFILEFJ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMPROFILEFJ get(String key) ;
    boolean save(PCMPROFILEFJ et) ;
    void saveBatch(List<PCMPROFILEFJ> list) ;
    boolean create(PCMPROFILEFJ et) ;
    void createBatch(List<PCMPROFILEFJ> list) ;
    Page<PCMPROFILEFJ> searchPROFILEFJ(PCMPROFILEFJSearchContext context) ;
    Page<PCMPROFILEFJ> searchDefault(PCMPROFILEFJSearchContext context) ;
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


