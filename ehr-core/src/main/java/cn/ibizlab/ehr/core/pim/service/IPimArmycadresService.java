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

import cn.ibizlab.ehr.core.pim.domain.PimArmycadres;
import cn.ibizlab.ehr.core.pim.filter.PimArmycadresSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArmycadres] 服务对象接口
 */
public interface IPimArmycadresService extends IService<PimArmycadres>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimArmycadres getDraft(PimArmycadres et) ;
    boolean checkKey(PimArmycadres et) ;
    boolean create(PimArmycadres et) ;
    void createBatch(List<PimArmycadres> list) ;
    boolean update(PimArmycadres et) ;
    void updateBatch(List<PimArmycadres> list) ;
    PimArmycadres get(String key) ;
    boolean save(PimArmycadres et) ;
    void saveBatch(List<PimArmycadres> list) ;
    Page<PimArmycadres> searchDefault(PimArmycadresSearchContext context) ;
    Page<PimArmycadres> searchJLSSGLY(PimArmycadresSearchContext context) ;
    Page<PimArmycadres> searchJLSSGR(PimArmycadresSearchContext context) ;
    List<PimArmycadres> selectByPimpersonid(String pimpersonid) ;
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

    List<PimArmycadres> getPimarmycadresByIds(List<String> ids) ;
    List<PimArmycadres> getPimarmycadresByEntities(List<PimArmycadres> entities) ;

}


