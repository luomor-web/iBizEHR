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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdbxmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdbxmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdbxmx] 服务对象接口
 */
public interface IPcmYdbxmxService extends IService<PcmYdbxmx>{

    PcmYdbxmx get(String key) ;
    PcmYdbxmx fillPersonInfo(PcmYdbxmx et) ;
    PcmYdbxmx getDraft(PcmYdbxmx et) ;
    boolean update(PcmYdbxmx et) ;
    void updateBatch(List<PcmYdbxmx> list) ;
    boolean checkKey(PcmYdbxmx et) ;
    boolean save(PcmYdbxmx et) ;
    void saveBatch(List<PcmYdbxmx> list) ;
    PcmYdbxmx finishBX(PcmYdbxmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PcmYdbxmx et) ;
    void createBatch(List<PcmYdbxmx> list) ;
    Page<PcmYdbxmx> searchGLDS(PcmYdbxmxSearchContext context) ;
    Page<PcmYdbxmx> searchDefault(PcmYdbxmxSearchContext context) ;
    Page<PcmYdbxmx> searchJLDS(PcmYdbxmxSearchContext context) ;
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

    List<PcmYdbxmx> getPcmydbxmxByIds(List<String> ids) ;
    List<PcmYdbxmx> getPcmydbxmxByEntities(List<PcmYdbxmx> entities) ;

}


