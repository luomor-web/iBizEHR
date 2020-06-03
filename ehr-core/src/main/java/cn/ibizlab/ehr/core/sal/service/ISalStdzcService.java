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

import cn.ibizlab.ehr.core.sal.domain.SalStdzc;
import cn.ibizlab.ehr.core.sal.filter.SalStdzcSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdzc] 服务对象接口
 */
public interface ISalStdzcService extends IService<SalStdzc>{

    boolean create(SalStdzc et) ;
    void createBatch(List<SalStdzc> list) ;
    SalStdzc get(String key) ;
    boolean save(SalStdzc et) ;
    void saveBatch(List<SalStdzc> list) ;
    SalStdzc getDraft(SalStdzc et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(SalStdzc et) ;
    void updateBatch(List<SalStdzc> list) ;
    boolean checkKey(SalStdzc et) ;
    Page<SalStdzc> searchDefault(SalStdzcSearchContext context) ;
    List<SalStdzc> selectByOrmorgid(String orgid) ;
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

    List<SalStdzc> getSalstdzcByIds(List<String> ids) ;
    List<SalStdzc> getSalstdzcByEntities(List<SalStdzc> entities) ;

}


