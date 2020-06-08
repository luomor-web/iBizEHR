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

import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSzyjtj;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSzyjtjSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmProfileSzyjtj] 服务对象接口
 */
public interface IPcmProfileSzyjtjService extends IService<PcmProfileSzyjtj>{

    boolean save(PcmProfileSzyjtj et) ;
    void saveBatch(List<PcmProfileSzyjtj> list) ;
    boolean create(PcmProfileSzyjtj et) ;
    void createBatch(List<PcmProfileSzyjtj> list) ;
    PcmProfileSzyjtj getDraft(PcmProfileSzyjtj et) ;
    boolean checkKey(PcmProfileSzyjtj et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmProfileSzyjtj get(String key) ;
    boolean update(PcmProfileSzyjtj et) ;
    void updateBatch(List<PcmProfileSzyjtj> list) ;
    Page<PcmProfileSzyjtj> searchDefault(PcmProfileSzyjtjSearchContext context) ;
    Page<PcmProfileSzyjtj> searchYGLX(PcmProfileSzyjtjSearchContext context) ;
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

    List<PcmProfileSzyjtj> getPcmprofileszyjtjByIds(List<String> ids) ;
    List<PcmProfileSzyjtj> getPcmprofileszyjtjByEntities(List<PcmProfileSzyjtj> entities) ;

}


