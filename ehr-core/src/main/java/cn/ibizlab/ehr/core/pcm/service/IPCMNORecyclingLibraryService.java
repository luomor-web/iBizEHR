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

import cn.ibizlab.ehr.core.pcm.domain.PCMNORecyclingLibrary;
import cn.ibizlab.ehr.core.pcm.filter.PCMNORecyclingLibrarySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMNORecyclingLibrary] 服务对象接口
 */
public interface IPCMNORecyclingLibraryService extends IService<PCMNORecyclingLibrary>{

    boolean create(PCMNORecyclingLibrary et) ;
    void createBatch(List<PCMNORecyclingLibrary> list) ;
    PCMNORecyclingLibrary getDraft(PCMNORecyclingLibrary et) ;
    PCMNORecyclingLibrary get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PCMNORecyclingLibrary et) ;
    void updateBatch(List<PCMNORecyclingLibrary> list) ;
    boolean checkKey(PCMNORecyclingLibrary et) ;
    boolean save(PCMNORecyclingLibrary et) ;
    void saveBatch(List<PCMNORecyclingLibrary> list) ;
    Page<PCMNORecyclingLibrary> searchDefault(PCMNORecyclingLibrarySearchContext context) ;
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

    List<PCMNORecyclingLibrary> getPcmnorecyclinglibraryByIds(List<String> ids) ;
    List<PCMNORecyclingLibrary> getPcmnorecyclinglibraryByEntities(List<PCMNORecyclingLibrary> entities) ;

}


