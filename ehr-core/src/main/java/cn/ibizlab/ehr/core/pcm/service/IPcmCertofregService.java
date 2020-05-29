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

import cn.ibizlab.ehr.core.pcm.domain.PcmCertofreg;
import cn.ibizlab.ehr.core.pcm.filter.PcmCertofregSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmCertofreg] 服务对象接口
 */
public interface IPcmCertofregService extends IService<PcmCertofreg>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PcmCertofreg et) ;
    void saveBatch(List<PcmCertofreg> list) ;
    PcmCertofreg getDraft(PcmCertofreg et) ;
    boolean create(PcmCertofreg et) ;
    void createBatch(List<PcmCertofreg> list) ;
    boolean update(PcmCertofreg et) ;
    void updateBatch(List<PcmCertofreg> list) ;
    PcmCertofreg get(String key) ;
    boolean checkKey(PcmCertofreg et) ;
    Page<PcmCertofreg> searchDefault(PcmCertofregSearchContext context) ;
    List<PcmCertofreg> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
    List<PcmCertofreg> selectByPimqualmajorid(String pimqualmajorid) ;
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

    List<PcmCertofreg> getPcmcertofregByIds(List<String> ids) ;
    List<PcmCertofreg> getPcmcertofregByEntities(List<PcmCertofreg> entities) ;

}


