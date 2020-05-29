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

import cn.ibizlab.ehr.core.pcm.domain.PcmCsrcmspj;
import cn.ibizlab.ehr.core.pcm.filter.PcmCsrcmspjSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmCsrcmspj] 服务对象接口
 */
public interface IPcmCsrcmspjService extends IService<PcmCsrcmspj>{

    boolean create(PcmCsrcmspj et) ;
    void createBatch(List<PcmCsrcmspj> list) ;
    PcmCsrcmspj getDraft(PcmCsrcmspj et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PcmCsrcmspj et) ;
    void updateBatch(List<PcmCsrcmspj> list) ;
    boolean save(PcmCsrcmspj et) ;
    void saveBatch(List<PcmCsrcmspj> list) ;
    boolean checkKey(PcmCsrcmspj et) ;
    PcmCsrcmspj get(String key) ;
    Page<PcmCsrcmspj> searchDefault(PcmCsrcmspjSearchContext context) ;
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

    List<PcmCsrcmspj> getPcmcsrcmspjByIds(List<String> ids) ;
    List<PcmCsrcmspj> getPcmcsrcmspjByEntities(List<PcmCsrcmspj> entities) ;

}


