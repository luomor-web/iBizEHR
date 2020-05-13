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

import cn.ibizlab.ehr.core.pcm.domain.PCMYPZJKXX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYPZJKXXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYPZJKXX] 服务对象接口
 */
public interface IPCMYPZJKXXService extends IService<PCMYPZJKXX>{

    boolean update(PCMYPZJKXX et) ;
    void updateBatch(List<PCMYPZJKXX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMYPZJKXX et) ;
    PCMYPZJKXX get(String key) ;
    PCMYPZJKXX getDraft(PCMYPZJKXX et) ;
    boolean create(PCMYPZJKXX et) ;
    void createBatch(List<PCMYPZJKXX> list) ;
    boolean save(PCMYPZJKXX et) ;
    void saveBatch(List<PCMYPZJKXX> list) ;
    Page<PCMYPZJKXX> searchDefault(PCMYPZJKXXSearchContext context) ;
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


