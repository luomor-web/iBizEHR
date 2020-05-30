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

import cn.ibizlab.ehr.core.pcm.domain.PcmRzgl;
import cn.ibizlab.ehr.core.pcm.filter.PcmRzglSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmRzgl] 服务对象接口
 */
public interface IPcmRzglService extends IService<PcmRzgl>{

    PcmRzgl get(String key) ;
    boolean save(PcmRzgl et) ;
    void saveBatch(List<PcmRzgl> list) ;
    boolean checkKey(PcmRzgl et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PcmRzgl et) ;
    void createBatch(List<PcmRzgl> list) ;
    PcmRzgl getDraft(PcmRzgl et) ;
    boolean update(PcmRzgl et) ;
    void updateBatch(List<PcmRzgl> list) ;
    Page<PcmRzgl> searchDefault(PcmRzglSearchContext context) ;
    Page<PcmRzgl> searchGBRZQXDQ(PcmRzglSearchContext context) ;
    Page<PcmRzgl> searchRQCX(PcmRzglSearchContext context) ;
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

    List<PcmRzgl> getPcmrzglByIds(List<String> ids) ;
    List<PcmRzgl> getPcmrzglByEntities(List<PcmRzgl> entities) ;

}


