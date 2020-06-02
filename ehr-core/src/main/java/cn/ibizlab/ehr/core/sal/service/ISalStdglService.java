package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SalStdgl;
import cn.ibizlab.ehr.core.sal.filter.SalStdglSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdgl] 服务对象接口
 */
public interface ISalStdglService extends IService<SalStdgl>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(SalStdgl et) ;
    void updateBatch(List<SalStdgl> list) ;
    boolean create(SalStdgl et) ;
    void createBatch(List<SalStdgl> list) ;
    boolean checkKey(SalStdgl et) ;
    boolean save(SalStdgl et) ;
    void saveBatch(List<SalStdgl> list) ;
    SalStdgl get(String key) ;
    SalStdgl getDraft(SalStdgl et) ;
    Page<SalStdgl> searchDefault(SalStdglSearchContext context) ;
    List<SalStdgl> selectByOrmorgid(String orgid) ;
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

    List<SalStdgl> getSalstdglByIds(List<String> ids) ;
    List<SalStdgl> getSalstdglByEntities(List<SalStdgl> entities) ;

}


