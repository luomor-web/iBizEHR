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

import cn.ibizlab.ehr.core.vac.domain.VacSituationDetail;
import cn.ibizlab.ehr.core.vac.filter.VacSituationDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacSituationDetail] 服务对象接口
 */
public interface IVacSituationDetailService extends IService<VacSituationDetail>{

    boolean update(VacSituationDetail et) ;
    void updateBatch(List<VacSituationDetail> list) ;
    VacSituationDetail getDraft(VacSituationDetail et) ;
    boolean create(VacSituationDetail et) ;
    void createBatch(List<VacSituationDetail> list) ;
    VacSituationDetail get(String key) ;
    boolean checkKey(VacSituationDetail et) ;
    boolean save(VacSituationDetail et) ;
    void saveBatch(List<VacSituationDetail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<VacSituationDetail> searchDefault(VacSituationDetailSearchContext context) ;
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

    List<VacSituationDetail> getVacsituationdetailByIds(List<String> ids) ;
    List<VacSituationDetail> getVacsituationdetailByEntities(List<VacSituationDetail> entities) ;

}


