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

import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEYJTJTEMP;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEYJTJTEMPSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPROFILEYJTJTEMP] 服务对象接口
 */
public interface IPCMPROFILEYJTJTEMPService extends IService<PCMPROFILEYJTJTEMP>{

    boolean update(PCMPROFILEYJTJTEMP et) ;
    void updateBatch(List<PCMPROFILEYJTJTEMP> list) ;
    PCMPROFILEYJTJTEMP getDraft(PCMPROFILEYJTJTEMP et) ;
    boolean create(PCMPROFILEYJTJTEMP et) ;
    void createBatch(List<PCMPROFILEYJTJTEMP> list) ;
    boolean checkKey(PCMPROFILEYJTJTEMP et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PCMPROFILEYJTJTEMP et) ;
    void saveBatch(List<PCMPROFILEYJTJTEMP> list) ;
    PCMPROFILEYJTJTEMP get(String key) ;
    Page<PCMPROFILEYJTJTEMP> searchDefault(PCMPROFILEYJTJTEMPSearchContext context) ;
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

    List<PCMPROFILEYJTJTEMP> getPcmprofileyjtjtempByIds(List<String> ids) ;
    List<PCMPROFILEYJTJTEMP> getPcmprofileyjtjtempByEntities(List<PCMPROFILEYJTJTEMP> entities) ;

}


