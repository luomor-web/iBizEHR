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

import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacLeaveDetail] 服务对象接口
 */
public interface IVacLeaveDetailService extends IService<VacLeaveDetail>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(VacLeaveDetail et) ;
    void createBatch(List<VacLeaveDetail> list) ;
    boolean update(VacLeaveDetail et) ;
    void updateBatch(List<VacLeaveDetail> list) ;
    VacLeaveDetail getNianJia(VacLeaveDetail et) ;
    boolean save(VacLeaveDetail et) ;
    void saveBatch(List<VacLeaveDetail> list) ;
    VacLeaveDetail get(String key) ;
    VacLeaveDetail calcPlanDays(VacLeaveDetail et) ;
    boolean checkKey(VacLeaveDetail et) ;
    VacLeaveDetail getDraft(VacLeaveDetail et) ;
    Page<VacLeaveDetail> searchDefault(VacLeaveDetailSearchContext context) ;
    List<VacLeaveDetail> selectByPimpersonid(String pimpersonid) ;
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

    List<VacLeaveDetail> getVacleavedetailByIds(List<String> ids) ;
    List<VacLeaveDetail> getVacleavedetailByEntities(List<VacLeaveDetail> entities) ;

}


