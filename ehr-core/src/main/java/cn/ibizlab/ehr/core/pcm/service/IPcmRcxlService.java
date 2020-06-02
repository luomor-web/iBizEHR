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

import cn.ibizlab.ehr.core.pcm.domain.PcmRcxl;
import cn.ibizlab.ehr.core.pcm.filter.PcmRcxlSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmRcxl] 服务对象接口
 */
public interface IPcmRcxlService extends IService<PcmRcxl>{

    boolean create(PcmRcxl et) ;
    void createBatch(List<PcmRcxl> list) ;
    PcmRcxl getDraft(PcmRcxl et) ;
    PcmRcxl get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PcmRcxl et) ;
    void updateBatch(List<PcmRcxl> list) ;
    boolean checkKey(PcmRcxl et) ;
    boolean save(PcmRcxl et) ;
    void saveBatch(List<PcmRcxl> list) ;
    Page<PcmRcxl> searchCurrent(PcmRcxlSearchContext context) ;
    Page<PcmRcxl> searchRCXLPPXLLX(PcmRcxlSearchContext context) ;
    Page<PcmRcxl> searchZiDQ(PcmRcxlSearchContext context) ;
    Page<PcmRcxl> searchDefault(PcmRcxlSearchContext context) ;
    Page<PcmRcxl> searchGenDQ(PcmRcxlSearchContext context) ;
    List<PcmRcxl> selectByPcmrcxlid2(String pcmrcxlid) ;
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

    List<PcmRcxl> getPcmrcxlByIds(List<String> ids) ;
    List<PcmRcxl> getPcmrcxlByEntities(List<PcmRcxl> entities) ;

}


