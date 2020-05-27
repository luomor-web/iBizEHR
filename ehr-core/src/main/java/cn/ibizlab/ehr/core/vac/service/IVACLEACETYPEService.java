package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACLEACETYPE;
import cn.ibizlab.ehr.core.vac.filter.VACLEACETYPESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACLEACETYPE] 服务对象接口
 */
public interface IVACLEACETYPEService extends IService<VACLEACETYPE>{

    boolean update(VACLEACETYPE et) ;
    void updateBatch(List<VACLEACETYPE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(VACLEACETYPE et) ;
    void createBatch(List<VACLEACETYPE> list) ;
    VACLEACETYPE getDraft(VACLEACETYPE et) ;
    boolean save(VACLEACETYPE et) ;
    void saveBatch(List<VACLEACETYPE> list) ;
    boolean checkKey(VACLEACETYPE et) ;
    VACLEACETYPE get(String key) ;
    Page<VACLEACETYPE> searchDefault(VACLEACETYPESearchContext context) ;
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

    List<VACLEACETYPE> getVacleacetypeByIds(List<String> ids) ;
    List<VACLEACETYPE> getVacleacetypeByEntities(List<VACLEACETYPE> entities) ;

}


