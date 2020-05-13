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

import cn.ibizlab.ehr.core.pcm.domain.PCMMSPJXX;
import cn.ibizlab.ehr.core.pcm.filter.PCMMSPJXXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMMSPJXX] 服务对象接口
 */
public interface IPCMMSPJXXService extends IService<PCMMSPJXX>{

    PCMMSPJXX getDraft(PCMMSPJXX et) ;
    boolean create(PCMMSPJXX et) ;
    void createBatch(List<PCMMSPJXX> list) ;
    boolean checkKey(PCMMSPJXX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMMSPJXX get(String key) ;
    boolean save(PCMMSPJXX et) ;
    void saveBatch(List<PCMMSPJXX> list) ;
    boolean update(PCMMSPJXX et) ;
    void updateBatch(List<PCMMSPJXX> list) ;
    Page<PCMMSPJXX> searchDefault(PCMMSPJXXSearchContext context) ;
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


