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

import cn.ibizlab.ehr.core.pcm.domain.PCMGBHMC;
import cn.ibizlab.ehr.core.pcm.filter.PCMGBHMCSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMGBHMC] 服务对象接口
 */
public interface IPCMGBHMCService extends IService<PCMGBHMC>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMGBHMC get(String key) ;
    PCMGBHMC toggleLeader(PCMGBHMC et) ;
    PCMGBHMC getDraft(PCMGBHMC et) ;
    boolean create(PCMGBHMC et) ;
    void createBatch(List<PCMGBHMC> list) ;
    boolean update(PCMGBHMC et) ;
    void updateBatch(List<PCMGBHMC> list) ;
    boolean save(PCMGBHMC et) ;
    void saveBatch(List<PCMGBHMC> list) ;
    PCMGBHMC sGTG(PCMGBHMC et) ;
    boolean checkKey(PCMGBHMC et) ;
    PCMGBHMC sGBTG(PCMGBHMC et) ;
    Page<PCMGBHMC> searchGBHMCNewTree(PCMGBHMCSearchContext context) ;
    Page<PCMGBHMC> searchGBHMCTree(PCMGBHMCSearchContext context) ;
    Page<PCMGBHMC> searchDefault(PCMGBHMCSearchContext context) ;
    Page<PCMGBHMC> searchZJPD(PCMGBHMCSearchContext context) ;
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


