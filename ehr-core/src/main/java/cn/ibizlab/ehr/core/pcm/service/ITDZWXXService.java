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

import cn.ibizlab.ehr.core.pcm.domain.TDZWXX;
import cn.ibizlab.ehr.core.pcm.filter.TDZWXXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TDZWXX] 服务对象接口
 */
public interface ITDZWXXService extends IService<TDZWXX>{

    boolean create(TDZWXX et) ;
    void createBatch(List<TDZWXX> list) ;
    TDZWXX getDraft(TDZWXX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TDZWXX et) ;
    void saveBatch(List<TDZWXX> list) ;
    boolean update(TDZWXX et) ;
    void updateBatch(List<TDZWXX> list) ;
    boolean checkKey(TDZWXX et) ;
    TDZWXX get(String key) ;
    Page<TDZWXX> searchDefault(TDZWXXSearchContext context) ;
    List<TDZWXX> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
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

    List<TDZWXX> getTdzwxxByIds(List<String> ids) ;
    List<TDZWXX> getTdzwxxByEntities(List<TDZWXX> entities) ;

}


