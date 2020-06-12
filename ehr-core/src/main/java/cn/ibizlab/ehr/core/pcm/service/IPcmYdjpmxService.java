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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdjpmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjpmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdjpmx] 服务对象接口
 */
public interface IPcmYdjpmxService extends IService<PcmYdjpmx>{

    PcmYdjpmx fillPersonInfo(PcmYdjpmx et) ;
    boolean update(PcmYdjpmx et) ;
    void updateBatch(List<PcmYdjpmx> list) ;
    PcmYdjpmx getDraft(PcmYdjpmx et) ;
    boolean checkKey(PcmYdjpmx et) ;
    boolean save(PcmYdjpmx et) ;
    void saveBatch(List<PcmYdjpmx> list) ;
    PcmYdjpmx isFinished(PcmYdjpmx et) ;
    PcmYdjpmx get(String key) ;
    boolean create(PcmYdjpmx et) ;
    void createBatch(List<PcmYdjpmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmYdjpmx> searchJLDS(PcmYdjpmxSearchContext context) ;
    Page<PcmYdjpmx> searchDefault(PcmYdjpmxSearchContext context) ;
    Page<PcmYdjpmx> searchGLDS(PcmYdjpmxSearchContext context) ;
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

    List<PcmYdjpmx> getPcmydjpmxByIds(List<String> ids) ;
    List<PcmYdjpmx> getPcmydjpmxByEntities(List<PcmYdjpmx> entities) ;

}


