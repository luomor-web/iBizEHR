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

import cn.ibizlab.ehr.core.pcm.domain.PcmTestResult;
import cn.ibizlab.ehr.core.pcm.filter.PcmTestResultSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmTestResult] 服务对象接口
 */
public interface IPcmTestResultService extends IService<PcmTestResult>{

    PcmTestResult getDraft(PcmTestResult et) ;
    boolean checkKey(PcmTestResult et) ;
    boolean create(PcmTestResult et) ;
    void createBatch(List<PcmTestResult> list) ;
    boolean save(PcmTestResult et) ;
    void saveBatch(List<PcmTestResult> list) ;
    PcmTestResult get(String key) ;
    boolean update(PcmTestResult et) ;
    void updateBatch(List<PcmTestResult> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmTestResult> searchDefault(PcmTestResultSearchContext context) ;
    List<PcmTestResult> selectByPcmprofileid(String pcmprofileid) ;
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

    List<PcmTestResult> getPcmtestresultByIds(List<String> ids) ;
    List<PcmTestResult> getPcmtestresultByEntities(List<PcmTestResult> entities) ;

}


