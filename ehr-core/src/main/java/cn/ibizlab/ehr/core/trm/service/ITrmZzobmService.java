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

import cn.ibizlab.ehr.core.trm.domain.TrmZzobm;
import cn.ibizlab.ehr.core.trm.filter.TrmZzobmSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmZzobm] 服务对象接口
 */
public interface ITrmZzobmService extends IService<TrmZzobm>{

    boolean create(TrmZzobm et) ;
    void createBatch(List<TrmZzobm> list) ;
    boolean update(TrmZzobm et) ;
    void updateBatch(List<TrmZzobm> list) ;
    boolean checkKey(TrmZzobm et) ;
    TrmZzobm getDraft(TrmZzobm et) ;
    boolean save(TrmZzobm et) ;
    void saveBatch(List<TrmZzobm> list) ;
    TrmZzobm get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TrmZzobm> searchDefault(TrmZzobmSearchContext context) ;
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

    List<TrmZzobm> getTrmzzobmByIds(List<String> ids) ;
    List<TrmZzobm> getTrmzzobmByEntities(List<TrmZzobm> entities) ;

}


