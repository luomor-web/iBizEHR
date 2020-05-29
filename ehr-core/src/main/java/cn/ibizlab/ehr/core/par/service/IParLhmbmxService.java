package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParLhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParLhmbmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParLhmbmx] 服务对象接口
 */
public interface IParLhmbmxService extends IService<ParLhmbmx>{

    boolean checkKey(ParLhmbmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParLhmbmx et) ;
    void saveBatch(List<ParLhmbmx> list) ;
    ParLhmbmx getDraft(ParLhmbmx et) ;
    ParLhmbmx get(String key) ;
    boolean update(ParLhmbmx et) ;
    void updateBatch(List<ParLhmbmx> list) ;
    boolean create(ParLhmbmx et) ;
    void createBatch(List<ParLhmbmx> list) ;
    Page<ParLhmbmx> searchDefault(ParLhmbmxSearchContext context) ;
    List<ParLhmbmx> selectByParjxlhmbid(String parjxlhmbid) ;
    void removeByParjxlhmbid(String parjxlhmbid) ;
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

    List<ParLhmbmx> getParlhmbmxByIds(List<String> ids) ;
    List<ParLhmbmx> getParlhmbmxByEntities(List<ParLhmbmx> entities) ;

}


