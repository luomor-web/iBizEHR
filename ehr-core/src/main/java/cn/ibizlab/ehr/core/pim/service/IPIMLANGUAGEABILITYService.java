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

import cn.ibizlab.ehr.core.pim.domain.PIMLANGUAGEABILITY;
import cn.ibizlab.ehr.core.pim.filter.PIMLANGUAGEABILITYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMLANGUAGEABILITY] 服务对象接口
 */
public interface IPIMLANGUAGEABILITYService extends IService<PIMLANGUAGEABILITY>{

    PIMLANGUAGEABILITY getDraft(PIMLANGUAGEABILITY et) ;
    PIMLANGUAGEABILITY get(String key) ;
    PIMLANGUAGEABILITY custRemove(PIMLANGUAGEABILITY et) ;
    boolean save(PIMLANGUAGEABILITY et) ;
    void saveBatch(List<PIMLANGUAGEABILITY> list) ;
    boolean checkKey(PIMLANGUAGEABILITY et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PIMLANGUAGEABILITY et) ;
    void updateBatch(List<PIMLANGUAGEABILITY> list) ;
    boolean create(PIMLANGUAGEABILITY et) ;
    void createBatch(List<PIMLANGUAGEABILITY> list) ;
    Page<PIMLANGUAGEABILITY> searchJLSSGR(PIMLANGUAGEABILITYSearchContext context) ;
    Page<PIMLANGUAGEABILITY> searchDefault(PIMLANGUAGEABILITYSearchContext context) ;
    Page<PIMLANGUAGEABILITY> searchJLSS(PIMLANGUAGEABILITYSearchContext context) ;
    Page<PIMLANGUAGEABILITY> searchZIZHU(PIMLANGUAGEABILITYSearchContext context) ;
    Page<PIMLANGUAGEABILITY> searchJLSSGLY(PIMLANGUAGEABILITYSearchContext context) ;
    List<PIMLANGUAGEABILITY> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMLANGUAGEABILITY> getPimlanguageabilityByIds(List<String> ids) ;
    List<PIMLANGUAGEABILITY> getPimlanguageabilityByEntities(List<PIMLANGUAGEABILITY> entities) ;

}


