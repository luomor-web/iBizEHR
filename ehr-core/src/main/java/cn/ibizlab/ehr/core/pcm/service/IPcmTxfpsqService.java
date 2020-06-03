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

import cn.ibizlab.ehr.core.pcm.domain.PcmTxfpsq;
import cn.ibizlab.ehr.core.pcm.filter.PcmTxfpsqSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmTxfpsq] 服务对象接口
 */
public interface IPcmTxfpsqService extends IService<PcmTxfpsq>{

    PcmTxfpsq fillPersonInfo(PcmTxfpsq et) ;
    boolean update(PcmTxfpsq et) ;
    void updateBatch(List<PcmTxfpsq> list) ;
    PcmTxfpsq fPCZ(PcmTxfpsq et) ;
    PcmTxfpsq get(String key) ;
    PcmTxfpsq finishFP(PcmTxfpsq et) ;
    PcmTxfpsq getDraft(PcmTxfpsq et) ;
    PcmTxfpsq sHTG(PcmTxfpsq et) ;
    PcmTxfpsq sHBTG(PcmTxfpsq et) ;
    boolean checkKey(PcmTxfpsq et) ;
    boolean save(PcmTxfpsq et) ;
    void saveBatch(List<PcmTxfpsq> list) ;
    boolean create(PcmTxfpsq et) ;
    void createBatch(List<PcmTxfpsq> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmTxfpsq> searchFPJL(PcmTxfpsqSearchContext context) ;
    Page<PcmTxfpsq> searchDefault(PcmTxfpsqSearchContext context) ;
    Page<PcmTxfpsq> searchYXSQDS(PcmTxfpsqSearchContext context) ;
    Page<PcmTxfpsq> searchFPGL(PcmTxfpsqSearchContext context) ;
    List<PcmTxfpsq> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
    List<PcmTxfpsq> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmTxfpsq> getPcmtxfpsqByIds(List<String> ids) ;
    List<PcmTxfpsq> getPcmtxfpsqByEntities(List<PcmTxfpsq> entities) ;

}


