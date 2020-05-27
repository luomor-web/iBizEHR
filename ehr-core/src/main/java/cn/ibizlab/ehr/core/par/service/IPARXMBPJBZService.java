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

import cn.ibizlab.ehr.core.par.domain.PARXMBPJBZ;
import cn.ibizlab.ehr.core.par.filter.PARXMBPJBZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARXMBPJBZ] 服务对象接口
 */
public interface IPARXMBPJBZService extends IService<PARXMBPJBZ>{

    PARXMBPJBZ get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PARXMBPJBZ et) ;
    boolean update(PARXMBPJBZ et) ;
    void updateBatch(List<PARXMBPJBZ> list) ;
    boolean create(PARXMBPJBZ et) ;
    void createBatch(List<PARXMBPJBZ> list) ;
    boolean save(PARXMBPJBZ et) ;
    void saveBatch(List<PARXMBPJBZ> list) ;
    PARXMBPJBZ getDraft(PARXMBPJBZ et) ;
    Page<PARXMBPJBZ> searchDefault(PARXMBPJBZSearchContext context) ;
    List<PARXMBPJBZ> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PARXMBPJBZ> selectByXmbpjbzid(String parxmbpjbzid) ;
    void removeByXmbpjbzid(String parxmbpjbzid) ;
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

    List<PARXMBPJBZ> getParxmbpjbzByIds(List<String> ids) ;
    List<PARXMBPJBZ> getParxmbpjbzByEntities(List<PARXMBPJBZ> entities) ;

}


