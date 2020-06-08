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

import cn.ibizlab.ehr.core.pcm.domain.PcmJxsbdjl;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsbdjlSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmJxsbdjl] 服务对象接口
 */
public interface IPcmJxsbdjlService extends IService<PcmJxsbdjl>{

    boolean checkKey(PcmJxsbdjl et) ;
    PcmJxsbdjl get(String key) ;
    boolean update(PcmJxsbdjl et) ;
    void updateBatch(List<PcmJxsbdjl> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PcmJxsbdjl et) ;
    void saveBatch(List<PcmJxsbdjl> list) ;
    boolean create(PcmJxsbdjl et) ;
    void createBatch(List<PcmJxsbdjl> list) ;
    PcmJxsbdjl getDraft(PcmJxsbdjl et) ;
    Page<PcmJxsbdjl> searchDefault(PcmJxsbdjlSearchContext context) ;
    Page<PcmJxsbdjl> searchZIZHU(PcmJxsbdjlSearchContext context) ;
    Page<PcmJxsbdjl> searchJLSS(PcmJxsbdjlSearchContext context) ;
    List<PcmJxsbdjl> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmJxsbdjl> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PcmJxsbdjl> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PcmJxsbdjl> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<PcmJxsbdjl> getPcmjxsbdjlByIds(List<String> ids) ;
    List<PcmJxsbdjl> getPcmjxsbdjlByEntities(List<PcmJxsbdjl> entities) ;

}


