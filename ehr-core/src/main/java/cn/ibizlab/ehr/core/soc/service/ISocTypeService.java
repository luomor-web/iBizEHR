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

import cn.ibizlab.ehr.core.soc.domain.SocType;
import cn.ibizlab.ehr.core.soc.filter.SocTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocType] 服务对象接口
 */
public interface ISocTypeService extends IService<SocType>{

    boolean create(SocType et) ;
    void createBatch(List<SocType> list) ;
    boolean update(SocType et) ;
    void updateBatch(List<SocType> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SocType et) ;
    void saveBatch(List<SocType> list) ;
    SocType getDraft(SocType et) ;
    SocType get(String key) ;
    boolean checkKey(SocType et) ;
    Page<SocType> searchDefault(SocTypeSearchContext context) ;
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

    List<SocType> getSoctypeByIds(List<String> ids) ;
    List<SocType> getSoctypeByEntities(List<SocType> entities) ;

}


