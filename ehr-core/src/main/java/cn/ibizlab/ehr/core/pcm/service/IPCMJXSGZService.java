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

import cn.ibizlab.ehr.core.pcm.domain.PCMJXSGZ;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSGZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMJXSGZ] 服务对象接口
 */
public interface IPCMJXSGZService extends IService<PCMJXSGZ>{

    boolean checkKey(PCMJXSGZ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMJXSGZ et) ;
    void updateBatch(List<PCMJXSGZ> list) ;
    PCMJXSGZ get(String key) ;
    PCMJXSGZ getDraft(PCMJXSGZ et) ;
    boolean create(PCMJXSGZ et) ;
    void createBatch(List<PCMJXSGZ> list) ;
    boolean save(PCMJXSGZ et) ;
    void saveBatch(List<PCMJXSGZ> list) ;
    Page<PCMJXSGZ> searchDefault(PCMJXSGZSearchContext context) ;
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


