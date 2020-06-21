package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SocRecord;
import cn.ibizlab.ehr.core.soc.filter.SocRecordSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocRecord] 服务对象接口
 */
public interface ISocRecordService extends IService<SocRecord>{

    SocRecord get(String key) ;
    boolean save(SocRecord et) ;
    void saveBatch(List<SocRecord> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SocRecord et) ;
    void createBatch(List<SocRecord> list) ;
    boolean checkKey(SocRecord et) ;
    SocRecord getDraft(SocRecord et) ;
    boolean update(SocRecord et) ;
    void updateBatch(List<SocRecord> list) ;
    Page<SocRecord> searchDefault(SocRecordSearchContext context) ;
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

    List<SocRecord> getSocrecordByIds(List<String> ids) ;
    List<SocRecord> getSocrecordByEntities(List<SocRecord> entities) ;

}


