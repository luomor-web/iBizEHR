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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdjzmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjzmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdjzmx] 服务对象接口
 */
public interface IPcmYdjzmxService extends IService<PcmYdjzmx>{

    PcmYdjzmx getDraft(PcmYdjzmx et) ;
    boolean save(PcmYdjzmx et) ;
    void saveBatch(List<PcmYdjzmx> list) ;
    PcmYdjzmx rYHG(PcmYdjzmx et) ;
    PcmYdjzmx get(String key) ;
    boolean update(PcmYdjzmx et) ;
    void updateBatch(List<PcmYdjzmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmYdjzmx fillPersonInfo(PcmYdjzmx et) ;
    boolean checkKey(PcmYdjzmx et) ;
    boolean create(PcmYdjzmx et) ;
    void createBatch(List<PcmYdjzmx> list) ;
    Page<PcmYdjzmx> searchGLDS(PcmYdjzmxSearchContext context) ;
    Page<PcmYdjzmx> searchLSJLDS(PcmYdjzmxSearchContext context) ;
    Page<PcmYdjzmx> searchDefault(PcmYdjzmxSearchContext context) ;
    List<PcmYdjzmx> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PcmYdjzmx> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmYdjzmx> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PcmYdjzmx> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
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

    List<PcmYdjzmx> getPcmydjzmxByIds(List<String> ids) ;
    List<PcmYdjzmx> getPcmydjzmxByEntities(List<PcmYdjzmx> entities) ;

}


