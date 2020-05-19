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

import cn.ibizlab.ehr.core.pcm.domain.PCMRCXL;
import cn.ibizlab.ehr.core.pcm.filter.PCMRCXLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMRCXL] 服务对象接口
 */
public interface IPCMRCXLService extends IService<PCMRCXL>{

    boolean create(PCMRCXL et) ;
    void createBatch(List<PCMRCXL> list) ;
    PCMRCXL getDraft(PCMRCXL et) ;
    PCMRCXL get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMRCXL et) ;
    void updateBatch(List<PCMRCXL> list) ;
    boolean checkKey(PCMRCXL et) ;
    boolean save(PCMRCXL et) ;
    void saveBatch(List<PCMRCXL> list) ;
    Page<PCMRCXL> searchCurrent(PCMRCXLSearchContext context) ;
    Page<PCMRCXL> searchRCXLPPXLLX(PCMRCXLSearchContext context) ;
    Page<PCMRCXL> searchZiDQ(PCMRCXLSearchContext context) ;
    Page<PCMRCXL> searchDefault(PCMRCXLSearchContext context) ;
    Page<PCMRCXL> searchGenDQ(PCMRCXLSearchContext context) ;
    List<PCMRCXL> selectByPcmrcxlid2(String pcmrcxlid) ;
    void removeByPcmrcxlid2(String pcmrcxlid) ;
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


