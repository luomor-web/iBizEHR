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

import cn.ibizlab.ehr.core.pim.domain.PimVacation;
import cn.ibizlab.ehr.core.pim.filter.PimVacationSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimVacation] 服务对象接口
 */
public interface IPimVacationService extends IService<PimVacation>{

    boolean update(PimVacation et) ;
    void updateBatch(List<PimVacation> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimVacation getDraft(PimVacation et) ;
    boolean save(PimVacation et) ;
    void saveBatch(List<PimVacation> list) ;
    boolean create(PimVacation et) ;
    void createBatch(List<PimVacation> list) ;
    boolean checkKey(PimVacation et) ;
    PimVacation get(String key) ;
    Page<PimVacation> searchDefault(PimVacationSearchContext context) ;
    List<PimVacation> selectByPimpersonid(String pimpersonid) ;
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

    List<PimVacation> getPimvacationByIds(List<String> ids) ;
    List<PimVacation> getPimvacationByEntities(List<PimVacation> entities) ;

}


