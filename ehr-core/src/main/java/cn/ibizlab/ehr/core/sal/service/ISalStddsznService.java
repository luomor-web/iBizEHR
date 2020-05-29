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

import cn.ibizlab.ehr.core.sal.domain.SalStddszn;
import cn.ibizlab.ehr.core.sal.filter.SalStddsznSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStddszn] 服务对象接口
 */
public interface ISalStddsznService extends IService<SalStddszn>{

    boolean save(SalStddszn et) ;
    void saveBatch(List<SalStddszn> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalStddszn get(String key) ;
    boolean update(SalStddszn et) ;
    void updateBatch(List<SalStddszn> list) ;
    boolean create(SalStddszn et) ;
    void createBatch(List<SalStddszn> list) ;
    SalStddszn getDraft(SalStddszn et) ;
    boolean checkKey(SalStddszn et) ;
    Page<SalStddszn> searchDefault(SalStddsznSearchContext context) ;
    List<SalStddszn> selectByOrmorgid(String orgid) ;
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

    List<SalStddszn> getSalstddsznByIds(List<String> ids) ;
    List<SalStddszn> getSalstddsznByEntities(List<SalStddszn> entities) ;

}


