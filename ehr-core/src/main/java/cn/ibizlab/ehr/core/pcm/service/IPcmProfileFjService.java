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

import cn.ibizlab.ehr.core.pcm.domain.PcmProfileFj;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileFjSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmProfileFj] 服务对象接口
 */
public interface IPcmProfileFjService extends IService<PcmProfileFj>{

    PcmProfileFj getDraft(PcmProfileFj et) ;
    boolean checkKey(PcmProfileFj et) ;
    boolean update(PcmProfileFj et) ;
    void updateBatch(List<PcmProfileFj> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmProfileFj get(String key) ;
    boolean save(PcmProfileFj et) ;
    void saveBatch(List<PcmProfileFj> list) ;
    boolean create(PcmProfileFj et) ;
    void createBatch(List<PcmProfileFj> list) ;
    Page<PcmProfileFj> searchPROFILEFJ(PcmProfileFjSearchContext context) ;
    Page<PcmProfileFj> searchDefault(PcmProfileFjSearchContext context) ;
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

    List<PcmProfileFj> getPcmprofilefjByIds(List<String> ids) ;
    List<PcmProfileFj> getPcmprofilefjByEntities(List<PcmProfileFj> entities) ;

}


