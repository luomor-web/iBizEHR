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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILESZYJTJ;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESZYJTJSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILESZYJTJ] 服务对象接口
 */
public interface IPCMPROFILESZYJTJService extends IService<PCMPROFILESZYJTJ>{

    boolean save(PCMPROFILESZYJTJ et) ;
    void saveBatch(List<PCMPROFILESZYJTJ> list) ;
    boolean create(PCMPROFILESZYJTJ et) ;
    void createBatch(List<PCMPROFILESZYJTJ> list) ;
    PCMPROFILESZYJTJ getDraft(PCMPROFILESZYJTJ et) ;
    boolean checkKey(PCMPROFILESZYJTJ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMPROFILESZYJTJ get(String key) ;
    boolean update(PCMPROFILESZYJTJ et) ;
    void updateBatch(List<PCMPROFILESZYJTJ> list) ;
    Page<PCMPROFILESZYJTJ> searchDefault(PCMPROFILESZYJTJSearchContext context) ;
    Page<PCMPROFILESZYJTJ> searchYGLX(PCMPROFILESZYJTJSearchContext context) ;
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

    List<PCMPROFILESZYJTJ> getPcmprofileszyjtjByIds(List<String> ids) ;
    List<PCMPROFILESZYJTJ> getPcmprofileszyjtjByEntities(List<PCMPROFILESZYJTJ> entities) ;

}


