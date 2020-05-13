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

import cn.ibizlab.ehr.core.pcm.domain.PCMTXFPSQ;
import cn.ibizlab.ehr.core.pcm.filter.PCMTXFPSQSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMTXFPSQ] 服务对象接口
 */
public interface IPCMTXFPSQService extends IService<PCMTXFPSQ>{

    PCMTXFPSQ fillPersonInfo(PCMTXFPSQ et) ;
    boolean update(PCMTXFPSQ et) ;
    void updateBatch(List<PCMTXFPSQ> list) ;
    PCMTXFPSQ fPCZ(PCMTXFPSQ et) ;
    PCMTXFPSQ get(String key) ;
    PCMTXFPSQ finishFP(PCMTXFPSQ et) ;
    PCMTXFPSQ getDraft(PCMTXFPSQ et) ;
    PCMTXFPSQ sHTG(PCMTXFPSQ et) ;
    PCMTXFPSQ sHBTG(PCMTXFPSQ et) ;
    boolean checkKey(PCMTXFPSQ et) ;
    boolean save(PCMTXFPSQ et) ;
    void saveBatch(List<PCMTXFPSQ> list) ;
    boolean create(PCMTXFPSQ et) ;
    void createBatch(List<PCMTXFPSQ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMTXFPSQ> searchFPJL(PCMTXFPSQSearchContext context) ;
    Page<PCMTXFPSQ> searchDefault(PCMTXFPSQSearchContext context) ;
    Page<PCMTXFPSQ> searchYXSQDS(PCMTXFPSQSearchContext context) ;
    Page<PCMTXFPSQ> searchFPGL(PCMTXFPSQSearchContext context) ;
    List<PCMTXFPSQ> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
    List<PCMTXFPSQ> selectByPimpersonid(String pimpersonid) ;
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


