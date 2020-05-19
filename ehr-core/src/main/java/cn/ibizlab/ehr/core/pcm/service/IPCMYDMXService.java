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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDMX] 服务对象接口
 */
public interface IPCMYDMXService extends IService<PCMYDMX>{

    boolean create(PCMYDMX et) ;
    void createBatch(List<PCMYDMX> list) ;
    boolean save(PCMYDMX et) ;
    void saveBatch(List<PCMYDMX> list) ;
    PCMYDMX fillPersonInfo(PCMYDMX et) ;
    boolean checkKey(PCMYDMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMYDMX et) ;
    void updateBatch(List<PCMYDMX> list) ;
    PCMYDMX getDraft(PCMYDMX et) ;
    PCMYDMX get(String key) ;
    Page<PCMYDMX> searchIndexDER(PCMYDMXSearchContext context) ;
    Page<PCMYDMX> searchDefault(PCMYDMXSearchContext context) ;
    List<PCMYDMX> selectByBmid(String orgsectorid) ;
    void removeByBmid(String orgsectorid) ;
    List<PCMYDMX> selectByZzid(String orgid) ;
    void removeByZzid(String orgid) ;
    List<PCMYDMX> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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


