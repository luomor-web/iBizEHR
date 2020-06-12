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

import cn.ibizlab.ehr.core.sal.domain.SalStdzyzg;
import cn.ibizlab.ehr.core.sal.filter.SalStdzyzgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdzyzg] 服务对象接口
 */
public interface ISalStdzyzgService extends IService<SalStdzyzg>{

    boolean update(SalStdzyzg et) ;
    void updateBatch(List<SalStdzyzg> list) ;
    SalStdzyzg get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SalStdzyzg et) ;
    void createBatch(List<SalStdzyzg> list) ;
    SalStdzyzg getDraft(SalStdzyzg et) ;
    boolean checkKey(SalStdzyzg et) ;
    boolean save(SalStdzyzg et) ;
    void saveBatch(List<SalStdzyzg> list) ;
    Page<SalStdzyzg> searchDefault(SalStdzyzgSearchContext context) ;
    List<SalStdzyzg> selectByOrmorgid(String orgid) ;
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

    List<SalStdzyzg> getSalstdzyzgByIds(List<String> ids) ;
    List<SalStdzyzg> getSalstdzyzgByEntities(List<SalStdzyzg> entities) ;

}


