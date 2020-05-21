package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PCMDETAIL;
import cn.ibizlab.ehr.core.pim.filter.PCMDETAILSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMDETAIL] 服务对象接口
 */
public interface IPCMDETAILService extends IService<PCMDETAIL>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMDETAIL et) ;
    void updateBatch(List<PCMDETAIL> list) ;
    boolean create(PCMDETAIL et) ;
    void createBatch(List<PCMDETAIL> list) ;
    boolean checkKey(PCMDETAIL et) ;
    PCMDETAIL get(String key) ;
    boolean save(PCMDETAIL et) ;
    void saveBatch(List<PCMDETAIL> list) ;
    PCMDETAIL getDraft(PCMDETAIL et) ;
    Page<PCMDETAIL> searchDefault(PCMDETAILSearchContext context) ;
    List<PCMDETAIL> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMDETAIL> selectByOrmorgid(String orgid) ;
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


