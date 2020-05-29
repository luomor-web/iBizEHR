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

import cn.ibizlab.ehr.core.pcm.domain.PCMJXSBDJL;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSBDJLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMJXSBDJL] 服务对象接口
 */
public interface IPCMJXSBDJLService extends IService<PCMJXSBDJL>{

    boolean checkKey(PCMJXSBDJL et) ;
    PCMJXSBDJL get(String key) ;
    boolean update(PCMJXSBDJL et) ;
    void updateBatch(List<PCMJXSBDJL> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PCMJXSBDJL et) ;
    void saveBatch(List<PCMJXSBDJL> list) ;
    boolean create(PCMJXSBDJL et) ;
    void createBatch(List<PCMJXSBDJL> list) ;
    PCMJXSBDJL getDraft(PCMJXSBDJL et) ;
    Page<PCMJXSBDJL> searchDefault(PCMJXSBDJLSearchContext context) ;
    Page<PCMJXSBDJL> searchZIZHU(PCMJXSBDJLSearchContext context) ;
    Page<PCMJXSBDJL> searchJLSS(PCMJXSBDJLSearchContext context) ;
    List<PCMJXSBDJL> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMJXSBDJL> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PCMJXSBDJL> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PCMJXSBDJL> selectByPimpersonid(String pimpersonid) ;
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

    List<PCMJXSBDJL> getPcmjxsbdjlByIds(List<String> ids) ;
    List<PCMJXSBDJL> getPcmjxsbdjlByEntities(List<PCMJXSBDJL> entities) ;

}


