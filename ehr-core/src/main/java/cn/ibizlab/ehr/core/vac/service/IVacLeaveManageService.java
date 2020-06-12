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

import cn.ibizlab.ehr.core.vac.domain.VacLeaveManage;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveManageSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacLeaveManage] 服务对象接口
 */
public interface IVacLeaveManageService extends IService<VacLeaveManage>{

    VacLeaveManage updateQJMX(VacLeaveManage et) ;
    VacLeaveManage cB(VacLeaveManage et) ;
    VacLeaveManage getDraft(VacLeaveManage et) ;
    VacLeaveManage cX(VacLeaveManage et) ;
    boolean update(VacLeaveManage et) ;
    void updateBatch(List<VacLeaveManage> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    VacLeaveManage getFJSJofPerson(VacLeaveManage et) ;
    boolean save(VacLeaveManage et) ;
    void saveBatch(List<VacLeaveManage> list) ;
    boolean create(VacLeaveManage et) ;
    void createBatch(List<VacLeaveManage> list) ;
    VacLeaveManage get(String key) ;
    boolean checkKey(VacLeaveManage et) ;
    VacLeaveManage mobStart(VacLeaveManage et) ;
    Page<VacLeaveManage> searchFormType(VacLeaveManageSearchContext context) ;
    Page<VacLeaveManage> searchGR(VacLeaveManageSearchContext context) ;
    Page<VacLeaveManage> searchMOBJLSS(VacLeaveManageSearchContext context) ;
    Page<VacLeaveManage> searchJLSS(VacLeaveManageSearchContext context) ;
    Page<VacLeaveManage> searchDefault(VacLeaveManageSearchContext context) ;
    Page<VacLeaveManage> searchOnlySPTY(VacLeaveManageSearchContext context) ;
    List<VacLeaveManage> selectByPimpersonid(String pimpersonid) ;
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

    List<VacLeaveManage> getVacleavemanageByIds(List<String> ids) ;
    List<VacLeaveManage> getVacleavemanageByEntities(List<VacLeaveManage> entities) ;

}


