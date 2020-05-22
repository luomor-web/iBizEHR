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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINADDRESS;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINADDRESSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINADDRESS] 服务对象接口
 */
public interface ITRMTRAINADDRESSService extends IService<TRMTRAINADDRESS>{

    boolean save(TRMTRAINADDRESS et) ;
    void saveBatch(List<TRMTRAINADDRESS> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMTRAINADDRESS getDraft(TRMTRAINADDRESS et) ;
    boolean create(TRMTRAINADDRESS et) ;
    void createBatch(List<TRMTRAINADDRESS> list) ;
    boolean update(TRMTRAINADDRESS et) ;
    void updateBatch(List<TRMTRAINADDRESS> list) ;
    TRMTRAINADDRESS get(String key) ;
    boolean checkKey(TRMTRAINADDRESS et) ;
    Page<TRMTRAINADDRESS> searchDefault(TRMTRAINADDRESSSearchContext context) ;
    List<TRMTRAINADDRESS> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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


