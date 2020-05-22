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

import cn.ibizlab.ehr.core.pcm.domain.PCMCERTOFREG;
import cn.ibizlab.ehr.core.pcm.filter.PCMCERTOFREGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMCERTOFREG] 服务对象接口
 */
public interface IPCMCERTOFREGService extends IService<PCMCERTOFREG>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PCMCERTOFREG et) ;
    void saveBatch(List<PCMCERTOFREG> list) ;
    PCMCERTOFREG getDraft(PCMCERTOFREG et) ;
    boolean create(PCMCERTOFREG et) ;
    void createBatch(List<PCMCERTOFREG> list) ;
    boolean update(PCMCERTOFREG et) ;
    void updateBatch(List<PCMCERTOFREG> list) ;
    PCMCERTOFREG get(String key) ;
    boolean checkKey(PCMCERTOFREG et) ;
    Page<PCMCERTOFREG> searchDefault(PCMCERTOFREGSearchContext context) ;
    List<PCMCERTOFREG> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
    List<PCMCERTOFREG> selectByPimqualmajorid(String pimqualmajorid) ;
    void removeByPimqualmajorid(String pimqualmajorid) ;
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


