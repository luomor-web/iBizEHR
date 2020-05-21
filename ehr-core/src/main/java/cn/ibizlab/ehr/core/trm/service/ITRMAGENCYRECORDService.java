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

import cn.ibizlab.ehr.core.trm.domain.TRMAGENCYRECORD;
import cn.ibizlab.ehr.core.trm.filter.TRMAGENCYRECORDSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMAGENCYRECORD] 服务对象接口
 */
public interface ITRMAGENCYRECORDService extends IService<TRMAGENCYRECORD>{

    TRMAGENCYRECORD getDraft(TRMAGENCYRECORD et) ;
    TRMAGENCYRECORD get(String key) ;
    boolean checkKey(TRMAGENCYRECORD et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMAGENCYRECORD et) ;
    void saveBatch(List<TRMAGENCYRECORD> list) ;
    boolean update(TRMAGENCYRECORD et) ;
    void updateBatch(List<TRMAGENCYRECORD> list) ;
    boolean create(TRMAGENCYRECORD et) ;
    void createBatch(List<TRMAGENCYRECORD> list) ;
    Page<TRMAGENCYRECORD> searchDefault(TRMAGENCYRECORDSearchContext context) ;
    List<TRMAGENCYRECORD> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
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

}


