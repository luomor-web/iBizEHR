package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PimEnclosure;
import cn.ibizlab.ehr.core.pim.filter.PimEnclosureSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimEnclosure] 服务对象接口
 */
public interface IPimEnclosureService extends IService<PimEnclosure>{

    PimEnclosure getDraft(PimEnclosure et) ;
    boolean checkKey(PimEnclosure et) ;
    boolean save(PimEnclosure et) ;
    void saveBatch(List<PimEnclosure> list) ;
    boolean update(PimEnclosure et) ;
    void updateBatch(List<PimEnclosure> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimEnclosure et) ;
    void createBatch(List<PimEnclosure> list) ;
    PimEnclosure get(String key) ;
    Page<PimEnclosure> searchPCMPROFILE_FJ(PimEnclosureSearchContext context) ;
    Page<PimEnclosure> searchDefault(PimEnclosureSearchContext context) ;
    List<PimEnclosure> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<PimEnclosure> getPimenclosureByIds(List<String> ids) ;
    List<PimEnclosure> getPimenclosureByEntities(List<PimEnclosure> entities) ;

}


