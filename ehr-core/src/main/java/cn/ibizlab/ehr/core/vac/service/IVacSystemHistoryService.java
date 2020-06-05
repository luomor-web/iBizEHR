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

import cn.ibizlab.ehr.core.vac.domain.VacSystemHistory;
import cn.ibizlab.ehr.core.vac.filter.VacSystemHistorySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacSystemHistory] 服务对象接口
 */
public interface IVacSystemHistoryService extends IService<VacSystemHistory>{

    boolean update(VacSystemHistory et) ;
    void updateBatch(List<VacSystemHistory> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(VacSystemHistory et) ;
    void saveBatch(List<VacSystemHistory> list) ;
    VacSystemHistory get(String key) ;
    boolean checkKey(VacSystemHistory et) ;
    boolean create(VacSystemHistory et) ;
    void createBatch(List<VacSystemHistory> list) ;
    VacSystemHistory getDraft(VacSystemHistory et) ;
    Page<VacSystemHistory> searchDefault(VacSystemHistorySearchContext context) ;
    List<VacSystemHistory> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<VacSystemHistory> selectByVacleavesystemid(String vacleavesystemid) ;
    void removeByVacleavesystemid(String vacleavesystemid) ;
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

    List<VacSystemHistory> getVacsystemhistoryByIds(List<String> ids) ;
    List<VacSystemHistory> getVacsystemhistoryByEntities(List<VacSystemHistory> entities) ;

}


