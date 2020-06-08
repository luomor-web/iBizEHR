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

import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSpyy;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSpyySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmProfileSpyy] 服务对象接口
 */
public interface IPcmProfileSpyyService extends IService<PcmProfileSpyy>{

    PcmProfileSpyy getDraft(PcmProfileSpyy et) ;
    boolean checkKey(PcmProfileSpyy et) ;
    PcmProfileSpyy get(String key) ;
    boolean save(PcmProfileSpyy et) ;
    void saveBatch(List<PcmProfileSpyy> list) ;
    boolean create(PcmProfileSpyy et) ;
    void createBatch(List<PcmProfileSpyy> list) ;
    boolean update(PcmProfileSpyy et) ;
    void updateBatch(List<PcmProfileSpyy> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmProfileSpyy> searchDefault(PcmProfileSpyySearchContext context) ;
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

    List<PcmProfileSpyy> getPcmprofilespyyByIds(List<String> ids) ;
    List<PcmProfileSpyy> getPcmprofilespyyByEntities(List<PcmProfileSpyy> entities) ;

}


