package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.PcmWzd0002;
import cn.ibizlab.ehr.core.trm.filter.PcmWzd0002SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmWzd0002] 服务对象接口
 */
public interface IPcmWzd0002Service extends IService<PcmWzd0002>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PcmWzd0002 et) ;
    void saveBatch(List<PcmWzd0002> list) ;
    PcmWzd0002 getDraft(PcmWzd0002 et) ;
    boolean checkKey(PcmWzd0002 et) ;
    PcmWzd0002 get(String key) ;
    boolean create(PcmWzd0002 et) ;
    void createBatch(List<PcmWzd0002> list) ;
    boolean update(PcmWzd0002 et) ;
    void updateBatch(List<PcmWzd0002> list) ;
    Page<PcmWzd0002> searchDefault(PcmWzd0002SearchContext context) ;
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

    List<PcmWzd0002> getPcmwzd0002ByIds(List<String> ids) ;
    List<PcmWzd0002> getPcmwzd0002ByEntities(List<PcmWzd0002> entities) ;

}


